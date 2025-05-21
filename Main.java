import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        String[] daftarNamaFile = {getFile()};
        NetflixShow[] listShows = loadShows(daftarNamaFile);

        NetflixShow[] filterNetflixShow = cariNetflixShows(listShows);
        // O(1)
        System.out.println("Movies & TV Show in 2020 = " + filterNetflixShow.length);
        saveToFile("./data/filtered.csv", filterNetflixShow);

    }

    public static String getFile() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Masukkan file: ");
        return scn.nextLine();
    }

    public static NetflixShow[] loadShows(String daftarNamaFile[]) {
        NetflixShow[] listShows = new NetflixShow[8809];
        // O(n)
        for (String namaFile : daftarNamaFile) {
            try(BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
                
                // O(1)
                String line = "";
                br.readLine(); // Skip first line
                int idx = 0;

                // O(n)
                while ((line = br.readLine()) != null) {
                    NetflixShow shw = new NetflixShow();
                    shw.insert(line);
                    listShows[idx] = shw;
                    shw.print();
                    idx++;
                }

                // O(1)
                br.close();

            } catch (Exception e) {
                // O(1)
                System.out.println("Error: " + e.getMessage());
            }
            
        }
        return listShows;
    }

    public static NetflixShow[] cariNetflixShows(NetflixShow[] listShows) {
        
        List<NetflixShow> filteredShows = new ArrayList<>();

        // Algoritma Pencarian (Searching)
        for (int i = 0; i < listShows.length; i++) {
            
            if (listShows[i] == null) {
                continue;
            }

            // O(1)
            if (listShows[i].releaseYear == 2020) {
                filteredShows.add(listShows[i]);
            }
        }
        return filteredShows.stream().toArray(NetflixShow[] ::new);
    
    }

    public static void saveToFile(String fileName, NetflixShow[] data) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (NetflixShow row : data) {
                writer.append(row.showId + ",");
                writer.append(row.type + ",");
                writer.append(row.title + ",");
                writer.append(row.director + ",");
                writer.append(row.cast + ",");
                writer.append(row.country + ",");
                writer.append(row.releaseYear + ",");
                writer.append("\n");
            }
            System.out.println("Data berhasil ditulis ke " + fileName);
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menulis file: " + e.getMessage());
        }
    }
}