package co.creativev.bootcamp.got;

/**
 * Created by korneliussamuel on 3/1/16.
 */
public class AddCharacterPresenter {
    AddCharacterView addCharacterView;
    DatabaseHelper databaseHelper;

    public AddCharacterPresenter(AddCharacterView addCharacterView,DatabaseHelper databaseHelper) {
        this.addCharacterView = addCharacterView;
        this.databaseHelper = databaseHelper;
    }

    public boolean validate(String name, String imagePath, int selectedHouse) {
        if (name.isEmpty()) {
            addCharacterView.showErrorMessageIfNameEmpty();
            return true;
        }
        if (imagePath == null) {
            addCharacterView.showErrorDialog("Image is not selected");
            return true;
        }
        if (selectedHouse == -1) {
            addCharacterView.showErrorDialog("House is not selected");
            return true;
        }
        return false;
    }

    public void addNewCharacter(String name, String imagePath, int selectedHouse) {
        int houseResId = getHouseResId(selectedHouse);

        if (validate(name, imagePath, selectedHouse)){
            return;
        }

        String[] names = name.split(" ");
        String firstName = names[0];
        String lastName;

        if (names.length > 1) {
            lastName = name.substring(name.indexOf(" "));
        } else {
            lastName = "Unknown";
        }
        long id = databaseHelper.insert(new GoTCharacter(firstName, lastName, imagePath, true, "New", houseResId, "Lorem", imagePath));

        if (id == -1) {
            addCharacterView.logErrorWhileInsertData();
        } else {
            addCharacterView.toastWhileDataIsInserted();
        }
    }

    public int getHouseResId(int radioButtonId) {
        switch (radioButtonId) {
            case R.id.radio_baratheon:
                return R.drawable.baratheon;
            case R.id.radio_lannister:
                return R.drawable.lannister;
            case R.id.radio_stark:
                return R.drawable.stark;
            case R.id.radio_targaryen:
                return R.drawable.targaryen;
            default:
                throw new IllegalArgumentException("No icon found for radio button " + radioButtonId);
        }
    }

}
