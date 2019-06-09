package com.arung.leetCode.medium;
import java.util.*;


public class MergeIntervals {
    public int[][] merge(int[][] intervals){
         int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i = 0;i<intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        List<Integer> ansStart = new ArrayList<>();
        List<Integer> ansEnd = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        while(i<end.length){
            if (i == end.length-1 || start[i+1]>end[i]){
                ansStart.add(start[j]);
                ansEnd.add(end[i]);
                j = i+1;
            }
            i++;
        }
        
        int[][] ans = new int[ansStart.size()][2];
        for (int ind = 0;ind<ansStart.size();ind++){
            ans[ind][0] = ansStart.get(ind);
            ans[ind][1] = ansEnd.get(ind);
        }
        return ans;
    }

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] result = m.merge(intervals);
        for (int[] itr : result) {
            System.out.println(itr[0] + " " + itr[1]);
        }
        
    }
}