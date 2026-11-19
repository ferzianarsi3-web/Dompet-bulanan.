package id.dompetbulanan.app;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.ValueCallback;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity {
  private WebView web;
  private ValueCallback<Uri[]> uploadCallback;
  private static final int FILE_CHOOSER = 1001;
  @Override public void onCreate(Bundle b) {
    super.onCreate(b);
    web = new WebView(this);
    WebSettings s = web.getSettings();
    s.setJavaScriptEnabled(true);
    s.setDomStorageEnabled(true);
    s.setAllowFileAccess(true);
    web.setWebViewClient(new WebViewClient());
    web.setWebChromeClient(new WebChromeClient() {
      @Override public boolean onShowFileChooser(WebView v, ValueCallback<Uri[]> cb, FileChooserParams params) {
        uploadCallback = cb;
        Intent i = params.createIntent();
        try { startActivityForResult(i, FILE_CHOOSER); } catch(Exception e) { uploadCallback=null; return false; }
        return true;
      }
    });
    setContentView(web);
    web.loadUrl("file:///android_asset/index.html");
  }
  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode,resultCode,data);
    if(requestCode==FILE_CHOOSER && uploadCallback!=null) {
      Uri[] result = WebChromeClient.FileChooserParams.parseResult(resultCode,data);
      uploadCallback.onReceiveValue(result); uploadCallback=null;
    }
  }
  @Override public void onBackPressed() {
    if(web!=null && web.canGoBack()) web.goBack(); else super.onBackPressed();
  }
}
