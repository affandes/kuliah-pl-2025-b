import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

       // String[] daftarNamaFile = {getFile()};
       
        NetflixShowFactory nff = new NetflixShowFactory();
        
        nff.loadShows("data/netflix_titles.csv");
        NetflixShow[] filterNetflixShow = nff.sortWithMergeSort();
        
        // O(1)
        System.out.println("Movies & TV Show in 2020 = " + filterNetflixShow.length);
        saveToFile(filterNetflixShow);

    }

    public static String getFile() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Masukkan file: ");
        return scn.nextLine();
    }

    public static void saveToFile(NetflixShow[] data) {
        saveToFile("output.csv", data);
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