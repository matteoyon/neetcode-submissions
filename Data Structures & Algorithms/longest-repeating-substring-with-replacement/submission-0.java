class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int[] freq = new int[26];

        Arrays.fill(freq, 0);
        char targetChar = s.charAt(l);
        int max = 0;

        for(int r = 0; r < s.length(); r++){
            freq[s.charAt(r)-'A']++;
            if(freq[s.charAt(r)-'A'] > freq[targetChar-'A']){
                targetChar = s.charAt(r);
            }
            if(r-l+1 > freq[targetChar - 'A'] + k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            max = Math.max(max,r-l+1);
        }

        return max;
    }
}
