package exception;

public class InvalidISBN extends Exception {
    public InvalidISBN() {
        super("Erreur de lors du choix du film, l'ISBN est invalide");
    }
}
