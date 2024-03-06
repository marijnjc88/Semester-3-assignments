package fontys.sem3.school.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCountryRequest {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String code;
}
