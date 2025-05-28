import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NetflixShowFactory {
    
    String[] daftarNamaFile;
    NetflixShow[] listShows;

    public NetflixShowFactory() {
        
    }

    public NetflixShowFactory(String[] daftarNamaFile) {
        this.daftarNamaFile = daftarNamaFile;
    }

    public void loadShows() {
        listShows = new NetflixShow[8809];
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
                    //shw.print();
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

    public void loadShows(String namaFile) {
        listShows = new NetflixShow[8809];
        
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
                    //shw.print();
                    idx++;
                }

                // O(1)
                br.close();

            } catch (Exception e) {
                // O(1)
                System.out.println("Error: " + e.getMessage());
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
        // Salin listShows ke array baru dan filter null
        List<NetflixShow> validShows = new ArrayList<>();
        for (NetflixShow show : listShows) {
            if (show != null) validShows.add(show);
        }

        // Ubah ke array
        NetflixShow[] sortedArray = validShows.toArray(new NetflixShow[0]);

        // Urutkan berdasarkan judul (title)
        Arrays.sort(sortedArray, new Comparator<NetflixShow>() {
            @Override
            public int compare(NetflixShow s1, NetflixShow s2) {
                return s1.title.compareToIgnoreCase(s2.title);
            }
        });

        return sortedArray;
    }

    public NetflixShow[] sortWithBubbleSort() {
        // Salin dan filter null
        List<NetflixShow> validShows = new ArrayList<>();
        for (NetflixShow show : listShows) {
            if (show != null) validShows.add(show);
        }

        NetflixShow[] arr = validShows.toArray(new NetflixShow[0]);

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].title.compareToIgnoreCase(arr[j + 1].title) > 0) {
                    // Swap
                    NetflixShow temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }


    public NetflixShow[] sortWithMergeSort() {
        // Salin dan filter null
        List<NetflixShow> validShows = new ArrayList<>();
        for (NetflixShow show : listShows) {
            if (show != null) validShows.add(show);
        }

        NetflixShow[] arr = validShows.toArray(new NetflixShow[0]);
        mergeSort(arr, 0, arr.length - 1);
        return arr;
}

    private void mergeSort(NetflixShow[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }
}
