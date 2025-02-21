class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        char d = 'N';
        for(int i = 0;i<instructions.length();i++){
            if(instructions.charAt(i) == 'G'){
                if(d == 'N'){
                    y+=1;
                }
                else if(d == 'S'){
                    y-=1;
                }
                else if(d == 'E'){
                    x+=1;
                }
                else if(d == 'W'){
                    x-=1;
                }
            }
            else if(instructions.charAt(i) == 'R'){
                if(d == 'N'){
                    d = 'E';
                }
                else if(d == 'S'){
                    d = 'W';
                }
                else if(d == 'E'){
                    d = 'S';
                }
                else if(d == 'W'){
                    d = 'N';
                }
            }
            else if(instructions.charAt(i) == 'L'){
                if(d == 'N'){
                    d = 'W';
                }
                else if(d == 'S'){
                    d = 'E';
                }
                else if(d == 'E'){
                    d = 'N';
                }
                else if(d == 'W'){
                    d = 'S';
                }
            }
        }
        if((d == 'N') && !(x== 0 && y == 0)){
            return false;
        }
        return true;
    }
}