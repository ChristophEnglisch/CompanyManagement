package cenglisch.company.managment.application.company;

import cenglisch.company.managment.domain.address.AddressService;
import cenglisch.company.managment.domain.company.CompanyService;

public class CompanyApplicationPort {

    private final CompanyService companyService;
    private final AddressService addressService;

    public CompanyApplicationPort(CompanyService companyService, AddressService addressService) {
        this.companyService = companyService;
        this.addressService = addressService;
    }

    public void openCompany(OpenCompany openCompany) {
        companyService.openCompany(
                openCompany.managerId(),
                addressService.createOrGetAddress(
                        openCompany.street(),
                        openCompany.houseNumber(),
                        openCompany.zip(),
                        openCompany.city()
                ),
                openCompany.companyName()
        );
    }

    public void closeCompany(CloseCompany closeCompany) {
        companyService.closeCompany(closeCompany.companyId());
    }
}
