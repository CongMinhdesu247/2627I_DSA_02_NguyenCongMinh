import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DemCapSoBangNhau {

    public static long demCapSo(int[] mang) {
        if (mang == null || mang.length < 2) {
            return 0;
        }

        Arrays.sort(mang);

        long tongSoCap = 0;
        long dem = 1;

        for (int i = 1; i < mang.length; i++) {
            if (mang[i] == mang[i - 1]) {
                dem++;
            } else {
                tongSoCap += (dem * (dem - 1)) / 2;
                dem = 1;
            }
        }
        tongSoCap += (dem * (dem - 1)) / 2;

        return tongSoCap;
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

            long ketQua = demCapSo(mangSo);
            System.out.println("So cap bằng nhau: " + ketQua);

        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file");
        }
    }
}