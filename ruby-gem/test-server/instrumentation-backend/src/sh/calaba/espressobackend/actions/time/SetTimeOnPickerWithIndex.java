package sh.calaba.espressobackend.actions.time;

import java.sql.Time;

import org.hamcrest.Matchers;

import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import sh.calaba.espressobackend.matchers.WithIndex;
import sh.calaba.espressobackend.query.espresso.TimePickerSetter;
import android.widget.TimePicker;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

public class SetTimeOnPickerWithIndex implements Action {

	@SuppressWarnings("unchecked")
	@Override
	public Result execute(String... args) {

		int expectedIndex = Integer.parseInt(args[0]);
		Time time = new Time(Time.parse(args[1]));

		Espresso.onView(
				Matchers.allOf(ViewMatchers.isAssignableFrom(TimePicker.class),
						new WithIndex(expectedIndex))).perform(
				new TimePickerSetter(time));

		return Result.successResult();
	}

	@Override
	public String key() {
		return "set_time_with_index";
	}

}
