package sh.calaba.instrumentationbackend.actions.activity;

import sh.calaba.instrumentationbackend.RobotiumInstrumentationBackend;
import sh.calaba.instrumentationbackend.Result;
import sh.calaba.instrumentationbackend.actions.Action;

public class FinishOpenedActivities implements Action {

    @Override
    public Result execute(String... args) {
        RobotiumInstrumentationBackend.solo.finishOpenedActivities();
        return Result.successResult();
    }

    @Override
    public String key() {
        return "finish_opened_activities";
    }
}