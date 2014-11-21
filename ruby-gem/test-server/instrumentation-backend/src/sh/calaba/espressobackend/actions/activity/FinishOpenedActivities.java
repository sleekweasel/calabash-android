package sh.calaba.espressobackend.actions.activity;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

public class FinishOpenedActivities implements Action {

    @Override
    public Result execute(String... args) {
        EspressoInstrumentationBackend.solo.finishOpenedActivities();
        return Result.successResult();
    }

    @Override
    public String key() {
        return "finish_opened_activities";
    }
}