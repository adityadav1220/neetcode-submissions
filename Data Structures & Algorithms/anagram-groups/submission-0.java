class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<HashMap<Character,Integer>> temp=new ArrayList<>();
        if(strs.length==1){
            List<String> one = new ArrayList<>();
            one.add(strs[0]);
            result.add(one);
            return result;
        }
        for(int i=0;i<strs.length;i++){
            temp.add(converToDict(strs[i]));
        }

        for(int i=0;i<temp.size()-1;i++){
            //int count=0;
            if(temp.get(i)==null){continue;}
            List<String> mid=new ArrayList<>();
            for(int j=i+1;j<temp.size();j++){
                if(temp.get(j)==null || temp.get(i).size()!=temp.get(j).size()){
                    continue;
                }
                else{
                    if(checkAnagrams(temp.get(i),temp.get(j))){
                        mid.add(strs[j]);
                        temp.set(j,null);
                    }
                }
                
            }
            mid.add(strs[i]);
            result.add(mid);
        }
        if(temp.get(temp.size()-1)!=null){
            List<String> last = new ArrayList<>();
            last.add(strs[temp.size()-1]);
            result.add(last);
        }
        return result;

    }

    public HashMap<Character, Integer> converToDict(String str){
        HashMap<Character, Integer> res=new HashMap<>();
        for(int i=0;i<str.length();i++){
            Character c=str.charAt(i);
            if(res.containsKey(c)){
                res.put(c,res.get(c)+1);
            }
            else{
                res.put(c,1);
            }
        }
        return res;
    }

    public Boolean checkAnagrams(HashMap<Character,Integer> dict1,HashMap<Character,Integer> dict2){
        for(var e: dict1.entrySet()){
            var key=e.getKey();
            var val=e.getValue();
            if(!dict2.containsKey(key)){return false;}
            else{
                if(val!=dict2.get(key)){return false;}
            }
        }
        return true;
    }
}