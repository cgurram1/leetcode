class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int count = 0;
        int [] inDegrees = new int[numCourses];
        for(int i = 0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegrees[prerequisites[i][0]]+=1;
        }
        Stack<Integer> stack = new Stack();
        for(int i = 0;i<inDegrees.length;i++){
            if(inDegrees[i] == 0){
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int currentCourse = stack.pop();
            count+=1;
            for(int nextCourse : graph.get(currentCourse)){
                inDegrees[nextCourse]-=1;
                if(inDegrees[nextCourse] == 0){
                    stack.push(nextCourse);
                }
            }
        }
        if(count == numCourses){
            return true;
        }
        return false;
    }
}