import java.rmi.RemoteException;

public interface IMovieDesc extends java.rmi.Remote{
    public String toPrint() throws RemoteException;
}
