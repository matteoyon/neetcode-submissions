/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

 /*
 At every iteration, active keep the number of events in progress right now
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for(Interval i : intervals){
            starts.add(i.start);
            ends.add(i.end);
        }

        starts.sort(Integer::compare);
        ends.sort(Integer::compare);

        int i=0;
        int j=0;
        int max = 0;
        int active = 0;

        while(i<starts.size() && j<ends.size()){
            if(starts.get(i) < ends.get(j)){
                active++;
                max=Math.max(max,active);
                i++;
            }else{
                active--;
                j++;
            }
        }

        return max;

    }
}
