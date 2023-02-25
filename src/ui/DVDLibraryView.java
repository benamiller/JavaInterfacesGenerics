package ui;

import dto.Address;
import dto.DVD;
import dto.Studio;

public class DVDLibraryView {
    UserIO io = new UserIO();

    public void printMenu() {
        io.print("Main Menu");
        io.print("1. View a DVD");
        io.print("2. Create a new DVD");
        io.print("3. Remove an existing DVD");
        io.print("4. List all DVDs");
        io.print("5. Exit");
    }

    public void printViewDVDBanner() {
        io.print("==== View ====");
    }

    public void printViewDVDSuccessBanner() {
        io.print("Press enter to continue");
    }

    public void printCreateDVDBanner() {
        io.print("==== Create ====");
    }

    public void printCreateDVDSuccessBanner() {
        io.readString("Successfully added! Press enter to continue");
    }

    public void printRemoveDVDBanner() {
        io.print("==== Remove ====");
    }

    public void printRemoveDVDSuccessBanner() {
        io.print("Successfully removed! Press enter to continue");
    }

    public void printListDVDsBanner() {
        io.print("=== List DVDs ===");
    }

    public void printListDVDsSuccessBanner() {
        io.readString("Press enter to continue");
    }

    public int readInt(String prompt) {
        return io.readInt(prompt);
    }

    public DVD makeDVDFromInfo() {
        String DVDTitle = io.readString("Please enter DVD title:");
        String DVDRelease = io.readString("Please enter the DVD release date (MM/DD/YYYY):");
        String DVDRating = io.readString("Please enter the DVD MPAA Rating:");
        String DVDDirector = io.readString("Please enter the director's name:");
        String studioName = io.readString("Please enter the studio name:");
        String studioCity = io.readString("Please enter the studio city:");
        String studioCountry = io.readString("Please enter the studio country:");
        String DVDNote = io.readString("Please enter a comment or your own rating:");

        Address address = new Address(studioCity, studioCountry);
        Studio studio = new Studio(studioName, address);
        DVD dvd = new DVD(DVDRating, DVDDirector, studio, DVDTitle, DVDRelease, DVDNote);

        return dvd;
    }

    public String findDVDByName() {
        String title = io.readString("Please enter the DVD title:");
        return title;
    }

}
