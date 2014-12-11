package sh.calaba.espressobackend.actions.checkbox;

import android.widget.CheckBox;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import sh.calaba.espressobackend.matchers.WithIndex;

import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isAssignableFrom;
import static org.hamcrest.Matchers.allOf;

public class ToggleCheckboxWithIndex implements Action {
	@Override
	public Result execute(String... args) {
		int index = Integer.parseInt(args[0]);
		Espresso.onView(allOf(isAssignableFrom(CheckBox.class), new WithIndex(index))).perform(ViewActions.click());

		return Result.successResult();
	}

	@Override
	public String key() {
		return "toggle_checkbox_with_index";
	}
}
