import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost",2001);
        IConnection connection = (IConnection) reg.lookup("MonOD");
        System.out.println(connection.signIn("blibla","blublu"));
        //connection.login("blibla","blublu");
    }
}
