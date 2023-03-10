package cenglisch.company.management.domain.company;

import cenglisch.company.management.domain.address.AddressId;

//@AggregateRoot
public class Company {

    private CompanyId id;

    private AddressId addressId;
    private String name;


    public Company(AddressId addressId, String name) {
        setAddressId(addressId);
        setName(name);
    }

    private void setAddressId(AddressId addressId) {
        this.addressId = addressId;
    }

    private void setName(String name) {
        this.name = name;
    }

    public CompanyId getId() {
        return id;
    }
}