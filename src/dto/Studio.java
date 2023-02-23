package dto;

/**
 * Ben Miller - 2022-02-23
 * The studio class is composed of a studio name and a user-defined Address
 */
public class Studio {
    private String name;
    private Address address;

    public Studio() {

    }

    public Studio(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Studio Name: " + this.getName() + "\n"
                + "Studio Address:\n" + this.getAddress().toString();
    }
}
