package com.deltorostudios.tddanielmalone;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.deltorostudios.tddanielmalone", appContext.getPackageName());
    }

    @Test
    public void userCanEnterFirstName() {
       onView(withId(R.id.firstName)).perform(typeText("Fran"));
    }

    @Test
    public void userCanEnterLastName() {
        onView(withId(R.id.lastName)).perform(typeText("Glacken"));
    }

    @Test
    public void whenUserEntersFirstAndLastName() {
        onView(withId(R.id.firstName)).perform(typeText("Super"));
        onView(withId(R.id.lastName)).perform(typeText("Mario"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Welcome, Super Mario!!")));

    }

    @Test
    public void whenUseraEntersFirstAndLastName() {
        onView(withId(R.id.firstName)).perform(typeText("Chrono"));
        onView(withId(R.id.lastName)).perform(typeText("Trigger"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.message)).check(matches(withText("Welcome, Chrono Trigger!!")));

    }
}
