class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> output = new ArrayList<>();
        int[] actual;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        output.add(intervals[0]);


        for(int i=1; i<intervals.length; i++){
            actual=output.get(output.size()-1);
            if(intervals[i][0]>=actual[1]) output.add(intervals[i]);
        }

        return intervals.length - output.size();
    }
}
