import exception.InvalidCredentialsException;
import exception.InvalidISBN;
import exception.SignInFailed;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RemoteException, InvalidCredentialsException, NotBoundException, SignInFailed, InterruptedException, InvalidISBN {
        Registry reg ;
        IConnection connection;

        reg = LocateRegistry.getRegistry("localhost", 2001);
        connection = (IConnection) reg.lookup("MonOD");

        Scanner sc = new Scanner(System.in);
        String mail, password;


        //The user chooses if we want to sign in or login
        System.out.println("Pour sign in taper 0, Pour login taper 1");
        Boolean userWantsToSignIn = sc.nextLine().equals("0");


        //User sign in if he choosed to(if he uses an email that is already used he is reasked to sign in):
        if (userWantsToSignIn) {
                boolean signInResult = false;
                while(!signInResult){
                    System.out.print("SignIn, écrire email:");
                    mail = sc.nextLine();
                    System.out.print("SignIn, écrire password:");
                    password = sc.nextLine();
                    try {
                        signInResult = connection.signIn(mail, password);
                    } catch (SignInFailed e) {
                        System.out.println(e.getMessage());
                    }
                }
        }


        int count = 0;
        int maxTries = 3;
        boolean notLogin = true;
        IVODService ivodService = null;

        //The user has 3 try to login after that an error is thrown
        while (notLogin) {
            try {
                notLogin = false;
                System.out.print("LogIn, écrire email:");
                mail = sc.nextLine();
                System.out.print("LogIn, écrire password:");
                password = sc.nextLine();
                ivodService = connection.login(mail, password);
            } catch (InvalidCredentialsException e) {
                notLogin = true;
                if (++count == maxTries) throw e;
                System.out.println("Nbr d'essaie restant: " + (maxTries - count));
            }
        }
        //
        ClientBox clientBox;
        clientBox = new ClientBox(10000);

        //The user see the catalogue and chooses a movie by it's isbn(if he chooses an invalid isbn he can choose again) .
        //The movie is then streamed frame by frame. After that he can choose a new movie.
        while (true) {
            System.out.println("Voici notre catalogue:");
            try {
                Logger.showCatalogue(ivodService.viewCatalog());
                System.out.println("Veuillez entrer l'isbn du film que vous souhaitez regarder:");
                String isbn = sc.nextLine();
                Logger.showBill(ivodService.playMovie(isbn, clientBox));
                Thread.sleep(100);
                while (clientBox.movieIsPlaying) {
                    Thread.sleep(1000);
                }
                System.out.println("Merci d'avoir regarder notre film!");
                System.out.println("Vous allez être redirigé vers le catalogue!");
                Thread.sleep(3000);
            } catch (InvalidISBN e) {
                System.out.println(e.getMessage());
                Thread.sleep(2000);
            }
        }

    }
}
