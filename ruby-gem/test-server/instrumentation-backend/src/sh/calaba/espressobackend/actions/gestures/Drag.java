package sh.calaba.espressobackend.actions.gestures;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

import android.util.DisplayMetrics;

public class Drag implements Action {

	@Override
	public Result execute(String... args) {

		Float fromX = new Float(args[0]);
		Float toX = new Float(args[1]);
		Float fromY = new Float(args[2]);
		Float toY = new Float(args[3]);
		Integer stepCount = new Integer(args[4]);

		DisplayMetrics dm = new DisplayMetrics();
		EspressoInstrumentationBackend.solo.getCurrentActivity().getWindowManager()
				.getDefaultDisplay().getMetrics(dm);
		Integer windowWidth = dm.widthPixels;
		Integer windowHeight = dm.heightPixels;

		EspressoInstrumentationBackend.solo.drag(fromX / 100 * windowWidth, 
				toX / 100 * windowWidth, 
				fromY / 100 * windowHeight, 
				toY / 100 * windowHeight, 
				stepCount);

		return Result.successResult();
	}

	@Override
	public String key() {
		return "drag";
	}

}
