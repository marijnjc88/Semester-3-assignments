import java.util.Objects;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@Builder
public class Address {
    private String street;
    private String number;
    private String complement;
    private String postalCode;
    private String city;
    private String state;
}
