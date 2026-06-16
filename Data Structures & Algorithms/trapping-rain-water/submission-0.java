class Solution {
    public int trap(int[] height) {
        int result=0;
        int[] pf=new int[height.length];
        int[] sf=new int[height.length];
        pf[0]=height[0];
        sf[height.length-1]=height[height.length-1];
        for(int i=1;i<pf.length;i++){
            pf[i]=Math.max(pf[i-1],height[i]);
        }
        for(int i=sf.length-2;i>=0;i--){
            sf[i]=Math.max(sf[i+1],height[i]);
        }

        for(int i=1;i<height.length-1;i++){
            int temp=Math.min(pf[i-1],sf[i+1])-height[i];
            if(temp>0){
                result=result+temp;
            }
        }
        return result;
    }
}
