package lk.uom.cse.msc.rle.exception;

public class UnsupprtedCategoryTypeException extends RuntimeException {


    private static final long serialVersionUID = -5791806876863884860L;

    public UnsupprtedCategoryTypeException() {
        super();
    }

    public UnsupprtedCategoryTypeException(String message) {
        super(message);
    }

    public UnsupprtedCategoryTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupprtedCategoryTypeException(Throwable cause) {
        super(cause);
    }
}
