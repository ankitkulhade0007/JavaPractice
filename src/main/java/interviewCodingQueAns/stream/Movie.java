package interviewCodingQueAns.stream;

public class Movie {

    String genre;
    double rating;

    public Movie(String genre, double rating) {
        this.genre = genre;
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
