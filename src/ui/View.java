package ui;

import dto.DVD;

import java.util.List;

public interface View {
    void printMenu();

    void printViewDVDBanner();

    void printViewDVDSuccessBanner();

    void printCreateDVDBanner();

    void printCreateDVDSuccessBanner();

    void printRemoveDVDBanner();

    void printRemoveDVDSuccessBanner();

    void printEditDVDBanner();

    void printEditDVDSuccessBanner();

    void printListDVDsBanner();

    void printListDVDsSuccessBanner();

    void displayAllDVDs(List<DVD> dvds);

    int readInt(String prompt);

    DVD makeDVDFromInfo();

    String getDVDTitle();
}
