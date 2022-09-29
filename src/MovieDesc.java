import java.io.Serializable;

public class MovieDesc implements IMovieDesc, Serializable {
    String movieName;
    String isbn;
    String synopsis;

    public MovieDesc(String movieName, String isbn, String synopsis){
        this.movieName=movieName;
        this.isbn=isbn;
        this.synopsis=synopsis;
    }

    @Override
    public String toPrint() {
        return
                "movieName='" + movieName + '\n' +
                ", isbn='" + isbn + '\n' +
                ", synopsis='" + synopsis + '\n';
    }

}
