package sh.calaba.espressobackend.actions.view;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import android.app.Activity;

/**
 * This action checks that the current activity under test has the focus.
 * 
 * This is useful to run tests across different applications (for example,
 * your application launching the browser). Since the instrumentation can
 * only work with the application under test, then all we can assert is that
 * said application has lost the focus.
 * 
 * @author Gianpiero Puleo (gianpi@ustwo.co.uk)
 * @author Juan Delgado (juan@ustwo.co.uk)
 */
@SuppressWarnings("deprecation")
public class IsCurrentActivityFocused implements Action {

	@Override
	public Result execute(String... args) {
		
		Activity currentActivity = EspressoInstrumentationBackend.solo.getCurrentActivity();
		
		String hasFocus = "false";
		
		if (currentActivity.hasWindowFocus()) {
			hasFocus = "true";
		}
		
		return new Result(true, hasFocus);	
	}

	@Override
	public String key() {
		return "is_current_activity_focused";
	}
}