package interviewCodingQueAns.stream;

import java.time.LocalDate;

public class Sale {
    LocalDate date;

    public Sale(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "date=" + date +
                '}';
    }
}
