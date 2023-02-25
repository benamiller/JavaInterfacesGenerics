package controller;

import dao.DVDLibrary;
import dto.DVD;
import ui.DVDLibraryView;

public class App {

    private final String FILENAME = "dvds.txt";
    public App() {

    }

    private final DVDLibraryView view = new DVDLibraryView();
    private final DVDLibrary library = new DVDLibrary();
    public void start() {

        boolean shouldContinue = true;

        library.readFromFile(FILENAME);

        while (shouldContinue) {

            view.printMenu();

            int menuSelection = view.readInt("Please select one of the menu options, and enter the corresponding integer :)");

            switch (menuSelection) {
                case 1:
                    viewDVD();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    removeDVD();
                    break;
                case 4:
                    System.out.println("Edit");
                    break;
                case 5:
                    listDVDs();
                    break;
                case 6:
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Invalid input :( Would you mind trying again?");
            }
        }

        // Write data to file
        System.out.println("Thanks for visiting your DVDLibrary!");
        writeDVDsToDisk();

    }

    public void viewDVD() {
        String title = view.getDVDTitle();
        DVD dvd = library.findDVDByTitle(title);
        library.displayInformation(dvd);
    }

    /**
     * Create new DVD from user inputted properties
     */
    public void createDVD() {
        view.printCreateDVDBanner();
        DVD dvd = view.makeDVDFromInfo();
        library.create(dvd);
        library.displayInformation(dvd);
        view.printCreateDVDSuccessBanner();
    }

    public void removeDVD() {
        view.printRemoveDVDBanner();
        String title = view.getDVDTitle();
        library.deleteByTitle(title);
        view.printRemoveDVDSuccessBanner();
    }

    public void editDVD() {
        view.printEditDVDBanner();
        view.print("What would you like to edit?");
        String title = view.getDVDTitle();
        String propertyToEdit = view.getPropertyToEdit();
        view.printEditDVDSuccessBanner();
    }

    public void listDVDs() {
        view.printListDVDsBanner();
        library.getAllDVDs();
        view.printListDVDsSuccessBanner();
    }

    public void writeDVDsToDisk() {
        library.writeDVDsToDisk(FILENAME);
    }
}
