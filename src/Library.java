public interface Library<T> {
    // Adds an item to the library
    public void add(T libraryItem);

    // Removes a particular item from the library
    public void remove(T libraryItem);

    // Displays the information for a particular item
    public String displayInformation(T libraryItem);


}
