package FabioGilardi.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Element " + id + " has not been found");
    }
}
