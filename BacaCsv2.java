import java.io.BufferedReader;
import java.io.FileReader;

public class BacaCsv2 {
    
    // O(n)
    public static void main(String[] args) {
  
        // O(1)
        String namaFile = "data/netflix_titles.csv";
        NetflixShow[] listShows = new NetflixShow[8809];

        // O(n)
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

        // O(1)
        int countin2020 = 0;
        
        // O(n)
        for (int i = 0; i < listShows.length; i++) {
            // O(1)
            if (listShows[i] == null) {
                continue;
            }
            // O(1)
            if (listShows[i].releaseYear == 2020) {
                countin2020++;
            }
            // O(1)
            if (listShows[i].title.equals("The Aerial")) {
                System.out.println("The Aerial director >>>> " + listShows[i].director);
            }
        }
    
        // O(1)
        System.out.println("Movies & TV Show in 2020 = " + countin2020);

    }

}
