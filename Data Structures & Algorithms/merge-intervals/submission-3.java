/*
Invariant: At every iteration is granted that the i-th interval can be overlapped if his beginning is less or equal than the end of the last interval in the output array
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> output = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        output.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] lastInterval = output.get(output.size()-1);

            if(intervals[i][0] <= lastInterval[1]){
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }else{
                output.add(intervals[i]);
            }
        }

        return output.toArray(new int[0][]);
    }
}
