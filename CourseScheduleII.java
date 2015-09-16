package Algorithm_Part1;
import java.util.*;

public class CourseScheduleII {
	
	 public static void main(String[] args){
         int[][] nums = {{1,0},{2,3},{1,2},{0,2}};
        // System.out.println(canFinishBFS(4,nums));
         //System.out.println(canFinishDFS(4,nums));
         int[] result = findOrder(4, nums);
         for(int n: result){
        	 System.out.print(n+" ");
         }

    }
	 
	public static int[] findOrder(int courseNum, int[][] pres){
		int[] result = new int[courseNum];
		
		int[] preCount = new int[courseNum];
		
		int len = pres.length;
		
		for(int i=0; i<len; i++){
			preCount[pres[i][0]]++;
		}
		
		for(int k: preCount){
			System.out.print(k+" ");			
		}
		System.out.println();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0; i<preCount.length; i++){
			if(preCount[i]==0){
				queue.add(i);
			}
		}
		
		int index=0;
		
		while(!queue.isEmpty()){
			int top = queue.poll();
			//System.out.println("index:"+index+"  top: "+top);
			result[index++]=top;
			for(int i=0; i<len; i++){
				if(pres[i][1]==top){
					preCount[pres[i][0]]--;
					if(preCount[pres[i][0]]==0){
						queue.add(pres[i][0]);
					}
				}
			}
		}
		
		return result;
	}
	
}
