import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost",2001);
        IConnection connection = (IConnection) reg.lookup("MonOD");

        connection.signIn("blibla","bliblu");
        IVODService ivodService=connection.login("blibla","bliblu");

        /**
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("SignIn, write email:");
        String mail = sc.nextLine();
        System.out.print("SignIn, write password:");
        String password = sc.nextLine();

        System.out.println("SignIn result = "+connection.signIn(mail, password));

        //Login demande lors d'une exception
        int count = 0;
        int maxTries = 3;
        boolean notLogin = true;
        IVODService ivodService=null;

        while(notLogin) {
            try {
                System.out.print("LogIn, write email:");
                mail = sc.nextLine();
                System.out.print("LogIn, write password:");
                password = sc.nextLine();
                ivodService=connection.login(mail, password);
                notLogin = false;
            } catch (Exception e) {
                System.out.println(e);
                notLogin = true;
                if (++count == maxTries) throw new RuntimeException(e);
                System.out.println("Nbr d'essaie restant: "+(maxTries-count));
            }
        }**/
        ClientBox clientBox= new ClientBox(10000);
        System.out.println(ivodService.playmovie(ivodService.viewCatalog().get(1).isbn,clientBox).movieName);
        System.out.println(ivodService.playmovie(ivodService.viewCatalog().get(1).isbn,clientBox).outrageousPrice);

    }
}
