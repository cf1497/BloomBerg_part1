package Algorithm_PART1;

import java.util.*;

public class CourseSchedule {
      
	public static void main(String[] args){
	     int[][] nums = {{1,0},{2,3},{1,2},{0,2}};
	     System.out.println(canFinishBFS(4,nums));
	     System.out.println(canFinishDFS(4,nums));

	     
	}
	
	// BFS Vesion
	public static boolean canFinishBFS(int numCourses, int[][] pres){
		if(pres.length==0 || pres[0].length==0){
			return false;
		}
		
		int len = pres.length;
		if(len==0 || numCourses==0){
			return true;
		}
		
		//counter for number of pres
		int[] preCount = new int[len];
		for(int i=0; i<len; i++){
			preCount[pres[i][0]]++;
		}
		
		//stores the courses that has no pres
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<len; i++){
			if(preCount[i]==0) queue.add(i);
		}
		
		int numPre = queue.size();
		
		while(!queue.isEmpty()){
			int top = queue.poll();
			for(int i=0; i<len; i++){
				if(pres[i][1]==top){
					preCount[pres[i][0]]--;
					if(preCount[pres[i][0]]==0){
						queue.add(pres[i][0]);
						numPre++;
					}
				}
			}
		}
		
		return numPre == numCourses;
	}
	
	
	//DFS Version
	
	public static boolean canFinishDFS(int courseNums, int[][] pres){
		int len = pres.length;
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0; i<len; i++){
			if(map.containsKey(pres[i][1])){
				map.get(pres[i][1]).add(pres[i][0]);
			}else{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(pres[i][0]);
				map.put(pres[i][1], list);
			}
		}
		
		int[] visit = new int[len];
		
		for(int i=0; i<len;i++){
			if(!dfs(map, visit, i)) return false;
		}
		
		return true;
	}
	
	public static boolean dfs(HashMap<Integer, ArrayList<Integer>> map, int[] visit, int i){
		if(visit[i]==-1){
			return false;
		}
		
		if(visit[i]==1){
			return true;
		}
		
		visit[i] = -1;
		
		if(map.containsKey(i)){
			for(int n:map.get(i)){
				if(!dfs(map,visit,n)){
					return false;
				}
			}
		}
		visit[i]=1;
		
		return true;
	}

}





















