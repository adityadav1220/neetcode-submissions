class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            maxHeap.offer(stones[i]);
        }
        while(maxHeap.size()>1){
            int a=maxHeap.poll();
            if(!maxHeap.isEmpty()){
                int b=maxHeap.poll();
                if(a!=b){maxHeap.offer(a-b);}
            }
        }
        if(maxHeap.size()==0){return 0;}
        int x=maxHeap.poll();
        return x;
    }
}
