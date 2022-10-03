import exception.InvalidCredentialsException;
import exception.SignInFailed;

import java.rmi.RemoteException;

public interface IConnection extends java.rmi.Remote {
    boolean signIn(String mail,String pwd) throws RemoteException, SignInFailed;
    IVODService login(String mail,String pwd) throws RemoteException, InvalidCredentialsException;
}
