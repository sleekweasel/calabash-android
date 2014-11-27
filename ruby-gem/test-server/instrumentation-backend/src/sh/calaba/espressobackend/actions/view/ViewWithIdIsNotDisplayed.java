package sh.calaba.espressobackend.actions.view;

import org.hamcrest.Matchers;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.NoMatchingViewException;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

public class ViewWithIdIsNotDisplayed implements Action {
	@Override
	public Result execute(String... args) {
		String id = args[0];
		int resourceId = EspressoInstrumentationBackend
				.getCurrentActivity()
				.getResources()
				.getIdentifier(id, "id", EspressoInstrumentationBackend.getCurrentActivity().getPackageName());
		Espresso.onView(ViewMatchers.withId(resourceId)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

		try {
			Espresso.onView(ViewMatchers.withId(resourceId)).check(ViewAssertions.matches((Matchers.not(ViewMatchers.isDisplayed()))));
		} catch (NoMatchingViewException nme) {
			Espresso.onView(ViewMatchers.withId(resourceId)).check(ViewAssertions.doesNotExist());
		}
		
		return Result.successResult();
	}

	@Override
	public String key() {
		return "view_with_id_is_not_displayed";
	}
}
