// Time complexity :  O(V+E)  where V = vertices , E= Edges
// Space complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Logic: using a topological sort approach with a queue.
//Create an indegree array and an adjacency list to track prerequisites and build the graph.
//Initialize a queue with all courses having zero prerequisites and process each course, reducing the indegree of dependent courses.
//If all courses are processed (count equals numCourses), return true; otherwise, return false.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }

        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count =0;
        for(int[] prerequisite : prerequisites){
            int from = prerequisite[1];
            int to = prerequisite[0];
            indegree[to]++;
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }
        for(int i = 0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            if(!map.containsKey(curr)){
                continue;
            }
            List<Integer> edges = map.get(curr);
            if(edges == null){
                continue;
            }
            for(int edge:edges){
                indegree[edge]--;
                if(indegree[edge] == 0){
                    q.add(edge);
                    count++;
                }
            }
        }

        return count == numCourses;
    }
}