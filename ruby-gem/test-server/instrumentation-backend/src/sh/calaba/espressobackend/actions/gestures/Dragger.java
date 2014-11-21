package sh.calaba.espressobackend.actions.gestures;

import android.os.SystemClock;
import android.view.MotionEvent;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;

class Dragger {
    public static void drag(float fromX, float toX, float fromY, float toY, int stepCount) {
        long downTime = SystemClock.uptimeMillis();
        long eventTime = SystemClock.uptimeMillis();
        float y = fromY;
        float x = fromX;
        float yStep = (toY - fromY) / stepCount;
        float xStep = (toX - fromX) / stepCount;
        MotionEvent event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, fromX, fromY, 0);
        try {
            EspressoInstrumentationBackend.instrumentation.sendPointerSync(event);
        } catch (SecurityException ignored) {
            // Ignored
        }
        for (int i = 0; i < stepCount; ++i) {
            y += yStep;
            x += xStep;
            eventTime = SystemClock.uptimeMillis();
            event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_MOVE, x, y, 0);
            try {
                EspressoInstrumentationBackend.instrumentation.sendPointerSync(event);
            } catch (SecurityException ignored) {
                // Ignored
            }
        }
        eventTime = SystemClock.uptimeMillis();
        event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, toX, toY, 0);
        try {
            EspressoInstrumentationBackend.instrumentation.sendPointerSync(event);
        } catch (SecurityException ignored) {
            // Ignored
        }
    }
}
