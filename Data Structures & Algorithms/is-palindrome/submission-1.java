class Solution {
    public boolean isPalindrome(String s) {
        s.replaceAll(" ","");
        int[] arr = s.toLowerCase().chars().filter(c -> (c >= 97 && c <= 122) || (c >= 48 && c <= 57)).toArray();

        int a = 0;
        int b = arr.length - 1;

        while(a < b){
            if(arr[a++] != arr[b--]) return false;
        }

        return true;
    }
}
