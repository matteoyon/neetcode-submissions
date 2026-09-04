class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int[] output = new int[amount+1];
        Arrays.fill(output,-1);
        output[0] = 0;

        for(int i = 1; i < amount+1; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && output[i - coins[j]] >= 0 
                    && (output[i] == -1 || output[i - coins[j]] < output[i]))
                        output[i] = output[i - coins[j]] + 1;
            }
        }

        return output[amount];
    }
}
