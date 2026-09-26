package week3;
import java.util.*;

public class SolutionQueueUsingTwoStacks {

    static class MyQueue<T> {
        private Deque<T> stackIn = new ArrayDeque<>();
        private Deque<T> stackOut = new ArrayDeque<>();

        public void enqueue(T value) {
            stackIn.push(value);
        }

        private void shiftStacks() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }

        public T dequeue() {
            shiftStacks();
            return stackOut.pop();
        }

        public T peek() {
            shiftStacks();
            return stackOut.peek();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int q = scanner.nextInt();
            MyQueue<Integer> queue = new MyQueue<>();

            for (int i = 0; i < q; i++) {
                int type = scanner.nextInt();
                if (type == 1) {
                    int x = scanner.nextInt();
                    queue.enqueue(x);
                } else if (type == 2) {
                    queue.dequeue();
                } else if (type == 3) {
                    System.out.println(queue.peek());
                }
            }
        }
        
        scanner.close();
    }
}