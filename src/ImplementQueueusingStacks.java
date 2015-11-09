import java.util.Stack;

public class ImplementQueueusingStacks {
    Stack<Integer> sin = new Stack<Integer>();
    Stack<Integer> sout = new Stack<Integer>();
    int size = 0;

    // Push element x to the back of queue.
    public void push(int x) {
        sin.push(x);
        size++;
    }

    // Removes the element from in front of queue.
    public void pop() {
        trans();
        sout.pop();
        size--;
    }

    public void trans() {
        if (sout.isEmpty()) {

            while(!sin.isEmpty())
                sout.push(sin.pop());
        }
    }

    // Get the front element.
    public int peek() {
        trans();
        return sout.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return size == 0;
    }
}
