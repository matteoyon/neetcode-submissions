/*
Input: array of numbers, target number
Output int array, expected having two elements
Constraints:
arr: at least two elements, at most 10^3. numbers of array and terget lower bound 10^-7 and upper bound 10^7

Constraints: given at most, 10^3 a O(n^2) solution is acceptable
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && !map.get(nums[i]).equals(i)){
                int[] output = {map.get(nums[i]),i};
                return output;
            } else {
                map.put(target-nums[i],i);
            }
        }
        return null;
    }
}

/*
[1,3,4,2]; 6

{5,0}{3,1}{2,2}{4,3}
*/
