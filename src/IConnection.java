import exception.InvalidCredentialsException;
import exception.SignInFailed;

import java.rmi.RemoteException;

public interface IConnection extends java.rmi.Remote {
    /**
     * Register a client
     * @param mail
     * @param pwd
     * @return true if the client is correctly register, otherwise false
     * @throws SignInFailed, when the client try to register with a mail already know
     */
    boolean signIn(String mail,String pwd) throws RemoteException, SignInFailed;

    /**
     * Login the client into the Vod service
     * @param mail
     * @param pwd
     * @return IVODService, that the client will use to interact with the systeme
     * @throws InvalidCredentialsException, when the client try to login with wrong mail and password
     */
    IVODService login(String mail,String pwd) throws RemoteException, InvalidCredentialsException;
}
