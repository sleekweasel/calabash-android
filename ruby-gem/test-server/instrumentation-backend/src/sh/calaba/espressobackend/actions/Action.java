package sh.calaba.espressobackend.actions;

import sh.calaba.espressobackend.Result;


public interface Action {

	Result execute(String... args);
	
	String key();
}
