/**

[2,20,4,10,3,4,5]



**/

/**
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
**/
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(); 
        int max = 0;

        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n, map.getOrDefault(n-1,0)+map.getOrDefault(n+1,0)+1);
                map.put(n - map.getOrDefault(n-1,0), map.get(n));
                map.put(n + map.getOrDefault(n+1,0), map.get(n));
                max = Math.max(max,map.get(n));
            }
        }

        return max;
    }
}