package guru.qa.tests.demoqa.tests;

import guru.qa.tests.demoqa.api.AuthorizationAPI;
import guru.qa.tests.demoqa.api.BooksAPI;
import guru.qa.tests.demoqa.models.AddBooksListModel;
import guru.qa.tests.demoqa.models.AuthModel;
import guru.qa.tests.demoqa.models.BookModel;
import org.junit.jupiter.api.Test;

import java.util.List;
import static guru.qa.tests.demoqa.tests.TestData.*;


public class ProfileBooksListTests extends TestBase {

    @Test
    void addBookList(){
        AuthModel authModel = AuthorizationAPI.login(credentials);
        BooksAPI.deleteAllBooks(authModel.getUserId(), authModel.getToken());
        AddBooksListModel booksList = new AddBooksListModel(authModel.getUserId(), List.of(isbnModel));
        BooksAPI.addBooks(authModel.getToken(), booksList);

        profilePage.openWithCookieDrop(authModel);
        profilePage.checkIfBookIsAdded("[id='see-book-Git Pocket Guide']");
    }

    @Test
    void deleteBook(){
        AuthModel authModel = AuthorizationAPI.login(credentials);
        BooksAPI.deleteAllBooks(authModel.getUserId(), authModel.getToken());
        AddBooksListModel booksList = new AddBooksListModel(authModel.getUserId(), List.of(isbnModel));
        BooksAPI.addBooks(authModel.getToken(), booksList);

        BooksAPI.deleteBook(
                new BookModel(isbnModel.getIsbn(), authModel.getUserId()),
                authModel.getToken()
        );

        profilePage.openWithCookieDrop(authModel);
        profilePage.noRowsCheck();
    }

}
