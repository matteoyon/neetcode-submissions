class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String t : tokens){
            switch(t){
                case "+":
                  int add = stack.pop();
                  stack.push(stack.pop() + add);
                  break;
                case "-":
                  int sub = stack.pop();
                  stack.push(stack.pop() - sub);
                  break;
                case "*":
                  int mul = stack.pop();
                  stack.push(stack.pop() * mul);
                  break;
                case "/":
                  int div = stack.pop();
                  stack.push(stack.pop() / div);
                  break;
                default:
                  stack.push(Integer.parseInt(t));
            }
        }
        return stack.peek();
    }
}
