import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiaoHaiChuoiSo {

    public static void timPhanTuChung(int[] A, int[] B) {
    int i = 0, j = 0;

    while (i < A.length && j < B.length) {
        if (A[i] < B[j]) {
            i++;
        } else if (A[i] > B[j]) {
            j++;
        } else {
            int val = A[i];
            System.out.print(val + " ");

            while (i < A.length && A[i] == val) i++;
            while (j < B.length && B[j] == val) j++;
        }
    }
    System.out.println();
}

    public static void main(String[] args) {
        try {
            Scanner docFile = new Scanner(new File("input2.txt"));

            List<Integer> danhSach1 = new ArrayList<>();
            List<Integer> danhSach2 = new ArrayList<>();

            if (docFile.hasNextLine()) {
                Scanner dong1 = new Scanner(docFile.nextLine());
                while (dong1.hasNextInt()) {
                    danhSach1.add(dong1.nextInt());
                }
                dong1.close();
            }

            if (docFile.hasNextLine()) {
                Scanner dong2 = new Scanner(docFile.nextLine());
                while (dong2.hasNextInt()) {
                    danhSach2.add(dong2.nextInt());
                }
                dong2.close();
            }

            docFile.close();

            int[] mang1 = new int[danhSach1.size()];
            for (int k = 0; k < danhSach1.size(); k++) {
                mang1[k] = danhSach1.get(k);
            }

            int[] mang2 = new int[danhSach2.size()];
            for (int k = 0; k < danhSach2.size(); k++) {
                mang2[k] = danhSach2.get(k);
            }

            System.out.print("Cac gia tri chung: ");
            timPhanTuChung(mang1, mang2);

        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file!");
        }
    }
}