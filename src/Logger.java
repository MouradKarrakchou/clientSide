import java.util.List;

public class Logger {
    public static void showCatalogue(List<MovieDesc> allMovieDesc) throws InterruptedException {
        for (MovieDesc movieDesc:allMovieDesc){
            System.out.println(movieDesc.toString());
            if (movieDesc instanceof MovieDescExtended) ((MovieDescExtended) movieDesc).streamTeaser();
        }
    }

    public static void showBill(Bill bill) {
        System.out.println("Voici votre facture:");
        System.out.println("Tu as payé "+bill.outrageousPrice+" pour le film: "+bill.movieName);
    }
}
