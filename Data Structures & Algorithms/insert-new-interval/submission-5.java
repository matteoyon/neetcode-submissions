/*
    Invariant: in the merging loop is granted that the last interval in the output array has not overlap with all the other already present in the same array
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> output = new ArrayList<>();
        int i = 0;

        while(i < intervals.length && newInterval[0] > intervals[i][0]){
            output.add(intervals[i]);
            i++;
        }

        if(output.size() > 0 && newInterval[0] <= output.get(output.size()-1)[1]){
            output.get(output.size()-1)[1] = Math.max(output.get(output.size()-1)[1], newInterval[1]);
        }else{
            output.add(newInterval);
        }

        while(i < intervals.length){
            if(intervals[i][0] <= output.get(output.size()-1)[1]){
            output.get(output.size()-1)[1] = Math.max(output.get(output.size()-1)[1], intervals[i][1]);
            }else{
                output.add(intervals[i]);
            }
            i++;
        }

        return output.toArray(new int[0][]);
    }
}
