class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            List<String> toAdd = map.getOrDefault(sorted,new LinkedList<String>());
            toAdd.add(s);
            map.put(sorted,toAdd);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
