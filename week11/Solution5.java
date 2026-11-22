package 2627I_DSA_02_NguyenCongMinh.week11;

import java.util.*;

public class Solution5 {
    public static List<Integer> missingNumbersHashMap(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : brr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            freq.put(num, freq.get(num) - 1);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 0) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }

    public static List<Integer> missingNumbersSorting(List<Integer> arr, List<Integer> brr) {
        List<Integer> a = new ArrayList<>(arr);
        List<Integer> b = new ArrayList<>(brr);

        Collections.sort(a);
        Collections.sort(b);

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (j < b.size()) {
            if (i < a.size() && a.get(i).equals(b.get(j))) {
                i++;
                j++;
            } else {
                if (result.isEmpty() || !result.get(result.size() - 1).equals(b.get(j))) {
                    result.add(b.get(j));
                }
                j++;
            }
        }

        return result;
    }

    public static List<Integer> missingNumbersCountingSort(List<Integer> arr, List<Integer> brr) {
        int minVal = Integer.MAX_VALUE;
        for (int num : brr) {
            if (num < minVal) {
                minVal = num;
            }
        }

        int[] count = new int[101];

        for (int num : brr) {
            count[num - minVal]++;
        }

        for (int num : arr) {
            count[num - minVal]--;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                result.add(i + minVal);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            List<Integer> arr = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }

            int m = scanner.nextInt();
            List<Integer> brr = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                brr.add(scanner.nextInt());
            }

            List<Integer> ans = missingNumbersCountingSort(arr, brr);
            
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + (i < ans.size() - 1 ? " " : ""));
            }
            System.out.println();
        }

        scanner.close();
    }
}