package sh.calaba.espressobackend.actions.text;

import android.widget.EditText;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

import org.hamcrest.text.StringContains;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isAssignableFrom;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;

public class ClearTextForMarked implements Action {
    @Override
    public Result execute(String... args) {
        String marked = args[1];
        int resourceId = EspressoInstrumentationBackend
                .getCurrentActivity()
                .getResources()
                .getIdentifier(
                        marked,
                        "id",
                        EspressoInstrumentationBackend.getCurrentActivity()
                                .getPackageName());

        Espresso.onView(allOf(isAssignableFrom(EditText.class),
                anyOf(ViewMatchers.withId(resourceId),
                        ViewMatchers.withText(StringContains.containsString(marked)),
                        ViewMatchers.withContentDescription(StringContains.containsString(marked)))))
                .perform(ViewActions.clearText());

        return Result.successResult();
    }

    @Override
    public String key() {
        return "clear_text_for_marked";
    }
}
