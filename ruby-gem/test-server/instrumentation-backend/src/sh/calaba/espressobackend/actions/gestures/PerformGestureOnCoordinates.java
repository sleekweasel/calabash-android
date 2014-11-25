package sh.calaba.espressobackend.actions.gestures;

import android.view.View;

import com.google.android.apps.common.testing.ui.espresso.ViewAction;
import com.google.android.apps.common.testing.ui.espresso.action.CoordinatesProvider;
import com.google.android.apps.common.testing.ui.espresso.action.GeneralClickAction;
import com.google.android.apps.common.testing.ui.espresso.action.Press;
import com.google.android.apps.common.testing.ui.espresso.action.Tap;

class PerformGestureOnCoordinates {
	
    static ViewAction performPressOnSpecificCoordinates(Tap tap, final int x, final int y) {
        return new GeneralClickAction(
            tap,
            new CoordinatesProvider() {
                @Override
                public float[] calculateCoordinates(View view) {

                   final int[] screenPos = new int[2];
                   view.getLocationOnScreen(screenPos);

                   final float screenX = screenPos[0] + x;
                   final float screenY = screenPos[1] + y;
                   float[] coordinates = {screenX, screenY};

                   return coordinates;
                }
            },
            Press.FINGER);
    }
    
}
