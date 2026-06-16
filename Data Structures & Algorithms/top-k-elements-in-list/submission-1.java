class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int x=0;
        int[] result=new int[k];
        while(x<k){
            int maxfreq=Integer.MIN_VALUE;
            int maxkey=0;
            for(var e:map.entrySet()){
                var key=e.getKey();
                var val=e.getValue();
                if(val==null){continue;}
                maxfreq=Math.max(maxfreq,val);
                if(maxfreq==val){
                    maxkey=key;
                }
            }
            result[x]=maxkey;
            map.put(maxkey, null);
            x++;
        }


        return result;
    }
}