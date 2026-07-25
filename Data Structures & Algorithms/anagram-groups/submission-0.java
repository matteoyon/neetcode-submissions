/*

["act","pots","tops","cat","stop","hat"]



*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();        
        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            var sortedArr = s.toCharArray();
            Arrays.sort(sortedArr);
            var sorted = new String(sortedArr);
            //map.merge(new String(sorted), Arrays.asList(s), (k,v) -> {k.addAll(v); return k;});
            if(map.containsKey(sorted))
                map.get(sorted).add(s);
            else 
                map.put(sorted, new LinkedList<String>(List.of(s)));
        }
        return new LinkedList(map.values());
    }
}
