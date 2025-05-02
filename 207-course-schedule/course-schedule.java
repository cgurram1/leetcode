class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int [] inDegrees = new int[numCourses];
        for(int i = 0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegrees[prerequisites[i][0]]+=1;
        }
        int coursesFinished = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(inDegrees[i] == 0){
                queue.add(i);
                coursesFinished+=1;
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i = 0;i<adjList.get(curr).size();i++){
                inDegrees[adjList.get(curr).get(i)]-=1;
                if(inDegrees[adjList.get(curr).get(i)] == 0){
                    queue.add(adjList.get(curr).get(i));
                    coursesFinished+=1;
                }
            }
        }
        if(coursesFinished == numCourses){
            return true;
        }
        return false;
    }
}