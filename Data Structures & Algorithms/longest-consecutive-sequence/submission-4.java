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
        Map<Integer,Integer> mp = new HashMap<>();
        int res = 0;

        for(int num : nums){
            if(!mp.containsKey(num)){
                mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);
                mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
                mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));
                res = Math.max(res, mp.get(num));
            }
        }
        return res;
    }
}