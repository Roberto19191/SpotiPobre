package excecoes;

public class EmailInvalidoException extends Exception {
    public EmailInvalidoException(String msg) {
        super(msg);
    }
}