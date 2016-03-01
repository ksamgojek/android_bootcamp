package co.creativev.bootcamp.got;

import android.graphics.Color;
import android.support.annotation.NonNull;

/**
 * Created by korneliussamuel on 3/1/16.
 */
public class GoTCharacterViewModel {
    public GoTCharacter gotCharacter;

    public GoTCharacterViewModel(GoTCharacter gotCharacter) {
        this.gotCharacter = gotCharacter;
    }

    @NonNull
    public String getFullName() {
        return gotCharacter.getFirstName() + " " + gotCharacter.getLastName();
    }

    public int getColor() {
        return gotCharacter.isAlive() ? Color.GREEN : Color.RED;
    }

    @SuppressWarnings("unused")
    public String getDescription() {
        return gotCharacter.getDescription();
    }
}
