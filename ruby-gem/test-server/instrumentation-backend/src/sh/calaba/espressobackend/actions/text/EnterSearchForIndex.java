package sh.calaba.espressobackend.actions.text;

import android.widget.EditText;
import android.widget.SearchView;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;

import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import sh.calaba.espressobackend.matchers.WithIndex;

import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isAssignableFrom;
import static org.hamcrest.core.AllOf.allOf;

public class EnterSearchForIndex implements Action {
    @Override
    public Result execute(String... args) {
        String text = args[0];
        int index = Integer.parseInt(args[1]);
        Espresso.onView(allOf(isAssignableFrom(SearchView.class), new WithIndex(index)))
                .perform(ViewActions.typeText(text));
        
        return Result.successResult();
    }

    @Override
    public String key() {
        return "enter_search_for_index";
    }
}
