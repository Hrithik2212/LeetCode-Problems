// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// Example 2:

// Input: coins = [2], amount = 3
// Output: -1

// Example 3:

// Input: coins = [1], amount = 0
// Output: 0

 

// Constraints:

//     1 <= coins.length <= 12
//     1 <= coins[i] <= 231 - 1
//     0 <= amount <= 104

import java.util.* ; 

class Solution {
    // Bottom Up Approach - Tabulation 
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1] ; 
        Arrays.fill(dp , Integer.MAX_VALUE) ; 
        dp[0] = 0 ; 
        for(int i=1 ; i <= amount ; i ++) {
            for(Integer coin : coins ){
                if(i-coin>=0 && dp[i-coin]!= Integer.MAX_VALUE )
                    dp[i] = Math.min(dp[i] , 1+dp[i-coin]) ; 
            }   
        }
        return (dp[amount] == Integer.MAX_VALUE)? -1 : dp[amount] ;
    }

    // Top Down Approach - Memoization
    public int coinChange(int[] coins , int amount ){
        int ans = dfs(coins , amount ,  new HashMap<>() ); 
        return (ans == Integer.MAX_VALUE) ? -1 : ans ; 
    }

    public int dfs(int[] coins , int amount , HashMap<Integer , Integer> cache) {
        if(cache.containsKey(amount)) 
            return cache.get(amount) ; 
        if(amount==0) return 0 ; 
        if(amount < 0 ) return Integer.MAX_VALUE ; 
        int minChange = Integer.MAX_VALUE ;
        for(Integer coin : coins ){
            int ans = dfs(coins , amount - coin , cache ) ; 
            if(ans != Integer.MAX_VALUE) 
                minChange = Math.min( 1+ans , minChange) ; 
        } 
        cache.put(amount , minChange) ; 
        return minChange ; 
    }
}