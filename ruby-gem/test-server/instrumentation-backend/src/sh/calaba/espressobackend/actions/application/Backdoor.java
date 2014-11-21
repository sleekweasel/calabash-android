package sh.calaba.espressobackend.actions.application;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import sh.calaba.espressobackend.EspressoInstrumentationBackend;
import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import sh.calaba.espressobackend.query.Operation;
import sh.calaba.espressobackend.query.InvocationOperation;
import sh.calaba.espressobackend.query.QueryResult;
import sh.calaba.espressobackend.query.UIQueryResultVoid;


public class Backdoor implements Action {

	private static final String TAG = "Backdoor";

	@Override
	public Result execute(String... args) {
		if (args.length != 2) {
			return Result.failedResult("You must provide method name and an argument.");
		}

		String methodName = args[0];
		List arguments = new ArrayList(1);
		arguments.add(args[1]);
		// create invocation operation to call method
		Operation op = new InvocationOperation(methodName, arguments);
		// get an application object to call operation on
		Context app = EspressoInstrumentationBackend.solo.getCurrentActivity().getApplication();
		String backdoorResult = null;
		try {
			backdoorResult = (String)op.apply(app);
		} catch (Exception e) {
			android.util.Log.e(TAG, android.util.Log.getStackTraceString(e));
			return Result.failedResult("No such backdoor method found: public String " + op.getName() + "(String arg)");
		}

		// set backdoor result as bonus
		Result result = Result.successResult();
		result.addBonusInformation(backdoorResult);
		return result;
	}

	@Override
	public String key() {
		return "backdoor";
	}

}
