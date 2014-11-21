package sh.calaba.espressobackend.actions.gestures;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

public class DragCoordinates implements Action {

	@Override
	public Result execute(String... args) {

		Float fromX = new Float(args[0]);
		Float fromY = new Float(args[1]);
		Float toX = new Float(args[2]);
		Float toY = new Float(args[3]);
		Integer stepCount = 40;

        Dragger.drag(fromX,	toX, fromY,	toY, stepCount);

		return Result.successResult();
	}

	@Override
	public String key() {
		return "drag_coordinates";
	}

}
