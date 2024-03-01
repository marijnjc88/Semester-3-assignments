package nl.fontys.s3.starter.business;

import nl.fontys.s3.starter.domain.GetCheapestRequest;
import nl.fontys.s3.starter.domain.GetCheapestResponse;

public interface GetCheapestUseCase {
    GetCheapestResponse getCheapest(GetCheapestRequest request);
}
