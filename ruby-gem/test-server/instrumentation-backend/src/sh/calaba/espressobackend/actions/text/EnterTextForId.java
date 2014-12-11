package sh.calaba.espressobackend.actions.text;

import android.text.Editable;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isAssignableFrom;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class EnterTextForId implements Action {
    @Override
    public Result execute(String... args) {
        String text = args[0];
        String id = args[1];
        int resourceId = EspressoInstrumentationBackend
                .getCurrentActivity()
                .getResources()
                .getIdentifier(
                        id,
                        "id",
                        EspressoInstrumentationBackend.getCurrentActivity()
                                .getPackageName());
        Espresso.onView(allOf(isAssignableFrom(EditText.class), withId(resourceId))).perform(ViewActions.typeText(text));

        return Result.successResult();
    }

    @Override
    public String key() {
        return "enter_text_for_id";
    }
}
