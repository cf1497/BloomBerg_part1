package Algorithm_Part1;
import java.util.*;

public class SurroundedRegions {
	
	public static void main(String[] args){
		char[][] board = {{'X','X','X','O'},
				          {'X','O','X','X'},                 
		                  {'X','X','O','X'},
		                  {'X','O','X','X'}};
		
		solve(board);
		
		for(char[] n:board){
			for(char c:n) System.out.print(c+" ");
			System.out.println();
		}
	}
	
	
	public static void solve(char[][] board){
		if(board.length==0 || board[0].length==0){
			return ;
		}
		
		int m = board.length,  n=board[0].length;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<m; i++){
			helper(board,i,0,queue);
			helper(board,i,n-1,queue);
		}
		
		for(int j=1; j<n-1; j++){
			helper(board,0,j,queue);
			helper(board,m-1,j,queue);
		}
		
		while(!queue.isEmpty()){
			int cur = queue.poll();
			int x = cur/n;
			int y = cur%n;
			
			board[x][y]='D';
					
			helper(board,x-1,y,queue);
			helper(board,x+1,y,queue);
			helper(board,x,y-1,queue);
			helper(board,x,y+1,queue);	
		}
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(board[i][j]=='D'){
					board[i][j]='O';
				}else if(board[i][j]=='O'){
					board[i][j]='X';
				}
			}
		}
	}
	
	public static  void helper(char[][] board, int x, int y, Queue<Integer> queue){
		if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]=='O'){
			  queue.add(x*board[0].length+y);
		}
	}
}
