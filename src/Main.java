import groovy.util.logging.Log;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost",2001);
        IConnection connection = (IConnection) reg.lookup("MonOD");

        //connection.signIn("blibla","bliblu");
        //IVODService ivodService=connection.login("blibla","bliblu");
        Scanner sc= new Scanner(System.in);
        //
        String mail,password;
        System.out.println("Pour sign in taper 0, Pour login taper 1");
        Boolean userWantsToSignIn=sc.nextLine().equals("0");
        if(userWantsToSignIn){
        System.out.print("SignIn, écrire email:");
        mail = sc.nextLine();
        System.out.print("SignIn, écrire password:");
        password = sc.nextLine();

        System.out.println("SignIn result = "+connection.signIn(mail, password));}

        //Login demande lors d'une exception
        int count = 0;
        int maxTries = 3;
        boolean notLogin = true;
        IVODService ivodService=null;

        while(notLogin) {
            try {
                System.out.print("LogIn, écrire email:");
                mail = sc.nextLine();
                System.out.print("LogIn, écrire password:");
                password = sc.nextLine();
                ivodService=connection.login(mail, password);
                notLogin = false;
            } catch (Exception e) {
                System.out.println(e);
                notLogin = true;
                if (++count == maxTries) throw new RuntimeException(e);
                System.out.println("Nbr d'essaie restant: "+(maxTries-count));
            }
        }
        //
        ClientBox clientBox= new ClientBox(10000);

        //System.out.println(ivodService.playmovie(ivodService.viewCatalog().get(1).isbn,clientBox).movieName);
        //System.out.println(ivodService.playmovie(ivodService.viewCatalog().get(1).isbn,clientBox).outrageousPrice);
        while(true){
        System.out.println("Voici notre catalogue:");
        Logger.showCatalogue(ivodService.viewCatalog());
        System.out.println("Veuillez entrer l'isbn du film que vous souhaitez regarder:");
        String isbn=sc.nextLine();
        Logger.showBill(ivodService.playmovie(isbn,clientBox));
        Thread.sleep(100);
        while(clientBox.movieIsPlaying){
            Thread.sleep(1000);
        }
        System.out.println("Merci d'avoir regarder notre film!");
        Thread.sleep(3000);}

    }
}
