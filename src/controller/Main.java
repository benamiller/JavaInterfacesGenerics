package controller;

import dao.DVDLibrary;
import dto.Address;
import dto.DVD;
import dto.Studio;
import ui.DVDLibraryView;
import ui.UserIO;

/*
Ben Miller - 2022-02-26
 */

public class Main {
    public static void main(String[] args) {
        DVDLibraryView view = new DVDLibraryView();
        DVDLibrary library = new DVDLibrary();

        /*
         * Create an App instance to begin the magic.
         * view and library are injected as implementation class dependencies for App
         */
        App app = new App(view, library);
        app.start();
    }
}