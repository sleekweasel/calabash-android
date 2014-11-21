package sh.calaba.espressobackend.actions.webview;

import sh.calaba.espressobackend.Result;
import sh.calaba.espressobackend.actions.Action;
import android.webkit.WebView;
import sh.calaba.espressobackend.query.ast.UIQueryUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class GetUrl implements Action {

	@Override
	public Result execute(String... args) {
		CalabashChromeClient ccc = CalabashChromeClient.findAndPrepareWebViews().get(0);
		final WebView webView = ccc.getWebView();

        FutureTask<Result> urlResult = new FutureTask<Result>(new Callable<Result>() {
            @Override
            public Result call() throws Exception {
                return new Result(true, webView.getUrl());
            }
        });

        UIQueryUtils.runOnViewThread(webView, urlResult);

        try {
            return urlResult.get();
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

	@Override
	public String key() {
		return "get_url";
	}

}
