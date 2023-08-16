package guru.qa.tests.demoqa.tests;

import guru.qa.tests.demoqa.models.CredentialsModel;
import guru.qa.tests.demoqa.models.IsbnModel;
import guru.qa.tests.demoqa.pages.ProfilePage;

public class TestData {
    private static String
            login = "user010101",
            password = "Passw00rd!",
            isbn = "9781449325862";
    public static CredentialsModel credentials = new CredentialsModel(login, password);
    public static IsbnModel isbnModel = new IsbnModel(isbn);
    public static ProfilePage profilePage = new ProfilePage();
}
