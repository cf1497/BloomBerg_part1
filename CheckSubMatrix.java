package Algorithm_Part1;

public class CheckSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,10,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] subMatrix = {{10,11,12},{14,15,16}};
		System.out.println(isSubMatrix(matrix,subMatrix));

	}
	
	public static boolean isSubMatrix(int[][] matrix, int[][] subMatrix){
		
		int i, j;
		for( i=0; i<matrix.length; i++){
			for( j=0; j<matrix[0].length; j++){
				if(matrix[i][j] == subMatrix[0][0]){
					if(isValid(matrix,subMatrix,i,j)){
						return true;
					}
				}
			}
		}
		
		return false;
	}

	private static boolean isValid(int[][] matrix, int[][] subMatrix, int i, int j) {
		
		if((matrix.length!=subMatrix.length+i) || (matrix[0].length!=subMatrix[0].length+j)){
			return false;
		}
		
		for(int x = 0; x<subMatrix.length; x++){
			for(int y=0; y<subMatrix[0].length; y++){
				if(matrix[i+x][j+y]!=subMatrix[x][y])
					return false;
			}
		}
		
		
		return true;
	}

}
