class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int a = 0;
        int b = 1;

        for(int i = 0; i < n; i++){
            int aux;
            aux = a;
            a = b;
            b = aux + b;
        }

        return b;
    }
}
