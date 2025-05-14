public class Pencarian {

    public static void main(String[] args) {

        int[] data = {9, 2, 7, 4, 5, 7, 6};
        int target = 8;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                System.out.println("Angka " + target + " ada di indeks " + i);
            }
        }

    }
    
}
