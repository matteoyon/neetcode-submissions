class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(Character c : s.toCharArray()) freq[c-'a']++;
            map.merge(Arrays.toString(freq), new ArrayList<String>(List.of(s)), (a,b) -> {a.addAll(b); return a;});
        }
        return map.values().stream().toList();
    }
}
