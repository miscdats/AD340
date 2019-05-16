package com.taupier.deya.toomuchtuna;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TunaInstrumentationTest {

    /**
     * Use {@link MainActivity} to create and launch of the activity.
     */
    @Before
    public void launchActivity() {
        MainActivity.launch(MainActivity.class);
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.taupier.deya.toomuchtuna", appContext.getPackageName());
    }

    @Test
    public void inputTunaScoopAndEat() {
        performOperation(R.id.scoop_it_btn, "50", "45",
                "Tuna", "5 tuna on the plate.");
    }

    @Test
    public void spinnerPickNothingShowsComplaintToast() {

    }

    @Test
    public void inputTooMuchTuna() {
        performOperation(R.id.scoop_it_btn, "50", "20",
                "Tuna", "TOO MUCH TUNA!!!!!!");
    }

    private void performOperation(int btnOperationResId, String operandOne,
                                  String operandTwo, String type, String expectedResult) {
        // Type the two operands in the EditText fields
        onView(withId(R.id.scoop_in)).perform(typeText(operandOne),
                closeSoftKeyboard());
        onView(withId(R.id.eat_in)).perform(typeText(operandTwo),
                closeSoftKeyboard());
        onView(withId(R.id.scoop_type)).perform(typeText(type),
                closeSoftKeyboard());

        // Click on a given operation button
        onView(withId(btnOperationResId)).perform(click());

        // Check the expected test is displayed in the Ui
        onView(withId(R.id.plated)).check(matches(withText(expectedResult)));
    }


}
