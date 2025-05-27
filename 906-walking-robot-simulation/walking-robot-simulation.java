class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        int x = 0;
        int y = 0;
        int dir = 0;
        Set<String> obsSet = new HashSet<>();
            for (int[] obs : obstacles) {
                obsSet.add(obs[0] + "," + obs[1]);
            }
        for(int i = 0;i<commands.length;i++){
            if(commands[i] > 0){
                if(dir == 0){
                    for(int k = 0;k<commands[i];k++){
                        if(obsSet.contains(x + "," + (y+1))){
                            continue;
                        }
                        else{
                            y+=1;
                        }
                        // if(isObstacle(y+1,x,obstacles) == false){
                        //     y+=1;
                        // }
                        // else{
                        //     continue;
                        // }
                    }
                }
                else if(dir == 1){
                    for(int k = 0;k<commands[i];k++){
                        if(obsSet.contains(x+1 + "," + (y))){
                            continue;
                        }
                        else{
                            x+=1;
                        }
                        // if(isObstacle(y,x+1,obstacles) == false){
                        //     x+=1;
                        // }
                        // else{
                        //     continue;
                        // }
                    }
                }
                else if(dir == 2){
                    for(int k = 0;k<commands[i];k++){
                        if(obsSet.contains(x-1 + "," + (y))){
                            continue;
                        }
                        else{
                            x-=1;
                        }
                        // if(isObstacle(y,x-1,obstacles) == false){
                        //     x-=1;
                        // }
                        // else{
                        //     continue;
                        // }
                    }
                }
                else{
                    for(int k = 0;k<commands[i];k++){
                        if(obsSet.contains(x + "," + (y-1))){
                            continue;
                        }
                        else{
                            y-=1;
                        }
                        // if(isObstacle(y-1,x,obstacles) == false){
                        //     y-=1;
                        // }
                        // else{
                        //     continue;
                        // }
                    }
                }
            }
            else{
                if(dir == 0){
                    if(commands[i] == -1){
                        dir = 1;
                    }
                    else{
                        dir = 2;
                    }
                }
                else if(dir == 1){
                    if(commands[i] == -1){
                        dir = 3;
                    }
                    else{
                        dir = 0;
                    }
                }
                else if(dir == 2){
                    if(commands[i] == -1){
                        dir = 0;
                    }
                    else{
                        dir = 3;
                    }
                }
                else{
                    if(commands[i] == -1){
                        dir = 2;
                    }
                    else{
                        dir = 1;
                    }
                }
            }
            result = Math.max(result,x*x + y*y);
        }
        return result;
    }
    public boolean isObstacle(int y,int x,int[][] obstacles){
        for(int i = 0;i<obstacles.length;i++){
            if(obstacles[i][0] == x && obstacles[i][1] == y){
                return true;
            }
        }
        return false;
    }
}