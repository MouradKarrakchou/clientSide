import java.util.List;

public class Logger {
    public static void showCatalogue(List<MovieDesc> allMovieDesc){
        for (MovieDesc movieDesc:allMovieDesc){
            System.out.println(movieDesc.toString());
        }
    }

    public static void showBill(Bill bill) {
        System.out.println("Voici votre facture:");
        System.out.println("Tu as payé "+bill.outrageousPrice+" pour le film: "+bill.movieName);
    }
}
