package com.example.strig.mobilecomputingclass;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.strig.mobilecomputingclass.le180313_Testing.TestingActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleUITest {
    @Rule
    public IntentsTestRule<TestingActivity> testActivityIntentsTestRule =
            new IntentsTestRule<>(TestingActivity.class);

    @Test
    public void validStringTest() {
        onView(withId(R.id.le180313_fname))
                .perform(typeText("Name"));
        onView(withId(R.id.le180313_lname))
                .perform(typeText("Lastname"));

        onView(withId(R.id.le180313_submit_button)).perform(click());

        intended(allOf(
                hasComponent(hasShortClassName(".le180313.TextActivity")),
                toPackage("com.example.strig.mobilecomputingclass")
        ));

        onView(withId(R.id.le180313_names))
                .check(matches(withText("Name Lastname")));
    }

    @Test
    public void nameLowercaseLastnameUppercaseTest() {
        onView(withId(R.id.le180313_fname))
                .perform(typeText("name"));
        onView(withId(R.id.le180313_lname))
                .perform(typeText("Lastname"));

        onView(withId(R.id.le180313_submit_button)).perform(click());

        onView(withId(R.id.le180313_names))
                .check(matches(withText("")));
    }
}
