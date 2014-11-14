import java.util.Stack;

public class MinStackv2 {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer>minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);

        if (minStack.empty() || x < minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {

        if (stack.empty()) {
            return;
        }

        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
