package stack;

public class Test {
    public static void main(String[] args) {
        Stack stack = new LinkStack();
        stack.push(3);
        for(int i = 0; i < 15; ++i) {
            stack.push(i);
        }
        System.out.println(stack.toString());
        System.out.println(stack.size());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.pop());
        System.out.println(stack.toString());
        stack.clear();
        System.out.println(stack.toString());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }
}
