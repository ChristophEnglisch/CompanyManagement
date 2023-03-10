package cenglisch.company.management.domain.address;

import cenglisch.domain.model.Repository;

import java.util.Optional;

public interface AddressRepository extends Repository<Address, AddressId> {
    Optional<Address> findByStreetAndHouseNumberAndZipAndCity(String street, String houseNumber, String zip, String city);
}
