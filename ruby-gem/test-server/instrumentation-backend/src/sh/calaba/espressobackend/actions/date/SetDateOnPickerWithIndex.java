package sh.calaba.espressobackend.actions.date;


import java.util.Date;

import org.hamcrest.Matchers;

import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import sh.calaba.espressobackend.matchers.WithIndex;
import sh.calaba.espressobackend.query.espresso.DatePickerSetter;
import android.widget.DatePicker;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;


public class SetDateOnPickerWithIndex implements Action {

    @SuppressWarnings("unchecked")
	@Override
    public Result execute(String... args) {
    	
        int expectedIndex = Integer.parseInt(args[0]);
        Date date = new Date(Date.parse(args[1]));
        
        Espresso.onView(Matchers.allOf(ViewMatchers.isAssignableFrom(DatePicker.class), 
        		new WithIndex(expectedIndex)))
        		.perform(new DatePickerSetter(date));

        return Result.successResult();
    }

    @Override
    public String key() {
        return "set_date_with_index";
    }
    
}
