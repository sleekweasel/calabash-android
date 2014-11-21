package sh.calaba.espressobackend.actions.gestures;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;

import com.jayway.android.robotium.solo.Solo;

public class Swipe implements Action {

    @Override
    public Result execute(String... args) {
        String direction = args[0];

        if (args.length == 1) {
            if(direction.equalsIgnoreCase("left")) {
                EspressoInstrumentationBackend.solo.scrollToSide(Solo.LEFT);
                return Result.successResult();
            } else if(direction.equalsIgnoreCase("right")) {
                EspressoInstrumentationBackend.solo.scrollToSide(Solo.RIGHT);
                return Result.successResult();
            }
            return Result.failedResult("Invalid direction to swipe: " + direction);
        }
        return Result.failedResult("You must provide a direction. Either 'left' or 'right'");
    }

    @Override
    public String key() {
        return "swipe";
    }

}
