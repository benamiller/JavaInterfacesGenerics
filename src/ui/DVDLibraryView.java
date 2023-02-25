package ui;

import dto.Address;
import dto.DVD;
import dto.Studio;

import java.util.List;

public class DVDLibraryView {
    UserIO io = new UserIO();

    public void printMenu() {
        io.print("Main Menu");
        io.print("1. View a DVD");
        io.print("2. Create a new DVD");
        io.print("3. Remove an existing DVD");
        io.print("4. Edit an existing DVD");
        io.print("5. List all DVDs");
        io.print("6. List all DVD titles");
        io.print("7. Exit");
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
        io.readString("Successfully added!");
        io.print("");
    }

    public void printRemoveDVDBanner() {
        io.print("==== Remove ====");
    }

    public void printRemoveDVDSuccessBanner() {
        io.print("Successfully removed!");
        io.print("");
    }

    public void printEditDVDBanner() {
        io.print("==== Edit ====");
    }

    public void printEditDVDSuccessBanner() {
        io.print("Successfully edited!");
        io.print("");
    }

    public void printListDVDsBanner() {
        io.print("=== List DVDs ===");
    }

    public void printListDVDsSuccessBanner() {
        io.print("=================");
        io.print("");
    }

    public void displayAllDVDs(List<DVD> dvds) {
        for (DVD dvd : dvds) {
            System.out.println(dvd);
        }
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

    public String getDVDTitle() {
        return io.readString("Please enter the DVD title:");
    }

    public void print(String message) {
        io.print(message);
    }

    public int getPropertyToEdit() {
        io.print("1. Title");
        io.print("2. Release date");
        io.print("3. Notes");
        io.print("4. Rating");
        io.print("5. Director");
        io.print("6. Studio Name");
        io.print("7. Studio City");
        io.print("8. Studio Country");
        return io.readInt("Select a property to edit");
    }

    public String shouldContinueEditing() {
        return io.readString("Would you like to edit something else? (y/n)");
    }

    public String getNewPropertyValue() {
        return io.readString("Enter the new updated value");
    }
}
