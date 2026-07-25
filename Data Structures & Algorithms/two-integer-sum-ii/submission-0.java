/*

1234556789

- b parte dalla cifra più grande minore di target
LOOP
- a aumenta finché x[a]+x[b]> target
- b--
END
- ritorna a+1,b+1
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length-1;

        while(true){
            if(numbers[a]+numbers[b] == target) return new int[]{a+1,b+1};
            if(numbers[a]+numbers[b] > target){
                a = 0;
                b--;
            }else{
                a++;
            }

        }
    }
}
