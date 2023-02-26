package ui;

import dto.Address;
import dto.DVD;
import dto.Studio;

import java.util.List;

public class DVDLibraryView implements View {
    UserIO io = new UserIO();

    /**
     * Main menu
     */
    @Override
    public void printMenu() {
        io.print("Main Menu");
        io.print("1. View a DVD");
        io.print("2. Create a new DVD");
        io.print("3. Remove an existing DVD");
        io.print("4. Edit an existing DVD");
        io.print("5. List all DVDs");
        io.print("6. List all DVD titles");
        io.print("7. Save DVD Library");
        io.print("8. Exit");
    }

    @Override
    public void printViewDVDBanner() {
        io.print("==== View ====");
    }

    @Override
    public void printViewDVDSuccessBanner() {
        io.print("Press enter to continue");
    }

    @Override
    public void printCreateDVDBanner() {
        io.print("==== Create ====");
    }

    @Override
    public void printCreateDVDSuccessBanner() {
        io.print("Successfully added!");
        io.print("");
    }

    @Override
    public void printRemoveDVDBanner() {
        io.print("==== Remove ====");
    }

    @Override
    public void printRemoveDVDSuccessBanner() {
        io.print("Successfully removed!");
        io.print("");
    }

    @Override
    public void printEditDVDBanner() {
        io.print("==== Edit ====");
    }

    @Override
    public void printEditDVDSuccessBanner() {
        io.print("Successfully edited!");
        io.print("");
    }

    @Override
    public void printListDVDsBanner() {
        io.print("=== List DVDs ===");
    }

    @Override
    public void printListDVDsSuccessBanner() {
        io.print("=================");
        io.print("");
    }

    public void printSaveDVDsBanner() {
        io.print("==== Save ====");
    }

    public void printSaveDVDsSuccessBanner() {
        io.print("Successfull saved!");
        io.print("");
    }

    @Override
    public void displayAllDVDs(List<DVD> dvds) {
        for (DVD dvd : dvds) {
            System.out.println(dvd);
        }
    }

    @Override
    public int readInt(String prompt) {
        return io.readInt(prompt);
    }

    /**
     * Delegate getting user input to the io implementation class, and construct a DVD
     * @return A DVD object created from user input
     */
    @Override
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

    @Override
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

    /**
     * This facilitates editing multiple properties of the same DVD easily
     * @return String representing the user choice to continue editing the same DVD
     */
    public String shouldContinueEditing() {
        return io.readString("Would you like to edit something else? (y/n)");
    }

    public String getNewPropertyValue() {
        return io.readString("Enter the new updated value");
    }

}
