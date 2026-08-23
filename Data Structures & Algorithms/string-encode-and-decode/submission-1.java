class Solution {

    static char DELIMITER = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length())
                .append(DELIMITER)
                .append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        int j=0;
        int length =0;
        List<String> out = new ArrayList<>();

        while(i<str.length()){
            j=i+1;
            while(str.charAt(j) != DELIMITER) j++;
            length = Integer.parseInt(str.substring(i,j));
            out.add(length == 0 ? "" : str.substring(j+1, j+1+length));
            i=j+1+length;
        }

        return out;
    }
}
