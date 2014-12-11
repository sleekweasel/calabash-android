package sh.calaba.instrumentationbackend.actions.text;

import android.widget.EditText;

import sh.calaba.instrumentationbackend.Result;
import sh.calaba.instrumentationbackend.RobotiumInstrumentationBackend;
import sh.calaba.instrumentationbackend.actions.Action;
import sh.calaba.instrumentationbackend.query.Query;
import sh.calaba.instrumentationbackend.query.QueryResult;


public class EnterSearchForIndex implements Action {
    @Override
    public Result execute(String... args) {
        final String text = args[0];
        final String index = args[1];
        final int timeoutInMillis = 1000 * (args.length > 1 ? Integer.parseInt(args[1]) : 0);
        final long startTime = System.currentTimeMillis();
        final Query query = new Query("android.widget.SearchView index:'" + index + "'");

        QueryResult queryResult = query.executeQuery();
        while (queryResult.isEmpty()) {
            if (System.currentTimeMillis() > startTime + timeoutInMillis) {
                return Result.failedResult("SearchView with index " + index + " not found");
            }
            RobotiumInstrumentationBackend.solo.sleep(100);
            queryResult = query.executeQuery();
        }

        EditText editText = (EditText) queryResult.getResult().get(0);
        editText.performClick();

        RobotiumInstrumentationBackend.solo.sleep(500);
        return new KeyboardEnterText().execute(text);
    }

    @Override
    public String key() {
        return "enter_search_for_index";
    }
}
