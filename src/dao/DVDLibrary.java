package dao;
/*
Ben Miller - 2022-02-22
dao.DVDLibrary interacts with FileIO to read and write a dto.DVD dao.Library
 */

import dto.DVD;

import java.util.ArrayList;

public class DVDLibrary implements Library<DVD> {
    private ArrayList<DVD> dvdCollection= new ArrayList<DVD>();
    public void add(DVD dvd) {
        dvdCollection.add(dvd);
    }

    public void remove(DVD dvd) {
        dvdCollection.remove(dvd);
    }

    public String displayInformation(DVD dvd) {
        for (DVD potentialDVDMatch : dvdCollection) {
            if (dvd.getTitle().equals(potentialDVDMatch.getTitle())) {
                return dvd.toString();
            }
        }
        return null;
    }
}
