import java.rmi.RemoteException;

public interface IClientBox extends java.rmi.Remote {
    /**
     * Used to stream each frame of the movie
     */
    void stream (byte[] chunck) throws RemoteException, InterruptedException;
    void setMovieIsPlaying(Boolean movieIsPlaying) throws RemoteException;
}
