package sh.calaba.espressobackend.actions.gestures;

import android.view.Display;
import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

public class DoubleTapCoordinate implements Action {
    @Override
    public Result execute(String... args) {
        Display display = EspressoInstrumentationBackend.solo.getCurrentActivity().getWindowManager().getDefaultDisplay();

        float x = Float.parseFloat(args[0]);
        float y = Float.parseFloat(args[1]);

        EspressoInstrumentationBackend.solo.doubleTapOnScreen(x, y);

        return Result.successResult();
    }

    @Override
    public String key() {
        return "double_tap_coordinate";
    }
}
