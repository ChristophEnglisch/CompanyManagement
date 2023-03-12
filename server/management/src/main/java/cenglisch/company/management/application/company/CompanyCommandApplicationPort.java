package cenglisch.company.management.application.company;

import cenglisch.company.management.domain.address.AddressService;
import cenglisch.company.management.domain.company.CompanyService;

public class CompanyCommandApplicationPort {

    private final CompanyService companyService;
    private final AddressService addressService;

    public CompanyCommandApplicationPort(CompanyService companyService, AddressService addressService) {
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
