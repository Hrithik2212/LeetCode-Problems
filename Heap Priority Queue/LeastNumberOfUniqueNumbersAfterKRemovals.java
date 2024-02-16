// Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

 

// Example 1:

// Input: arr = [5,5,4], k = 1
// Output: 1
// Explanation: Remove the single 4, only 5 is left.

// Example 2:

// Input: arr = [4,3,1,1,3,3,2], k = 3
// Output: 2
// Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.

 

// Constraints:

//     1 <= arr.length <= 10^5
//     1 <= arr[i] <= 10^9
//     0 <= k <= arr.length


class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer , Integer> counter = new HashMap<>() ; 
        for(Integer num : arr ){
            counter.put(num , counter.getOrDefault(num , 0)+1) ; 
        }   
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(obj -> obj[1])) ;
        for(Integer key : counter.keySet()) {
            int pair[] = {key , counter.get(key) } ; 
            pq.offer(pair) ; 
        }
        if(k==0) return counter.keySet().size() ; 
        while(k > 0 && !pq.isEmpty()){
            int[] pair = pq.poll() ; 
            if(k-pair[1] < 0 ) 
                return pq.size()+1 ;
            else if (k-pair[1] == 0) 
                return pq.size() ;
            k -= pair[1] ; 
        }
        return 0 ; 
    }
}