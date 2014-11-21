package sh.calaba.instrumentationbackend.actions.softkey;


import sh.calaba.instrumentationbackend.RobotiumInstrumentationBackend;
import sh.calaba.instrumentationbackend.Result;
import sh.calaba.instrumentationbackend.actions.Action;


public class GoBack implements Action {

    @Override
    public Result execute(String... args) {
        RobotiumInstrumentationBackend.solo.goBack();
        return Result.successResult();
    }

    @Override
    public String key() {
        return "go_back";
    }

}
