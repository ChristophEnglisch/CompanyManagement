package cenglisch.company.management.application.company;

import cenglisch.company.management.domain.manager.ManagerId;

public record OpenCompany(
        ManagerId managerId,
        String companyName,
        String street,
        String houseNumber,
        String zip,
        String city
) {}
