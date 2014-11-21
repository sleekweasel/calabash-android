package sh.calaba.instrumentationbackend.actions.softkey;


import com.jayway.android.robotium.solo.Solo;

import sh.calaba.instrumentationbackend.RobotiumInstrumentationBackend;
import sh.calaba.instrumentationbackend.Result;
import sh.calaba.instrumentationbackend.actions.Action;


public class RightKey implements Action {

    @Override
    public Result execute(String... args) {
        RobotiumInstrumentationBackend.solo.sendKey(Solo.RIGHT);
        return Result.successResult();
    }

    @Override
    public String key() {
        return "send_key_right";
    }

}
