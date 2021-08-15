package ua.sukhorutchenko.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO {

    private Long id;

    private String fullName;

    public AuthorDTO(String name) {
        this.fullName = name;
    }

}
