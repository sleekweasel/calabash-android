package sh.calaba.espressobackend.actions.view;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import android.app.Activity;
import android.app.TabActivity;

/**
 * @author Nicholas Albion
 */
@SuppressWarnings("deprecation")
public class GetActivityName implements Action {

	@Override
	public Result execute(String... args) {
		Activity currentActivity = EspressoInstrumentationBackend.getCurrentActivity();
		
		Result result = new Result(true, currentActivity.getClass().getSimpleName());
		
		if( currentActivity instanceof TabActivity ) {
			result.addBonusInformation( ((TabActivity)currentActivity).getTabHost().getCurrentTabTag() );
		}
		
		return result;
	}

	@Override
	public String key() {
		return "get_activity_name";
	}
}
