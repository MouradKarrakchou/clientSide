package exception;
/**
 * Trigger when the client email and password don't mactch
 */
public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException() {
        super("Erreur de lors de la connexion, l'email et le mot de passe ne coincident pas");
    }
}
