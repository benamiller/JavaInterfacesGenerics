package controller;

import dao.DVDLibrary;
import dto.DVD;
import ui.DVDLibraryView;

public class App {
    public App() {

    }

    private final DVDLibraryView view = new DVDLibraryView();
    private final DVDLibrary library = new DVDLibrary();
    public void start() {

        boolean shouldContinue = true;

        while (shouldContinue) {
            view.printMenu();

            int menuSelection = view.readInt("Please select one of the menu options, and enter the corresponding integer :)");

            switch (menuSelection) {
                case 1:
                    System.out.println("View");
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    removeDVD();
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Invalid input :( Would you mind trying again?");
            }
        }
    }

    /**
     * Create new DVD from user inputted properties
     * @params none
     * @return void
     */
    public void createDVD() {
        view.printCreateDVDBanner();
        DVD dvd = view.makeDVDFromInfo();
        library.add(dvd);
        library.displayInformation(dvd);
        view.printCreateDVDSuccessBanner();
    }

    public void removeDVD() {
        view.printRemoveDVDBanner();
        String title = view.findDVDByName();
        library.deleteByTitle(title);
        view.printRemoveDVDSuccessBanner();
    }

    public void listDVDs() {
        view.printListDVDsBanner();
        library.listDVDs();
        view.printListDVDsSuccessBanner();
    }
}
