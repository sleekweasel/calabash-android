package sh.calaba.instrumentationbackend.actions.map;

import sh.calaba.instrumentationbackend.RobotiumInstrumentationBackend;
import sh.calaba.instrumentationbackend.Result;
import sh.calaba.instrumentationbackend.actions.Action;

/**
 * Returns latitude, longitude (in decimal degrees) in the "bonusInformation"
 * 
 * @author Nicholas Albion
 */
public class GetMapCenter implements Action {

	@Override
	public Result execute(String... args) {
		double[] center = RobotiumInstrumentationBackend.solo.getMapCenter();
        Result result = new Result(true);
        result.addBonusInformation( Double.toString(center[0]) );
        result.addBonusInformation( Double.toString(center[1]) );
        return result;
	}

	@Override
	public String key() {
		return "get_map_center";
	}
}
