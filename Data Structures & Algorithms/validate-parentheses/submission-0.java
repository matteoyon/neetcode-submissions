class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Deque<Character> stack = new ArrayDeque<Character>();

        char[] arr = s.toCharArray();

        for(Character c : arr){
            if(map.values().contains(c)){
                stack.push(c);
            } else {
                if(Objects.isNull(stack.peek())) return false;
                if(map.get(c) != stack.pop()) return false;
            }
        }

        if(!Objects.isNull(stack.peek())) return false;
        
        return true;
    }
}
