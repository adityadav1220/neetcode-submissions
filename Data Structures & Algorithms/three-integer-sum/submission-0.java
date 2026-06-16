class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res=new HashSet<>();

        for(int j=1;j<nums.length-1;j++){
            for(int i=0;i<j;i++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> inner=new ArrayList<>();
                        if(nums[i]>=nums[j] && nums[i]>=nums[k]){
                            inner.add(nums[i]);
                            if(nums[j]>=nums[k]){
                                inner.add(nums[j]);
                                inner.add(nums[k]);
                            }
                            else{
                                inner.add(nums[k]);
                                inner.add(nums[j]);
                            }
                        }
                        else if(nums[j]>=nums[i] && nums[j]>=nums[k]){
                            inner.add(nums[j]);
                            if(nums[i]>=nums[k]){
                                inner.add(nums[i]);
                                inner.add(nums[k]);
                            }
                            else{
                                inner.add(nums[k]);
                                inner.add(nums[i]);
                            }
                        }
                        else{
                            inner.add(nums[k]);
                            if(nums[i]>=nums[j]){
                                inner.add(nums[i]);
                                inner.add(nums[j]);
                            }
                            else{
                                inner.add(nums[j]);
                                inner.add(nums[i]);
                            }
                        }
                        res.add(inner);
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }
}