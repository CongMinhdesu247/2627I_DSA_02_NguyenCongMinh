import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    // 1. Thuật toán Insertion Sort - Độ phức tạp: O(N^2)
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 2. Thuật toán Natural Merge Sort (Merge Sort Tự Nhiên)
    public static void naturalMergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;
        int[] temp = new int[n];

        while (true) {
            int left = 0;
            int numMerges = 0;

            while (left < n) {
                // Xác định dãy con đã sắp xếp 1 (Run 1)
                int mid = left;
                while (mid + 1 < n && arr[mid] <= arr[mid + 1]) {
                    mid++;
                }

                // Nếu Run 1 phủ toàn bộ mảng ngay từ chỉ số 0, mảng đã hoàn toàn được sắp xếp
                if (left == 0 && mid == n - 1) {
                    return;
                }

                // Nếu Run 1 chạm đến cuối mảng, không còn Run 2 để gộp trong lượt này
                if (mid == n - 1) {
                    break;
                }

                // Xác định dãy con đã sắp xếp 2 (Run 2)
                int right = mid + 1;
                while (right + 1 < n && arr[right] <= arr[right + 1]) {
                    right++;
                }

                // Trộn Run 1 [left..mid] và Run 2 [mid+1..right]
                merge(arr, temp, left, mid, right);
                numMerges++;

                // Chuyển sang tìm cặp Run tiếp theo
                left = right + 1;
            }

            // Nếu không có lượt gộp nào được thực hiện trong cả vòng quét, kết thúc
            if (numMerges == 0) {
                break;
            }
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

    // --- Các hàm sinh dữ liệu thử nghiệm ---

    public static int[] generateRandom(int size) {
        Random rand = new Random(42);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }

    public static int[] generateSorted(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSorted(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    public static int[] generateNearlySorted(int size) {
        int[] arr = generateSorted(size);
        Random rand = new Random(42);
        int swaps = Math.max(1, size / 100); // Tráo đổi 1% phần tử
        for (int i = 0; i < swaps; i++) {
            int idx1 = rand.nextInt(size);
            int idx2 = rand.nextInt(size);
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        return arr;
    }

    // --- Hàm thực thi chính ---
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000, 100000};
        String[] dataTypeNames = {
            "Ngẫu nhiên (Random)", 
            "Đã sắp xếp (Sorted)", 
            "Giảm dần (Reverse)", 
            "Gần như đã sắp xếp"
        };

        // Khởi động JVM (Warm-up) để phép đo chính xác hơn
        int[] warmup = generateRandom(2000);
        insertionSort(warmup.clone());
        naturalMergeSort(warmup.clone());

        System.out.printf("%-12s | %-22s | %-20s | %-24s\n", 
                          "Kích thước", "Loại dữ liệu", "Insertion Sort (ms)", "Natural Merge Sort (ms)");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int size : sizes) {
            for (int type = 0; type < dataTypeNames.length; type++) {
                int[] original;
                switch (type) {
                    case 0: original = generateRandom(size); break;
                    case 1: original = generateSorted(size); break;
                    case 2: original = generateReverseSorted(size); break;
                    case 3: original = generateNearlySorted(size); break;
                    default: original = new int[0];
                }

                // Đo thời gian Insertion Sort
                int[] arr1 = original.clone();
                long start1 = System.nanoTime();
                insertionSort(arr1);
                long end1 = System.nanoTime();
                double timeInsertionMs = (end1 - start1) / 1e6;

                // Đo thời gian Natural Merge Sort
                int[] arr2 = original.clone();
                long start2 = System.nanoTime();
                naturalMergeSort(arr2);
                long end2 = System.nanoTime();
                double timeNaturalMergeMs = (end2 - start2) / 1e6;

                System.out.printf("%-12d | %-22s | %-20.3f | %-24.3f\n", 
                                  size, dataTypeNames[type], timeInsertionMs, timeNaturalMergeMs);
            }
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }
}