package sh.calaba.espressobackend.actions.webview;


import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.TestHelpers;
import sh.calaba.espressobackend.actions.Action;
import sh.calaba.espressobackend.idleResource.WebViewIdleResource;
import sh.calaba.espressobackend.query.espresso.ViewCaptor;
import android.webkit.WebView;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;


public class RegisterWebViewAsIdleResource implements Action {

    @Override
    public Result execute(String... args) {
    	final ViewCaptor viewCaptor = new ViewCaptor();
    	final String webViewId = args[0];

		int resourceId = TestHelpers.getIdFromString(webViewId);
		
		Espresso.onView(ViewMatchers.withId(resourceId)).perform(viewCaptor);
		Espresso.registerIdlingResources(new WebViewIdleResource((WebView) viewCaptor.getCapturedView()));
    	
        return Result.successResult();
    }

    @Override
    public String key() {
        return "register_webview_as_idle_resource";
    }
    
}
