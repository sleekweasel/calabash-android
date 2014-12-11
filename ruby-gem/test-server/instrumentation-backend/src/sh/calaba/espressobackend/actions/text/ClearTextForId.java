package sh.calaba.espressobackend.actions.text;

import android.widget.EditText;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import sh.calaba.espressobackend.matchers.WithIndex;

import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isAssignableFrom;
import static org.hamcrest.core.AllOf.allOf;

public class ClearTextForId implements Action {
    @Override
    public Result execute(String... args) {
        String id = args[1];
        int resourceId = EspressoInstrumentationBackend
                .getCurrentActivity()
                .getResources()
                .getIdentifier(
                        id,
                        "id",
                        EspressoInstrumentationBackend.getCurrentActivity()
                                .getPackageName());

        Espresso.onView(allOf(isAssignableFrom(EditText.class), ViewMatchers.withId(resourceId)))
                .perform(ViewActions.clearText());
        
        return Result.successResult();
    }

    @Override
    public String key() {
        return "clear_text_for_id";
    }
}
