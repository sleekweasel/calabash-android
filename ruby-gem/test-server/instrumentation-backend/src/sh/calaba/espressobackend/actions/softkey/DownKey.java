package sh.calaba.espressobackend.actions.softkey;


import com.jayway.android.robotium.solo.Solo;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;


public class DownKey implements Action {

    @Override
    public Result execute(String... args) {
        EspressoInstrumentationBackend.solo.sendKey(Solo.DOWN);
        return Result.successResult();
    }

    @Override
    public String key() {
        return "send_key_down";
    }

}
