import java.util.*;

public class Solution4 {

    public static int pairs(int k, List<Integer> arr) {
        Set<Long> set = new HashSet<>();
        for (int num : arr) {
            set.add((long) num);
        }

        int count = 0;
        for (int num : arr) {
            if (set.contains((long) num + k)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            List<Integer> arr = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }

            System.out.println(pairs(k, arr));
        }

        scanner.close();
    }
}