import java.util.List;

public interface IVODService {
    List<IMovieDesc> viewCatalog();
    IBill playmovie(String isbn, IClientBox box);
}