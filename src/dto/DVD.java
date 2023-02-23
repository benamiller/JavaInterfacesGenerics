package dto;

/*
Ben Miller - 2022-02-22
This dto.DVD class represents a dto.DVD
 */
public class DVD extends Media {
    private String mpaaRating;
    private String director;
    private Studio studio;

    public DVD() {

    }

    public DVD(String mpaaRating, String director, Studio studio) {
        this.mpaaRating = mpaaRating;
        this.director = director;
        this.studio = studio;
    }

    public DVD(String mpaaRating, String director, Studio studio, String title, String releaseDate, String userNotes) {
        super(title, releaseDate, userNotes);
        this.mpaaRating = mpaaRating;
        this.director = director;
        this.studio = studio;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @Override
    public String toString() {
        return  "Title: " + this.getTitle() + "\n"
                + "Released: " + this.getReleaseDate() + "\n"
                + "MPAA Rating: " + this.getMpaaRating() + "\n"
                + "Director: " + this.getDirector() + "\n"
                + "Studio: " + this.getStudio().toString() + "\n"
                + "User ratings + notes: " + this.getUserNotes();
    }
}
