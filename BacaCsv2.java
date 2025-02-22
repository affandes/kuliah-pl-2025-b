import java.io.BufferedReader;
import java.io.FileReader;

public class BacaCsv2 {
    
    public static void main(String[] args) {

        String namaFile = "netflix_titles.csv";
        NetflixShow[] listShows = new NetflixShow[8809];

        try(BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            
            String line = "";
            br.readLine(); // Skip first line
            int idx = 0;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                NetflixShow shw = new NetflixShow();

                if (data[0] == null) {
                    shw.showId = "-";
                } else {
                    shw.showId = data[0];
                }
                
                if (data[1] == null) {
                    shw.type = "-";
                } else {
                    shw.type = data[1];
                }

                if (data[2] == null) {
                    shw.title = "-";
                } else {
                    shw.title = data[2];
                }

                //shw.type = data[1];
                //shw.title = data[2];
                shw.director = data[3];
                shw.cast = data[4];
                shw.country = data[5];
                shw.dateAdded = data[6];
                shw.releaseYear = Integer.parseInt(data[7]);
                shw.rating = data[8];
                shw.duration = data[9];
                shw.listedIn = data[10];
                shw.description = data[11];

                listShows[idx] = shw;

                shw.print();

                idx++;
            }

            br.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: " + e.getMessage());
        }


        int countin2020 = 0;
        // Print
        for (int i = 0; i < listShows.length; i++) {

            if (listShows[i] == null) {
                continue;
            }

            if (listShows[i].releaseYear == 2020) {
                countin2020++;
            }

            if (listShows[i].title.equals("The Aerial")) {
                System.out.println("The Aerial director >>>> " + listShows[i].director);
            }
        }
    

        System.out.println("Movies & TV Show in 2020 = " + countin2020);

    }
}
