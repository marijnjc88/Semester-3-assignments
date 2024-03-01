import java.util.Objects;

import lombok.Data;
import lombok.ToString;

@Data
public class SignUpRequest {
    private String email;
    @ToString.Exclude
    private String password;
    private Address address;
}
