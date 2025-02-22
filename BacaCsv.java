import java.io.BufferedReader;
import java.io.FileReader;

public class BacaCsv {

    public static void main(String[] args) {

        String namaFile = "contoh.csv";
        Mahasiswa[] listMahasiswa = new Mahasiswa[2];

        try(BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            
            String line = "";
            br.readLine(); // Skip first line
            int idx = 0;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Mahasiswa mhs = new Mahasiswa();
                mhs.nomor = Integer.parseInt(data[0]);
                mhs.nama = data[1];
                mhs.nim = data[2];
                mhs.prodi = data[3];

                mhs.print();

                listMahasiswa[idx] = mhs;
                idx++;
            }

            br.close();

        } catch (Exception e) {
            // TODO: handle exception
        }


        // Cek variable listMahasiswa
        for (int i = 0; i < listMahasiswa.length; i++) {
            if (listMahasiswa[i].prodi.equals("Teknik Elektro")) {
                System.out.println(">>>>" + listMahasiswa[i].nama);
            }
        }

    }
}