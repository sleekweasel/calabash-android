package sh.calaba.espressobackend.actions.gestures;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import android.view.Display;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.Tap;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

public class DoubleTapCoordinate implements Action {
    @Override
    public Result execute(String... args) {
        Display display = EspressoInstrumentationBackend.getCurrentActivity().getWindowManager().getDefaultDisplay();

        float x = Float.parseFloat(args[0]);
        float y = Float.parseFloat(args[1]);

        int width = display.getWidth();
        int height = display.getHeight();
        
        Espresso.onView(ViewMatchers.withId(android.R.id.content))
        .perform(PerformGestureOnCoordinates.performPressOnSpecificCoordinates(Tap.DOUBLE, (int)(x/100)*width, (int) (y/100)*height));
        
        return Result.successResult();
    }

    @Override
    public String key() {
        return "double_tap_coordinate";
    }
}
