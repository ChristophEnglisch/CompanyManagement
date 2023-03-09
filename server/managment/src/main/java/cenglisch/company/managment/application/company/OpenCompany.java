package cenglisch.company.managment.application.company;

import cenglisch.company.managment.domain.manager.ManagerId;

public record OpenCompany(
        ManagerId managerId,
        String companyName,
        String street,
        String houseNumber,
        String zip,
        String city
) {}
