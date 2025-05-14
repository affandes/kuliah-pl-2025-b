public class NetflixShow {
    public String showId;
    public String type;
    public String title;
    public String director;
    public String cast;
    public String country;
    public String dateAdded;
    public int releaseYear;
    public String rating;
    public String duration;
    public String listedIn;
    public String description;

    public void print() {
        System.out.println("Title: " + title);
    }

    public void insert(String[] data) {
        if (data[0] == null) {
            showId = "-";
        } else {
            showId = data[0];
        }
        
        if (data[1] == null) {
            type = "-";
        } else {
            type = data[1];
        }

        if (data[2] == null) {
            title = "-";
        } else {
            title = data[2];
        }   

        //shw.type = data[1];
         //shw.title = data[2];
        director = data[3];
        cast = data[4];
        country = data[5];
        dateAdded = data[6];
        releaseYear = Integer.parseInt(data[7]);
        rating = data[8];
        duration = data[9];
        listedIn = data[10];
        description = data[11];
    }

    public void insert(String line) {
        String[] dt = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        insert(dt);
    }
}
