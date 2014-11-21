package sh.calaba.espressobackend.actions.text;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.lang.reflect.Field;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

public class HideSoftKeyboard implements Action {
    @Override
    public Result execute(String... args) {
        Context context = EspressoInstrumentationBackend.instrumentation.getTargetContext();
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);

        Activity activity = EspressoInstrumentationBackend.solo.getCurrentActivity();
        View view;

        view = InfoMethodUtil.tryGetServedView();

        if (view == null) {
            view = activity.getCurrentFocus();
        }

        if (view == null) {
            view = new View(activity);
        }

        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

        return Result.successResult();
    }

    @Override
    public String key() {
        return "hide_soft_keyboard";
    }
}