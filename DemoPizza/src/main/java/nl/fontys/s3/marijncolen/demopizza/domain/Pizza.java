package nl.fontys.s3.marijncolen.demopizza.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

@AllArgsConstructor
@Data
@Builder
public class Pizza {
    private String name;
    private Double price;
}
