class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            char[] temp=new char[9];
            for(int j=0;j<board.length;j++){
                temp[j]=board[i][j];
            }
            if(!checkdupe(temp)){return false;}
        }

        for(int i=0;i<board.length;i++){
            char[] temp=new char[9];
            for(int j=0;j<board.length;j++){
                temp[j]=board[j][i];
            }
            if(!checkdupe(temp)){return false;}
        }

        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                ArrayList<Character> temp=new ArrayList<>();
                for(int x=i;x<i+3;x++){
                    for(int y=j;y<j+3;y++){
                        temp.add(board[x][y]);
                    }
                }
                if(!checkdupe(temp)){return false;}
            }
        }

        return true;
    }

    public boolean checkdupe(char[] arr){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            if(c=='.'){continue;}
            else{
                if(map.containsKey(c)){
                    return false;    
                }   
                else{
                    map.put(c,1);
                }
            }
        }
        return true;
    }

    public boolean checkdupe(ArrayList<Character> arr){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<arr.size();i++){
            char c=arr.get(i);
            if(c=='.'){continue;}
            else{
                if(map.containsKey(c)){
                    return false;
                }
                else{
                    map.put(c,1);
                }
            }
        }
        return true;
    }
}