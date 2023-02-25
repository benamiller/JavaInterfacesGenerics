package dao;

/*
Ben Miller - 2022-02-22
An interface defining the necessary behaviour for and properties of
a library/collection of items
 */
public interface Library<T> {
    // Adds an item to the library
    public void create(T libraryItem);

    // Removes a particular item from the library
    public void deleteByTitle(String libraryItemTitle);

    // Displays the information for a particular item
    public void displayInformation(T libraryItem);


}
