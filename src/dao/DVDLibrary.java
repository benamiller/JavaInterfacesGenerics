package dao;
/*
Ben Miller - 2022-02-22
dao.DVDLibrary interacts with FileIO to read and write a dto.DVD dao.Library
 */

import dto.DVD;
import ui.DVDLibraryView;

import java.io.FileReader;
import java.util.ArrayList;

public class DVDLibrary implements Library<DVD> {

    private final DVDFileIO fileIO = new DVDFileIO();
    private final ArrayList<DVD> dvdCollection= new ArrayList<DVD>();
    public void add(DVD dvd) {
        dvdCollection.add(dvd);
    }

    public void deleteByTitle(String title) {
        for (DVD potentialDVDMatch : dvdCollection) {
            if (title.equalsIgnoreCase(potentialDVDMatch.getTitle())) {
                dvdCollection.remove(potentialDVDMatch);
            }
        }
    }

    public void displayInformation(DVD dvd) {
        for (DVD potentialDVDMatch : dvdCollection) {
            if (dvd.getTitle().equals(potentialDVDMatch.getTitle())) {
                System.out.println(dvd);
            }
        }
    }

    public void listDVDs() {
        for (DVD dvd : dvdCollection) {
            System.out.println(dvd);
        }
    }

    public void readFromFile(String fileName) {

    }

    public void writeToFile(String fileName) {

    }
}
