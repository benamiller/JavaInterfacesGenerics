package dto;
/*
Ben Miller - 2022-02-22
This dto.Media class represents a generic piece of dto.Media (book, TV show, dto.DVD, ...)
It declares common properties and behaviour of each dto.Media subtype
 */
public class Media {
    private String title;
    private String releaseDate;
    private String userNotes;

    public Media() {

    }
    public Media(String title, String releaseDate, String userNotes) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.userNotes = userNotes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }
}
