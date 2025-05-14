import java.util.Arrays;
import java.util.Scanner;

public class PencarianBagiDua {
    public static void main(String[] args) {
        // Contoh array berisi 20 elemen yang sudah terurut
        int[] data = {2, 5, 8, 12, 15, 18, 21, 24, 27, 30, 
                      33, 36, 39, 42, 45, 48, 51, 54, 57, 60};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka yang ingin dicari: ");
        int target = scanner.nextInt();

        int result = binarySearch(data, target);

        if (result == -1) {
            System.out.println("Angka tidak ditemukan dalam array.");
        } else {
            System.out.println("Angka ditemukan pada indeks: " + result);
        }
    }

    // Metode binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1; // Tidak ditemukan
    }
}
