import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class ClientBox extends UnicastRemoteObject implements IClientBox {
    Boolean movieIsPlaying=false;
    protected ClientBox(int port) throws RemoteException {
        super(port);
    }

    public void setMovieIsPlaying(Boolean movieIsPlaying) {
        this.movieIsPlaying = movieIsPlaying;
    }

    @Override
    public void stream(byte[] chunck) throws RemoteException, InterruptedException {
            System.out.println(Arrays.toString(chunck));
    }
}