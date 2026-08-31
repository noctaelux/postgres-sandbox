package net.providence.postgressandbox.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "Nombre requerido")
    private String name;
    private String surname;
    @NotBlank(message = "Correo requerido")
    private String email;

}
