class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        int j=k;
        Arrays.sort(nums);
        int i=nums.length-1;
        while(j>0 && i>=0){
            pq.offer(nums[i]);
            i--;
            j--;
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
