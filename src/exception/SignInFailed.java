package exception;
/**
 * Trigger when the client try to create a new account with an existing email
 */
public class SignInFailed extends Exception {
    public SignInFailed() {
        super("Erreur de lors de l'inscription, un compte avec le même email existe déjà");
    }
}
