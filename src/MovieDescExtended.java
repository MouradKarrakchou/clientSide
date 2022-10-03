import java.io.Serializable;
import java.util.Arrays;

public class MovieDescExtended extends MovieDesc implements Serializable {
    byte[][] teaser;

    public MovieDescExtended(String movieName, String isbn, String synopsis, byte[][] teaser) {
        super(movieName, isbn, synopsis);
        this.teaser=teaser;
    }

    public void streamTeaser() throws InterruptedException {
        System.out.println("Voici un teaser pour ce film");
        for (byte[] bytes:teaser){
            System.out.println(Arrays.toString(bytes));
            Thread.sleep(500);
        }
    }


    @Override
    public String toString() {
        return
                "movieName='" + movieName + '\'' +
                        ", isbn='" + isbn + '\'' +
                        ", synopsis='" + synopsis + '\'';
    }
}
