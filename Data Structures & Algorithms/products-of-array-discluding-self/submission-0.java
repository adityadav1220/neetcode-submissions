class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pf=new int[nums.length];
        int[] sf=new int[nums.length];
        int[] res=new int[nums.length];
        pf[0]=1;
        sf[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            pf[i]=pf[i-1]*nums[i-1];
        }
        for(int j=nums.length-2;j>=0;j--){
            sf[j]=sf[j+1]*nums[j+1];
        }

        for(int i=0;i<nums.length;i++){
            res[i]=pf[i]*sf[i];
        }
        return res;
    }
}