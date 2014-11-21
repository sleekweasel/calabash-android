package sh.calaba.espressobackend.actions.webview;

import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import android.webkit.WebView;

public class GetLoadProgress implements Action {

	@Override
	public Result execute(String... args) {
		CalabashChromeClient ccc = CalabashChromeClient.findAndPrepareWebViews().get(0);
		WebView webView = ccc.getWebView();
		return new Result(true, "" + webView.getProgress());
	}

	@Override
	public String key() {
		return "get_load_progress";
	}

}
