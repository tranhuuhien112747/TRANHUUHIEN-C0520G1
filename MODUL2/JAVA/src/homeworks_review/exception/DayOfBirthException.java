package homeworks_review.exception;

public class DayOfBirthException extends Exception {
    public DayOfBirthException() {
        super("The birth year must be > 1900 and 18 years younger than the current year correct format dd / mm / yyyy.");
    }
}
