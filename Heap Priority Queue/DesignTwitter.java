// Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

// Implement the Twitter class:

// Twitter() Initializes your twitter object.
// void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
// List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
// void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
// void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 

// Example 1:

// Input
// ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
// [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
// Output
// [null, null, [5], null, null, [6, 5], null, [5]]

// Explanation
// Twitter twitter = new Twitter();
// twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
// twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
// twitter.follow(1, 2);    // User 1 follows user 2.
// twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
// twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
// twitter.unfollow(1, 2);  // User 1 unfollows user 2.
// twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
 

// Constraints:

// 1 <= userId, followerId, followeeId <= 500
// 0 <= tweetId <= 104
// All the tweets have unique IDs.
// At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and unfollow.

import java.util.* ; 

class Twitter {
    int count ; 
    HashMap<Integer , HashSet<Integer>> followerMap ; 
    HashMap<Integer , List<int[]>> tweetMap ; 
    public Twitter() {
        followerMap = new HashMap<>() ; 
        tweetMap = new HashMap<>() ; 
        count = 0 ; 
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId , k->new ArrayList<>()) ; 
        tweetMap.computeIfPresent(userId ,(k,v)->{
            v.add(new int[]{count , tweetId});
            return v ; 
        });
        count++ ; 
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>() ; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0] , a[0])) ;
        followerMap.computeIfAbsent(userId, k->new HashSet<>()) ; 
        followerMap.get(userId).add(userId) ;
        followerMap.get(userId).forEach((followeeId) -> {
            if(tweetMap.containsKey(followeeId)){
                int idx = tweetMap.get(followeeId).size()-1 ; 
                int[] tweet = tweetMap.get(followeeId).get(idx) ; 
                pq.offer(new int[]{tweet[0] , tweet[1] , followeeId ,--idx});
            }
        });

        while(!pq.isEmpty() && res.size() < 10){
            int[] data = pq.poll();
            res.add(data[1]); 
            if ( data[3] >= 0 ){
                int[] tweet = tweetMap.get(data[2]).get(data[3]) ; 
                pq.offer(new int[]{tweet[0] , tweet[1] , data[2] , --data[3]}) ;
            }
        }
        return res ; 
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId , k->new HashSet<>());
        followerMap.computeIfPresent(followerId , (k,v)->{
            v.add(followeeId);
            return v ;
        } );
    }
    
    public void unfollow(int followerId, int followeeId) {
        followerMap.computeIfPresent(followerId , (k,v)->{
            if(v.contains(followeeId)) v.remove(followeeId);
            return v ; 
        });
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */