package sh.calaba.espressobackend.actions.activity;

import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

public class FinishOpenedActivities implements Action {

    @Override
    public Result execute(String... args) {
        return Result.successResult("Finish opened activities does nothing with espresso, as it internally does that between tests");
    }

    @Override
    public String key() {
        return "finish_opened_activities";
    }
}