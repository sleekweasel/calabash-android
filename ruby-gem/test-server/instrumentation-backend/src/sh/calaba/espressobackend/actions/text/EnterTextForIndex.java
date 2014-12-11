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
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class EnterTextForIndex implements Action {
    @Override
    public Result execute(String... args) {
        String text = args[0];
        int index = Integer.parseInt(args[1]);
        Espresso.onView(allOf(isAssignableFrom(EditText.class), new WithIndex(index)))
                .perform(ViewActions.typeText(text));
        
        return Result.successResult();
    }

    @Override
    public String key() {
        return "enter_text_for_index";
    }
}
