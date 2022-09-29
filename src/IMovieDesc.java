import java.io.Serializable;
import java.rmi.RemoteException;

public interface IMovieDesc extends java.rmi.Remote, Serializable {
    public String toPrint() throws RemoteException;
}
