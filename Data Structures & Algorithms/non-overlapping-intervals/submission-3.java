class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int[] actual=intervals[0];
        int kept=1;

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>=actual[1]) {
                actual = intervals[i];
                kept++;
            }
        }

        return intervals.length-kept;
    }
}
