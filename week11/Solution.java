import java.util.*;

public class Solution {

    static class Node implements Comparable<Node> {
        int val;
        int idx;

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.idx, other.idx);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        TreeSet<Node> set = new TreeSet<>();
        List<Double> medians = new ArrayList<>(a.size());
        Node left = null;
        Node right = null;

        for (int i = 0; i < a.size(); i++) {
            Node node = new Node(a.get(i), i);
            set.add(node);

            if (i == 0) {
                left = node;
                right = node;
            } else if (set.size() % 2 == 0) {
                if (node.compareTo(left) < 0) {
                    left = set.lower(left);
                } else {
                    right = set.higher(right);
                }
            } else {
                if (node.compareTo(left) < 0) {
                    right = left;
                } else if (node.compareTo(right) > 0) {
                    left = right;
                } else {
                    left = node;
                    right = node;
                }
            }

            medians.add((left.val + right.val) / 2.0);
        }

        return medians;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            List<Integer> a = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                a.add(scanner.nextInt());
            }

            List<Double> result = runningMedian(a);
            for (double median : result) {
                System.out.printf(Locale.US, "%.1f%n", median);
            }
        }

        scanner.close();
    }
}