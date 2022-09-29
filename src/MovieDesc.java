import java.io.Serializable;

public class MovieDesc implements  Serializable {
    String movieName;
    String isbn;
    String synopsis;

    public MovieDesc(String movieName, String isbn, String synopsis){
        this.movieName=movieName;
        this.isbn=isbn;
        this.synopsis=synopsis;
    }

    @Override
    public String toString() {
        return
                "movieName='" + movieName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", synopsis='" + synopsis + '\'';
    }

}
