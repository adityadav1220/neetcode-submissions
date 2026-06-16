class Solution {

    public String encode(List<String> strs) {
        StringBuilder res=new StringBuilder();


        for(int i=0;i<strs.size();i++){
            String x=strs.get(i);
            for(int j=0;j<x.length();j++){
                Character c=x.charAt(j);
                int code=(int) c + 8;
                char ch=(char) code;
                res.append(ch);
            }
            res.append("₹");
        }

        String s=res.toString();
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res=new ArrayList<>();

        StringBuilder currword=new StringBuilder();
        for(int i=0;i<str.length();i++){
            Character c=str.charAt(i);
            if(c=='₹'){
                System.out.println(currword);
                res.add(currword.toString());
                currword.setLength(0);
            }
            else{
                int code=(int) c - 8;
                char ch=(char) code;
                currword.append(ch);
            }
        }

        return res;




    }
}
