class Twitter {
    int time=0;
    HashMap<Integer,User> hm=new HashMap<>();
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!hm.containsKey(userId)){
            User a=new User(userId);
            hm.put(userId,a);
        }
        User u=hm.get(userId);
        u.tweets.add(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        int count=10;
        PriorityQueue<Tweet> maxHeap= new PriorityQueue<>(
            (a,b) -> Integer.compare(b.timeStamp,a.timeStamp)
        );
        ArrayList<Integer> res=new ArrayList<>();
        if(hm.containsKey(userId)){
            User a=hm.get(userId);
            int p=a.tweets.size();
            int q=0;
            while(q<p){
                maxHeap.offer(a.tweets.get(q));
                q++;
            }
            HashSet<Integer> s=a.follows;
            int r=s.size();
            if(r>0){
                for(int followeeId:s){
                    User followee=hm.get(followeeId);
                    int t=followee.tweets.size();
                    int w=0;
                    while(w<t){
                        maxHeap.offer(followee.tweets.get(w));
                        w++;
                    }
                }
            }
            
            if(maxHeap.size()>=10){
                int h=10;
                while(h>0 ){
                    res.add(maxHeap.poll().tweetId);
                    h--;
                }
            }
            else{
                int size=maxHeap.size();
                while(size>0){
                    res.add(maxHeap.poll().tweetId);
                    size--;
                }
            }


        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId){return;}
        if (!hm.containsKey(followerId)) {
            hm.put(followerId, new User(followerId));
        }

        if (!hm.containsKey(followeeId)) {
            hm.put(followeeId, new User(followeeId));
        }

        hm.get(followerId).follows.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (hm.containsKey(followerId)) {
            hm.get(followerId).follows.remove(followeeId);
        }
    }
}

class User{
    public User(){}

    int id;
    HashSet<Integer> follows;
    ArrayList<Tweet> tweets;

    User(int id){
        this.id=id;
        this.follows=new HashSet<>();
        this.tweets=new ArrayList<>();
    }
}

class Tweet{
    public Tweet(){}

    int tweetId;
    int timeStamp;

    Tweet(int tweetId,int timeStamp){
        this.tweetId=tweetId;
        this.timeStamp=timeStamp;
    }
}