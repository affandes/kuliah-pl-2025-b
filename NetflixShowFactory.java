import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class NetflixShowFactory {
    
    String[] daftarNamaFile;
    NetflixShow[] listShows;

    public NetflixShowFactory(String[] daftarNamaFile) {
        this.daftarNamaFile = daftarNamaFile;
    }

    public void loadShows() {
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

    }

    public NetflixShow[] cariNetflixShows() {
        
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

    // Todo: 
    public NetflixShow[] urutkanBerdasarkanJudul() {

    }

}
