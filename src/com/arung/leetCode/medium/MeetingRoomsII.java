package com.arung.leetCode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;



public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (int[] i1, int[] i2) -> i1[0] - i2[0] );
        int meetingRooms = 0;
        PriorityQueue<Integer> activeRooms = new PriorityQueue<Integer>();
        for ( int i = 0; i < intervals.length; i++ ) {
            //System.out.println(" entry being added is "+ intervals[i][0] +" "+ intervals[i][1]);
            if( activeRooms.isEmpty() || activeRooms.peek() > intervals[i][0] ) {
              //  System.out.println(activeRooms.peek() +" " + activeRooms.size());
                activeRooms.add(intervals[i][1]);
                if( activeRooms.size() > meetingRooms)
                    meetingRooms++;
            } else {
                activeRooms.add(intervals[i][1]);
                activeRooms.poll();
            }
        }
        
        
        return meetingRooms;
    }

    public static void main(String[] args) {
        MeetingRoomsII m = new MeetingRoomsII();
        int[][] intervals = new int[][]{{0, 30},{5, 10},{15, 20}};
        int output = m.minMeetingRooms(intervals);
        System.out.println(output);
    }

}