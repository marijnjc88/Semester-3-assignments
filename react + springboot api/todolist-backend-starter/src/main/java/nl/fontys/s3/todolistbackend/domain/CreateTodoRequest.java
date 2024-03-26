package nl.fontys.s3.todolistbackend.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTodoRequest {
    @NotBlank
    private String title;
}
