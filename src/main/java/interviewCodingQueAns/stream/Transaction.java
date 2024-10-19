package interviewCodingQueAns.stream;

public class Transaction {

    private String transactionDate;
    private int transactionAmount;
    String city;
    String paymentMethod;

    public Transaction(String transactionDate, int transactionAmount) {
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public Transaction(String city, String paymentMethod) {
        this.city = city;
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionDate='" + transactionDate + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", city='" + city + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
