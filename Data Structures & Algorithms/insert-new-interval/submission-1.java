/*
    Invariant: in the merging loop is granted that the last interval in the output array has not overlap with all the other already present in the same array
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

    List<int[]> input = new ArrayList<>(Arrays.asList(intervals));
    List<int[]> output = new ArrayList<>();
        
    for(int i = 0; i < input.size(); i++){
        if(input.get(i)[0] > newInterval[0]){
            input.add(i,newInterval);
            break;
        }
    }

    if(input.size() == intervals.length) input.add(newInterval);

    output.add(input.get(0));
    int[] lastInterval;
    for(int i=1; i < input.size(); i++){
        lastInterval = output.get(output.size()-1);
        if(input.get(i)[0] <= lastInterval[1]){
            lastInterval[1] = Math.max(lastInterval[1], input.get(i)[1]);
        }else{
            output.add(input.get(i));
        }
    }

    return output.toArray(new int[0][]);

    }
}
