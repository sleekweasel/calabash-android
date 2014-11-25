package sh.calaba.espressobackend.query.espresso;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import android.view.View;

import com.google.android.apps.common.testing.ui.espresso.UiController;
import com.google.android.apps.common.testing.ui.espresso.ViewAction;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

public class ViewCaptor implements ViewAction {

	private final List<View> affectedViews = new ArrayList<View>();
	
	@Override
	public Matcher<View> getConstraints() {
		return Matchers.anything();
	}

	@Override
	public String getDescription() {
		return "Captures the views on the onView so it can be used to find views by querying";
	}

	@Override
	public void perform(UiController controller, View affectedView) {
		affectedViews.add(affectedView);
	}

	public List<View> getCapturedViews() {
		return affectedViews;
	}

}
