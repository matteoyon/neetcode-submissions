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
            j=i;
            while(str.charAt(j) != DELIMITER) j++;
            length = Integer.parseInt(str.substring(i,j));
            out.add(length == 0 ? "" : str.substring(j+1, j+1+length));
            i=j+1+length;
        }

        return out;
    }
}

/*Dry run

input ["","",""]


ENCODE:
output = ["0#0#0#"]

DECODE:
str=["0#0#0#"], i=2, j=1, length=0, out=[""]
str=["0#0#0#"], i=4, j=3, length=0, out=["",""]
str=["0#0#0#"], i=6, j=5, length=0, out=["","",""]


Complexity:


Given n as number of strings in the list

Encode:
-time: O(n)
-space: O(1)

Decoder:
-time: O(n)
-Space: O(1)
*/
