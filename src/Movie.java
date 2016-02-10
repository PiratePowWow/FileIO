/**
 * Created by PiratePowWow on 2/10/16.
 */
public class Movie {
    private String title;
    private int stars;
    private String genre;
    private boolean isPartofSeries;
    private boolean wouldRecommend;

    public static void saveMovie() {

    }

    public static void loadMovie() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPartofSeries(boolean partofSeries) {
        isPartofSeries = partofSeries;
    }

    public void setWouldRecommend(boolean wouldRecommend) {
        this.wouldRecommend = wouldRecommend;
    }
}
