import groovy.util.logging.Log;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Registry reg = null;
        IConnection connection = null;
        try {
            reg = LocateRegistry.getRegistry("localhost", 2001);
            connection = (IConnection) reg.lookup("MonOD");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }

        //connection.signIn("blibla","bliblu");
        //IVODService ivodService=connection.login("blibla","bliblu");
        Scanner sc = new Scanner(System.in);
        String mail, password;
        System.out.println("Pour sign in taper 0, Pour login taper 1");
        Boolean userWantsToSignIn = sc.nextLine().equals("0");
        if (userWantsToSignIn) {
            boolean signInResult = false;
            while(!signInResult){
                System.out.print("SignIn, écrire email:");
                mail = sc.nextLine();
                System.out.print("SignIn, écrire password:");
                password = sc.nextLine();
                try {
                    signInResult = connection.signIn(mail, password);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //Login demande lors d'une exception
        int count = 0;
        int maxTries = 3;
        boolean notLogin = true;
        IVODService ivodService = null;
        while (notLogin) {
            try {
                notLogin = false;
                System.out.print("LogIn, écrire email:");
                mail = sc.nextLine();
                System.out.print("LogIn, écrire password:");
                password = sc.nextLine();
                ivodService = connection.login(mail, password);
            } catch (Exception e) {
                notLogin = true;
                if (++count == maxTries) throw new RuntimeException(e);
                System.out.println("Nbr d'essaie restant: " + (maxTries - count));
            }
        }
        //
        ClientBox clientBox = null;
        try {
            clientBox = new ClientBox(10000);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(ivodService.playmovie(ivodService.viewCatalog().get(1).isbn,clientBox).movieName);
        //System.out.println(ivodService.playmovie(ivodService.viewCatalog().get(1).isbn,clientBox).outrageousPrice);
        while (true) {
            System.out.println("Voici notre catalogue:");
            try {
                Logger.showCatalogue(ivodService.viewCatalog());
                System.out.println("Veuillez entrer l'isbn du film que vous souhaitez regarder:");
                String isbn = sc.nextLine();
                Logger.showBill(ivodService.playmovie(isbn, clientBox));
                Thread.sleep(100);
                while (clientBox.movieIsPlaying) {
                    Thread.sleep(1000);
                }
                System.out.println("Merci d'avoir regarder notre film!");
                Thread.sleep(3000);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
