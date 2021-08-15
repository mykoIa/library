package ua.sukhorutchenko.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PublisherDTO {

    private Long id;

    private String publisherName;

    public PublisherDTO(String name) {
        this.publisherName = name;
    }

}
