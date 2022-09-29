import java.io.Serializable;

public class Bill implements Serializable {
    String movieName;
    int outrageousPrice;


    public Bill(String movieName, int outrageousPrice) {
        this.movieName = movieName;
        this.outrageousPrice = outrageousPrice;
    }
}
