public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int n : nums) freq.merge(n,1,Integer::sum);

        LinkedList<Integer>[] count = new LinkedList[nums.length+1];

        for(Map.Entry<Integer,Integer> e : freq.entrySet()){
            if(count[e.getValue()] == null)
                count[e.getValue()] = new LinkedList<>();
            count[e.getValue()].add(e.getKey());
        }
        
        int[] res = new int[k];
        int resCounter = 0;

        for(int i = nums.length; i >= 0; i--){
            if(count[i]!=null)
                for(Integer j : count[i]){
                    res[resCounter] = j;
                    resCounter++;
                    if(resCounter == k)
                        return res;
                }
        }

        return res;
    }
}