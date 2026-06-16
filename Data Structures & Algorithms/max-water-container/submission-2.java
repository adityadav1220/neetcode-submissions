class Solution {
    public int maxArea(int[] height) {
        
        int i=0;
        int j=height.length-1;
        int amt=Integer.MIN_VALUE;
        while(i<j){
            amt=Math.max(Math.min(height[i],height[j])*(j-i),amt);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return amt;
    }
}