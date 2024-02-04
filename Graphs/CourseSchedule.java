// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

 

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

// Constraints:

// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.

import java.util.* ; 

class Solution {
    List<List<Integer>> graph ; 
    boolean res = true ; 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true ;
        graph = new ArrayList<>() ; 
        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>()) ; 
        }
        for(int courses[] : prerequisites){
            int prereq = courses[1] ;
            int course = courses[0] ; 
            graph.get(course).add(prereq) ; 
        }
        System.out.println(graph) ;
        for(int i= 0 ; i < numCourses ; i++){
            if(!dfs(graph , new HashSet<>() , i)) return false   ; 
        }
        return true ; 
    }

    public boolean dfs(List<List<Integer>> graph , HashSet<Integer> vis , int curr){
        if(vis.contains(curr)) return false ; 
        
        if(graph.get(curr).size() == 0 ) return true ; 
        vis.add(curr) ;
        for(int i=0 ; i<graph.get(curr).size() ;i++ ){
            if (!dfs(graph , vis , graph.get(curr).get(i))) return false ;  ; 
        }
        graph.set(curr , new ArrayList<Integer>() ); 
        vis.remove(curr) ; 
        return true ; 
    }
}
