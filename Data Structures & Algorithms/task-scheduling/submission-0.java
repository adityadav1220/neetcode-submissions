class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<abc> maxHeap = new PriorityQueue<>((x,y) -> Integer.compare(y.num,x.num));
        HashMap<Character,Integer> hp=new HashMap<>();

        for(int i=0;i<tasks.length;i++){
            char c=tasks[i];
            if(hp.containsKey(c)){
                hp.put(c,hp.get(c)+1);
            }
            else{
                hp.put(c,1);
            }
        }

        for(Map.Entry<Character,Integer> entry:hp.entrySet()){
            char key=entry.getKey();
            int value=entry.getValue();
            maxHeap.offer(new abc(value,key,0));
        }

        Queue<abc> cooldown=new LinkedList<>();
        int time=0;

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            while(!cooldown.isEmpty() && cooldown.peek().readyTime<=time){
                maxHeap.offer(cooldown.poll());
            }

            if(!maxHeap.isEmpty()){
                abc b=maxHeap.poll();
                b.num=b.num-1;

                if(b.num>0){
                    b.readyTime=time+n+1;
                    cooldown.offer(b);
                }
            }
            
            time++;
        }

        return time;
    }
}

class abc{
    int num;
    Character word;
    int readyTime;

    abc(int num,Character word, int readTime){
        this.num=num;
        this.word=word;
        this.readyTime=readyTime;
    }
}

