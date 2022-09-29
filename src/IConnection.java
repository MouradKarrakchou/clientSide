import java.rmi.RemoteException;

public interface IConnection extends java.rmi.Remote {
    boolean signIn(String mail,String pwd) throws RemoteException;
    IVODService login(String mail,String pwd) throws RemoteException,Exception;
}
