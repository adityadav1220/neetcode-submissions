class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> smap=new HashMap<>();
        HashMap<Character,Integer> tmap=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!smap.containsKey(c)){
                smap.put(c,1);
            }
            else{
                smap.put(c,smap.get(c)+1);
            }
        }

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(!tmap.containsKey(c)){
                tmap.put(c,1);
            }
            else{
                tmap.put(c,tmap.get(c)+1);
            }
        }

        if(smap.size() != tmap.size()){return false;}

        for(var e : smap.entrySet()){
            char c=e.getKey();
            if(!tmap.containsKey(c)){return false;}
            else{
                if(!tmap.get(c).equals(e.getValue())){return false;}
            }
        }
        return true;
    }
}
