package co.creativev.bootcamp.got;

import android.graphics.Color;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by korneliussamuel on 3/1/16.
 */
public class GoTCharacterViewModelTest {
//    public GoTCharacter goTCharacter;
//    public GoTCharacterViewModel goTCharacterViewModel;
//
//    @Before
//    public void setUp() throws Exception {
//        goTCharacter = new GoTCharacter("Test", "Gojek", null, false, null, 0, null, null);
//        goTCharacterViewModel = new GoTCharacterViewModel(goTCharacter);
//    }

    @Test
    public void testGetFullName() throws Exception {
        GoTCharacter goTCharacter = new GoTCharacter("Test", "Gojek", null, true, null, 0, null, null);
        GoTCharacterViewModel goTCharacterViewModel = new GoTCharacterViewModel(goTCharacter);

        String fullName = goTCharacterViewModel.getFullName();
        assertEquals("Test Gojek", fullName);
    }

    @Test
    public void testColorAsRedForDead() throws Exception {
        GoTCharacter goTCharacter = new GoTCharacter("Test", "Gojek", null, false, null, 0, null, null);
        GoTCharacterViewModel goTCharacterViewModel = new GoTCharacterViewModel(goTCharacter);

        int color = goTCharacterViewModel.getColor();
        assertEquals(Color.RED, color);
    }
    @Test
    public void testColorAsGreenForAlive() throws Exception {
        GoTCharacter goTCharacter = new GoTCharacter("Test", "Gojek", null, true, null, 0, null, null);
        GoTCharacterViewModel goTCharacterViewModel = new GoTCharacterViewModel(goTCharacter);

        int color = goTCharacterViewModel.getColor();
        assertEquals(Color.GREEN, color);
    }

}