class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashMap<Integer, ArrayList<int[]>> map=new HashMap<>();
        HashMap<Integer, Integer> mapp=new HashMap<>();
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];

            int a=calc(x,y);
            minHeap.offer(a);
            int[] b=new int[]{x,y};
            if(!map.containsKey(a)){
                map.put(a,new ArrayList<>());
            }
            map.get(a).add(b);
            if(mapp.containsKey(a)){
                mapp.put(a,mapp.get(a)+1);
            }
            else{
                mapp.put(a,1);
            }
            
        }
        ArrayList<int[]> list=new ArrayList<>();
        while(k>0 && minHeap.size()>0){
            int a=minHeap.poll();
            int[] b=null;
            if(mapp.containsKey(a)){
                b=map.get(a).get(0);
                if(mapp.get(a)>1){
                    mapp.put(a,mapp.get(a)-1);
                }
                else{
                    mapp.remove(a);
                }
                map.get(a).remove(0);
            }
            list.add(b);
            k--;
        }

        return list.toArray(new int[list.size()][]);

    }

    public int calc(int a, int b){
        return ((a*a) + (b*b));
    }
}
