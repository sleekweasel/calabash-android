package sh.calaba.espressobackend.actions.softkey;


import com.jayway.android.robotium.solo.Solo;
import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.TestHelpers;
import sh.calaba.espressobackend.actions.Action;
import sh.calaba.espressobackend.actions.Actions;


public class PressMenu implements Action {

    @Override
    public Result execute(String... args) {
        Actions.parentInstrumentation.sendKeyDownUpSync(Solo.MENU);
        TestHelpers.wait(1);
        return Result.successResult();
    }

    @Override
    public String key() {
        return "press_menu";
    }

}
