
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);

        int max = 0;
        int count;

        for(Integer i : set){
            if(set.contains(i-1)) continue;
            count = 1;
            while(set.contains(i+count)) count++;
            max = Math.max(max,count);
        }

        return max;
    }
}