package bai_thi;

public class NotFoundProductException extends Exception{
    public NotFoundProductException() {
        super("Products do not exist");
    }
}
