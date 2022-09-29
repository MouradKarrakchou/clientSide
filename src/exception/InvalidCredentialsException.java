package exception;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException() {
        super("Erreur de lors de la connexion, l'email et le mot de passe ne coincident pas");
    }
}
