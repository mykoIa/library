package ua.sukhorutchenko.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String login;

    private String password;

    private String role;

    private String status;

}
