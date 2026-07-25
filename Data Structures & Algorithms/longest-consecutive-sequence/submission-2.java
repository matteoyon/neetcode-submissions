/**

[2,20,4,10,3,4,5]



**/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        List<Integer> starters = new LinkedList<Integer>();

        for(Integer i : set){
            if(!set.contains(i-1)) starters.add(i);
        }

        int outCounter = 0;
        int localCounter;
        
        for(Integer s : starters){
            localCounter = 1;
            int value = s;
            while(set.contains(++value)){
                localCounter++;
            }
            if(localCounter>outCounter) outCounter = localCounter;
        }
        return outCounter;
    }
}
