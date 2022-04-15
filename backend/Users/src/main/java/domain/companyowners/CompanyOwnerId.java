package domain.companyowners;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class CompanyOwnerId {
    @NonNull UUID id;
}
