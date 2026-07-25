class Solution {

    static char DELIMITER = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(s.length()).append(DELIMITER).append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new LinkedList<>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j) != DELIMITER){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            output.add(str.substring(j+1,j+1+length));
            i = j+1+length;
        }
        return output;
    }
}
