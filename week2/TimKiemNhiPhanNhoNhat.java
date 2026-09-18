import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TimKiemNhiPhanNhoNhat {

    public static int timViTriNhoNhat(int[] mang, int khoa) {
        int trai = 0;
        int phai = mang.length - 1;
        int ketQua = -1;

        while (trai <= phai) {
            int giua = trai + (phai - trai) / 2;

            if (mang[giua] == khoa) {
                ketQua = giua;
                phai = giua - 1;
            } else if (mang[giua] < khoa) {
                trai = giua + 1;
            } else {
                phai = giua - 1;
            }
        }

        return ketQua;
    }

    public static void main(String[] args) {
        try {
            Scanner docFile = new Scanner(new File("input.txt"));
            List<Integer> danhSach = new ArrayList<>();

            while (docFile.hasNextInt()) {
                danhSach.add(docFile.nextInt());
            }
            docFile.close();

            int[] mangSo = new int[danhSach.size()];
            for (int i = 0; i < danhSach.size(); i++) {
                mangSo[i] = danhSach.get(i);
            }

            Arrays.sort(mangSo);

            int khoaCanTim = 5;
            int viTri = timViTriNhoNhat(mangSo, khoaCanTim);

            if (viTri != -1) {
                System.out.println("Vi tri nho nhat cua " + khoaCanTim + " la: " + viTri);
            } else {
                System.out.println("Khong tim thấy " + khoaCanTim);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file");
        }
    }
}