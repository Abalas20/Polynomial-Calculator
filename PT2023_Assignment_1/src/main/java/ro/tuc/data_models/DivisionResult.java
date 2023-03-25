package ro.tuc.data_models;

public class DivisionResult {
    private Polynomial quotient;
    private Polynomial remainder;

    public DivisionResult() {
        quotient = new Polynomial();
        remainder = new Polynomial();
    }

    public DivisionResult(Polynomial quotient, Polynomial remainder) {
        this.quotient = quotient;
        this.remainder = remainder;
    }

    public Polynomial getRemainder() {
        return remainder;
    }

    public void setRemainder(Polynomial remainder) {
        this.remainder = remainder;
    }

    public Polynomial getQuotient() {
        return quotient;
    }

    public void setQuotient(Polynomial quotient) {
        this.quotient = quotient;
    }
}
