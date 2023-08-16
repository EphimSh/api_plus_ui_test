package guru.qa.tests.demoqa.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialsModel {
    private String userName, password;
}
