package sh.calaba.espressobackend.actions.view;

import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

import org.hamcrest.text.StringContains;

public class ViewWithTextIsDisplayed implements Action {
    @Override
    public Result execute(String... args) {
		String text = args[0];
		Espresso.onView(ViewMatchers.withText(StringContains.containsString(text))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

		return Result.successResult();
    }

    @Override
    public String key() {
        return "view_with_text_is_displayed";
    }
}
