package cenglisch.company.management.domain.company;

import cenglisch.company.management.domain.address.AddressId;
import cenglisch.company.management.domain.company.events.CompanyClosed;
import cenglisch.company.management.domain.company.events.CompanyOpened;
import cenglisch.company.management.domain.manager.ManagerId;
import cenglisch.domain.model.EventHandler;

public class CompanyService {
    private final CompanyRepository companyRepository;
    private final EventHandler eventHandler;

    public CompanyService(
            CompanyRepository companyRepository,
            EventHandler eventHandler
    ) {
        this.companyRepository = companyRepository;
        this.eventHandler = eventHandler;
    }

    public void openCompany(ManagerId managerId, AddressId addressId, String companyName) {
        final Company company = companyRepository.save(new Company(addressId, companyName));
        eventHandler.publish(new CompanyOpened(company.getId(), managerId));
    }

    public void closeCompany(CompanyId companyId) {
        final Company company = companyRepository.find(companyId).orElseThrow(CompanyNotFoundException::new);
        companyRepository.remove(company);
        eventHandler.publish(new CompanyClosed(companyId));
    }
}
