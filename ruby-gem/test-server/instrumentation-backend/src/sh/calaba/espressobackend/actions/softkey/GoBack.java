package sh.calaba.espressobackend.actions.softkey;


import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;


public class GoBack implements Action {

    @Override
    public Result execute(String... args) {
        EspressoInstrumentationBackend.solo.goBack();
        return Result.successResult();
    }

    @Override
    public String key() {
        return "go_back";
    }

}
