package domain.companyowners;

import lombok.Getter;

import java.util.UUID;

public class CompanyOwner {
    private final CompanyOwnerId companyOwnerId;

    @Getter
    private String name;

    private CompanyOwner(
        CompanyOwnerId companyOwnerId,
        String name
    ) {
        this.companyOwnerId = companyOwnerId;
        this.name = name;
    }

    public static CompanyOwner CreateNew(
        String name
    ) {
        return new CompanyOwner(new CompanyOwnerId(UUID.randomUUID()), name);
    }

    public void setName(String name) {
        this.name = name;
    }
}

