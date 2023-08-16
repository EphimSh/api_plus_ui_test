package guru.qa.tests.demoqa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddBooksListModel {
    private String userId;
    @JsonProperty("collectionOfIsbns")
    private List<IsbnModel> booksCollection;
}
