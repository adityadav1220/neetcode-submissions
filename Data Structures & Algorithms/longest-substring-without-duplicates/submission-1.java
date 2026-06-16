class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count=0;
        for(int i=0;i<s.length()-1;i++){
            char x=s.charAt(i);
            int j=i+1;
            HashMap<Character,Integer> temp=new HashMap<>();
            temp.put(x,1);
            int tempCount=1;
            while(j<s.length()){
                char y=s.charAt(j);
                if(temp.containsKey(y)){break;}
                else{
                    temp.put(y,1);
                    tempCount++;
                }
                j++;
            }
            count=Math.max(count,tempCount);
        }
        if(s.length()==0){return 0;}
        if(s.length()==1){return 1;}
        return count;
    }
}
