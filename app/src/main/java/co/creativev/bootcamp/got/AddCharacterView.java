package co.creativev.bootcamp.got;

/**
 * Created by korneliussamuel on 3/1/16.
 */
public interface AddCharacterView {

    void showErrorMessageIfNameEmpty();

    void showErrorDialog(String s);

    void logErrorWhileInsertData();

    void toastWhileDataIsInserted();
}
