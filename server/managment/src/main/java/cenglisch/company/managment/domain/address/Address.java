package cenglisch.company.managment.domain.address;

public class Address {
    private AddressId id;
    private String street;
    private String houseNumber;
    private String zip;
    private String city;

    public Address(String street, String houseNumber, String zip, String city) {

    }

    public AddressId getId() {
        return id;
    }
}
