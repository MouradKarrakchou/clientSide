package exception;
/**
 * Trigger when the client use a invalid ISBN
 */
public class InvalidISBN extends Exception {
    public InvalidISBN() {
        super("Erreur de lors du choix du film, l'ISBN est invalide");
    }
}
