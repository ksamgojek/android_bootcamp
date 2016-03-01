package co.creativev.bootcamp.got;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by korneliussamuel on 3/1/16.
 */
public class AddCharacterPresenterTest {
    @Test
    public void testShowErrorWhenNameEmpty() throws Exception {
        AddCharacterView mockAddCharacterView = mock(AddCharacterView.class);
        DatabaseHelper databaseHelper = mock(DatabaseHelper.class);
        AddCharacterPresenter addCharacterPresenter = new AddCharacterPresenter(mockAddCharacterView, databaseHelper);

        addCharacterPresenter.validate("", "file://img1.png", 1);
        verify(mockAddCharacterView).showErrorMessageIfNameEmpty();
    }
    @Test
    public void testShowErrorWhenImagePathEmpty() throws Exception {
        AddCharacterView mockAddCharacterView = mock(AddCharacterView.class);
        DatabaseHelper databaseHelper = mock(DatabaseHelper.class);
        AddCharacterPresenter addCharacterPresenter = new AddCharacterPresenter(mockAddCharacterView, databaseHelper);

        addCharacterPresenter.validate("Name", null, 1);
        verify(mockAddCharacterView).showErrorDialog("Image is not selected");
    }
    @Test
    public void testShowErrorWhenSelectedHouseEmpty() throws Exception {
        AddCharacterView mockAddCharacterView = mock(AddCharacterView.class);
        DatabaseHelper databaseHelper = mock(DatabaseHelper.class);
        AddCharacterPresenter addCharacterPresenter = new AddCharacterPresenter(mockAddCharacterView, databaseHelper);

        addCharacterPresenter.validate("Name", "file://img1.png", -1);
        verify(mockAddCharacterView).showErrorDialog("House is not selected");
    }

    @Test
    public void testShouldAddIfDataIsValid() throws Exception {
        AddCharacterView mockAddCharacterView = mock(AddCharacterView.class);
        DatabaseHelper mockDatabaseHelper = mock(DatabaseHelper.class);
        AddCharacterPresenter addCharacterPresenter = new AddCharacterPresenter(mockAddCharacterView, mockDatabaseHelper);

        addCharacterPresenter.addNewCharacter("name", "file://img/1.jpg", R.id.radio_baratheon);
        verify(mockDatabaseHelper).insert(new GoTCharacter("name", "Unknown", "file://img/1.jpg", true, "New", R.drawable.baratheon, "Lorem", "file://img/1.jpg"));
    }
}