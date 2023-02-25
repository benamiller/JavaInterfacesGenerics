package controller;

import dao.DVDLibrary;
import dto.DVD;
import ui.DVDLibraryView;

public class App {
    private DVDLibraryView view;
    private DVDLibrary library;
    private final String FILENAME = "dvds.txt";
    public App() {

    }

    public App(DVDLibraryView view, DVDLibrary library) {
        this.view = view;
        this.library = library;
    }

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
                    editDVD();
                    break;
                case 5:
                    listDVDs();
                    break;
                case 6:
                    listDVDTitles();
                    break;
                case 7:
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

    /**
     * Remove DVD from user inputted title
     */
    public void removeDVD() {
        view.printRemoveDVDBanner();
        String title = view.getDVDTitle();
        library.deleteByTitle(title);
        view.printRemoveDVDSuccessBanner();
    }

    /**
     * List all DVD objects with overridden toString method
     */
    public void listDVDs() {
        view.printListDVDsBanner();
        library.getAllDVDs();
        view.printListDVDsSuccessBanner();
    }

    /**
     * Lists only DVD titles to help with selection DVD title
     * for edits/viewing
     */
    public void listDVDTitles() {
        view.printListDVDsBanner();
        library.getAllDVDTitles();
        view.printListDVDsSuccessBanner();
    }

    /**
     * Write in-memory ArrayList to disk
     */
    public void writeDVDsToDisk() {
        library.writeDVDsToDisk(FILENAME);
    }

    /**
     * View a DVD selected by user-inputted title
     */
    public void viewDVD() {
        String title = view.getDVDTitle();
        DVD dvd = library.findDVDByTitle(title);
        if (dvd != null) {
            library.displayInformation(dvd);
        } else {
            view.print("Couldn't find this DVD");
        }
    }

    /**
     * Edit a DVD property. Loops for more desired property updates on the same DVD.
     * If the title is edited, ensure title is changed *AFTER*
     * edits, to display the correct DVD when searched by the *NEW* title
     * in the ArrayList
     */
    public void editDVD() {
        view.printEditDVDBanner();
        view.print("What would you like to edit?");
        String title = view.getDVDTitle();
        System.out.println("Your are editing:");
        library.displayInformation(library.findDVDByTitle(title));

        boolean shouldEdit = true;

        while(shouldEdit) {
            int propertyToEdit = view.getPropertyToEdit();
            String updatedPropertyValue = view.getNewPropertyValue();
            library.editDVDPropertyByTitle(title, propertyToEdit, updatedPropertyValue);
            if (propertyToEdit == 1) {
                title = updatedPropertyValue;
            }
            String wantsToContinue = view.shouldContinueEditing();
            shouldEdit = wantsToContinue.equalsIgnoreCase("y");
        }

        System.out.println("Updated DVD:");
        library.displayInformation(library.findDVDByTitle(title));

        view.printEditDVDSuccessBanner();
    }

}
