class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res=new HashSet<>();

        Arrays.sort(nums);
        for(int j=1;j<nums.length-1;j++){
            int i=0;
            int k=nums.length-1;
            int sum=0-nums[j];
            while(i<j && k>j){
                if(nums[i]+nums[k]==sum){
                    List<Integer> inner=new ArrayList<>();
                    inner.add(nums[i]);
                    inner.add(nums[j]);
                    inner.add(nums[k]);
                    res.add(inner);
                    i++;
                    k--;
                }
                else if(nums[i]+nums[k]<sum){
                    i++;
                }
                else{
                    k--;
                }
            }
        }
        List<List<Integer>> result=new ArrayList<>(res);
        return result;
    }
}