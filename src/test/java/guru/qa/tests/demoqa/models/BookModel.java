package guru.qa.tests.demoqa.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookModel {
    private String isbn;
    private String userId;
}
