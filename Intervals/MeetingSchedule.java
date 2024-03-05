// Meeting Schedule

// Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their schedule without any conflicts.

// Example 1:

// Input: intervals = [(0,30),(5,10),(15,20)]

// Output: false

// Explanation:
// (0,30),(5,10) and (0,30),(15,20) will conflict

// Example 2:

// Input: intervals = [(5,8),(9,15)]

// Output: true

// Note:

//     (0,8),(8,10) is not considered a conflict at 8

// Constraints:


//     0 <= intervals.length <= 100
//     0 <= intervals[i].start < intervals[i].end <= 1000


import java.util.* ; 


public class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
     }
}


class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        for(int i=1 ; i < intervals.size() ; i++) {
            if (intervals.get(i-1).end > intervals.get(i).start){
                return false ;
            }
        }
        return true ; 
    }
}
