class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        var sMap = new HashMap<Character, Integer>();
        var tMap = new HashMap<Character, Integer>();

        for(char c : s.toCharArray()){
            sMap.merge(c,1,(p,q) -> p+q);
        }

        for(char c : t.toCharArray()){
            tMap.merge(c,1,(p,q) -> p+q);
        }

        for(Map.Entry e : sMap.entrySet()){
            try {
                if(!tMap.get(e.getKey()).equals(e.getValue())) return false;
            } catch(Exception ex) {
                return false;
            }
        }
        return true;
    }
}
