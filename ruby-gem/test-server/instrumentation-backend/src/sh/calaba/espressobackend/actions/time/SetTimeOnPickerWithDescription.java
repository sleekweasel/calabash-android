package sh.calaba.espressobackend.actions.time;

import java.sql.Time;

import org.hamcrest.Matchers;
import org.hamcrest.text.StringContains;

import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import sh.calaba.espressobackend.query.espresso.TimePickerSetter;
import android.widget.TimePicker;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

public class SetTimeOnPickerWithDescription implements Action {

	@SuppressWarnings("unchecked")
	@Override
	public Result execute(String... args) {

		String contentDescription = args[0];
		Time time = new Time(Time.parse(args[1]));

		Espresso.onView(
				Matchers.allOf(ViewMatchers.isAssignableFrom(TimePicker.class),
						ViewMatchers.withContentDescription(StringContains
								.containsString(contentDescription)))).perform(
				new TimePickerSetter(time));

		return Result.successResult();
	}

	@Override
	public String key() {
		return "set_time_with_description";
	}

}
