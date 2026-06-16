class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        if(nums.length==0){return 0;}
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        ArrayList<Integer> startnums=new ArrayList<>();
        for(Integer x: set){
            if(!set.contains(x-1) && set.contains(x+1)){
                startnums.add(x);
            }
        }
        if(startnums.size()==0){return 1;}
        int n=set.size();
        int i=0;
        int seq=1;
        int tempnum=startnums.get(0);
        int x=0;
        int maxseq=Integer.MIN_VALUE;
        while(x<n){
            if(set.contains(tempnum+1)){
                seq=seq+1;
                tempnum++;
            }
            else{
                maxseq=Math.max(maxseq,seq);
                if(i<startnums.size()-1){
                    i=i+1;
                    tempnum=startnums.get(i);
                    seq=1;
                }

            }
            x++;
        }
        return maxseq;
    }
}