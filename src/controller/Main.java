package controller;

import dao.DVDLibrary;
import dto.Address;
import dto.DVD;
import dto.Studio;
import ui.DVDLibraryView;
import ui.UserIO;

public class Main {
    public static void main(String[] args) {
        DVDLibraryView view = new DVDLibraryView();
        DVDLibrary library = new DVDLibrary();

        App app = new App(view, library);
        app.start();
    }
}