package com.taupier.deya.toomuchtuna;

import androidx.test.espresso.ViewAction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * Instrumented test, which will execute on an Android device.
 *
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TunaInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void PlatingUITest() {
        onView(withId(R.id.scoop_in)).perform(typeText("50"),
                closeSoftKeyboard());
        onView(withId(R.id.eat_in)).perform(typeText("45"),
                closeSoftKeyboard());
        onView(withId(R.id.scoop_type)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Tuna"))).perform((ViewAction) click());


        // Click on a given operation button
        onView(withId(R.id.scoop_it_btn)).perform(click());

        // Check the expected test is displayed in the Ui
        onView(withId(R.id.plated)).check(matches(withText("5 tuna on the plate.")));
    }


}
