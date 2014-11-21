package sh.calaba.espressobackend.actions.gestures;


import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import android.view.Display;


public class ClickOnScreen implements Action {

    @Override
    public Result execute(String... args) {
        Display display = EspressoInstrumentationBackend.solo.getCurrentActivity().getWindowManager().getDefaultDisplay();
        
        float x = Float.parseFloat(args[0]);
        float y = Float.parseFloat(args[1]);
        
        int width = display.getWidth();
        int height = display.getHeight();
        
        EspressoInstrumentationBackend.solo.clickOnScreen((x/100)*width, (y/100)*height);
        return Result.successResult();
    }

    @Override
    public String key() {
        return "click_on_screen";
    }

}
