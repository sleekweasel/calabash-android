package sh.calaba.espressobackend.actions.webview;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import sh.calaba.espressobackend.actions.webview.CalabashChromeClient.WebFuture;
import sh.calaba.espressobackend.query.ast.UIQueryUtils;
import android.webkit.WebView;

@Deprecated
public class DumpBodyHtml implements Action {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public Result execute(String... args) {
    	                             	
    	List<WebFuture> webResults = (List<WebFuture>) UIQueryUtils.evaluateSyncInMainThread(new Callable() {			
			public Object call() throws Exception {
				
				List<WebFuture> webResults = new ArrayList();
				for (CalabashChromeClient ccc : CalabashChromeClient.findAndPrepareWebViews()) {
		    		WebView webView = ccc.getWebView();
		            webView.loadUrl("javascript:(function() {" +
		                    "prompt('calabash:' + document.body.innerHTML);" +
		                    "})()");
		            webResults.add(ccc.getResult());		            
		        }
				return webResults;
				
			}
		});
    	
    	List<String> allResults = new ArrayList<String>(webResults.size());
    	for (WebFuture f : webResults) {
    		allResults.add(f.getAsString());			    		
    	}
    		
    	if (allResults.size() == 0) {
    		return new Result(false, "No WebView found");	
    	}
    	else {
    		return new Result(true, allResults);
    	}    	
        
    }
    public String key() {
        return "dump_body_html";
    }
}
