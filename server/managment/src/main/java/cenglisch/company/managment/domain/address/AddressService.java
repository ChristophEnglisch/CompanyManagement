package cenglisch.company.managment.domain.address;

import cenglisch.company.managment.domain.EventHandler;

import java.util.Optional;

public class AddressService {

    private final AddressRepository addressRepository;

    private final EventHandler eventHandler;

    public AddressService(AddressRepository addressRepository, EventHandler eventHandler) {
        this.addressRepository = addressRepository;
        this.eventHandler = eventHandler;
    }

    public AddressId createOrGetAddress(String street, String houseNumber, String zip, String city) {
        Optional<Address> optionalAddress = addressRepository.findByStreetAndHouseNumberAndZipAndCity(street, houseNumber, zip, city);
        if (optionalAddress.isPresent()) {
            return optionalAddress.get().getId();
        }
        final Address address = new Address(street, houseNumber, zip, city);
        addressRepository.save(address);
        return address.getId();
    }
}