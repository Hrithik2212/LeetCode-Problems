// Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings without any conflicts.

// Example 1:

// Input: intervals = [(0,40),(5,10),(15,20)]

// Output: 2

// Explanation:
// day1: (0,40)
// day2: (5,10),(15,20)

// Example 2:

// Input: intervals = [(4,9)]

// Output: 1
// Note:

//     (0,8),(8,10) is not considered a conflict at 8

// Constraints:

//     0 <= intervals.length <= 100
//     0 <= intervals[i].start < intervals[i].end <= 1000


public class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // Separate lists for start times and end times
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        // Populate the start and end times lists
        for (Interval interval : intervals) {
            startTimes.add(interval.start);
            endTimes.add(interval.end);
        }

        // Sort the start and end times lists
        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int rooms = 0;
        int endIndex = 0;

        // Iterate through the start times
        for (int i = 0; i < startTimes.size(); i++) {
            if (startTimes.get(i) < endTimes.get(endIndex)) {
                rooms++;
            } else {
                endIndex++;
            }
        }

        return rooms;
    }
}
