package sh.calaba.espressobackend.actions.helpers;


import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;


public class ListActions implements Action {

    @Override
    public Result execute(String... args) {
        Result result = new Result(true, "Available actions");
        for(String key: EspressoInstrumentationBackend.actions.getActions().keySet()) {
            result.addBonusInformation(key);
        }
        
        return result;
    }

    @Override
    public String key() {
        return "list_actions";
    }

}
