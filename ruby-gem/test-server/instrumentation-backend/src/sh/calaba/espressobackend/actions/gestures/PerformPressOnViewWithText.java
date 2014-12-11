package sh.calaba.espressobackend.actions.gestures;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

import org.hamcrest.text.StringContains;

import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

public class PerformPressOnViewWithText implements Action {

    @Override
    public Result execute(String... args) {

        String text = args[0];
        String type = args[1];
        if (type == null || type.equals("SINGLE")) {
            Espresso.onView(ViewMatchers.withText(StringContains.containsString(text)))
                    .perform(ViewActions.click());
        } else if (type.equals("LONG")) {
            Espresso.onView(ViewMatchers.withText(StringContains.containsString(text)))
                    .perform(ViewActions.longClick());
        } else if (type.equals("DOUBLE")) {
            Espresso.onView(ViewMatchers.withText(StringContains.containsString(text)))
                    .perform(ViewActions.doubleClick());
        } else {
            return Result.failedResult("Unrecognized press type " + type + ". Valid values are SINGLE LONG or DOUBLE");
        }

        return Result.successResult();
    }

    @Override
    public String key() {
        return "press_view_with_text";
    }

}
