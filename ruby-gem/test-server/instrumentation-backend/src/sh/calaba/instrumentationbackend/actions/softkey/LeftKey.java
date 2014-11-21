package sh.calaba.instrumentationbackend.actions.softkey;


import com.jayway.android.robotium.solo.Solo;

import sh.calaba.instrumentationbackend.RobotiumInstrumentationBackend;
import sh.calaba.instrumentationbackend.Result;
import sh.calaba.instrumentationbackend.actions.Action;


public class LeftKey implements Action {

    @Override
    public Result execute(String... args) {
        RobotiumInstrumentationBackend.solo.sendKey(Solo.LEFT);
        return Result.successResult();
    }

    @Override
    public String key() {
        return "send_key_left";
    }

}
