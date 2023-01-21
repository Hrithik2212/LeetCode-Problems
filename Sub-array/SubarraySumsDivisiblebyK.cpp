// Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

// A subarray is a contiguous part of an array.

 

// Example 1:

// Input: nums = [4,5,0,-2,-3,1], k = 5
// Output: 7
// Explanation: There are 7 subarrays with a sum divisible by k = 5:
// [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// Example 2:

// Input: nums = [5], k = 9
// Output: 0


class Solution {
public:
    // Prefix Sum Method 
    int subarraysDivByK(vector<int>& nums, int k) {
        int n = nums.size() , count = 0 ; 
        long int remaining_sum = 0 ;
        unordered_map<int,int> hmap ;       
        hmap[0] = 1 ;
        for(int i = 0 ; i < n ; i++){
            remaining_sum += nums[i] ; 
            int remainder = ((remaining_sum % k) + k) % k;
            if(hmap.find(remainder) != hmap.end()){
                count += hmap[remainder] ; 
            }
            if(hmap.find(remainder) == hmap.end()){
                hmap[remainder] = 1;
            }
            else {
                hmap[remainder]++;
            }
        }
        return count ;

    }

    // Brute Force 
    
    // int subarraysDivByK(vector<int>& nums, int k) {
    //     int n = nums.size() , count =0 ;
    //     for(int i= 0; i < n ; i++){
    //         long int sum = 0; 
    //         for(int j=i;j<n;j++){
    //             sum += nums[j];
    //             if (sum%k == 0 ){
    //                 count ++;
    //             }
    //         }
    //     }
    //     return count ;
    // }
};