class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> tFreq = new HashMap<>();
        for(Character c : t.toCharArray()) tFreq.merge(c, 1, Integer::sum);
        Map<Character,Integer> wFreq = new HashMap<>();
        int counter = 0;
        int l = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;

        for(int r=0; r < s.length(); r++){
            Character c = s.charAt(r);
            wFreq.put(c,wFreq.getOrDefault(c,0)+1);
            if(tFreq.containsKey(c) && wFreq.get(c).equals(tFreq.get(c))){
                counter++;
            }

            while(counter == tFreq.keySet().size()){
                if(r-l+1 < bestLen){
                    bestLen = r-l+1;
                    bestStart = l;
                }
                Character d = s.charAt(l);
                if(tFreq.containsKey(d) && wFreq.get(d).equals(tFreq.get(d))){
                    counter--;
                }
                wFreq.put(d,wFreq.get(d)-1);
                l++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart+bestLen);
    }
}

/*
s="OUZODYXAZV"
t="XYZ"

*/
