import exception.InvalidISBN;

import java.rmi.RemoteException;
import java.util.List;

public interface IVODService extends java.rmi.Remote {
    List<MovieDesc> viewCatalog() throws RemoteException;
    /**
     * Find the movie by it isbn and create a thread that stream the movie
     * @param isbn
     * @param box
     * @return
     * @throws InvalidISBN
     */
    Bill playMovie(String isbn, IClientBox box) throws RemoteException, InvalidISBN;
}
