class Solution {
    public boolean isPalindrome(String s) {
        ArrayList<Character> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            int code=(int) c;
            if((code>=65 && code<=90) || (code>=97 && code<=122) || (code>=48 && code<=57)){
                list.add(Character.toLowerCase(c));
            }
        }
        //Boolean res=false;
        int i=0;
        int j=list.size()-1;
        //if(list.size()==1){return false;}
        while(i<j){
            if(list.get(i)==list.get(j)){
                i++;
                j--;
                //System.out.println(list.get(i)+"=="+list.get(j)+"     "+i+","+j);
            }
            else{
                return false;
            }
        }
        return true;
    }
}