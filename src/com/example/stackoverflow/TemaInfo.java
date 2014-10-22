package com.example.stackoverflow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class TemaInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tema_info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tema_info, menu);
		return true;
	}
	
	public void info2 (View v){
		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.loadUrl("http://www.google.com");
		 
    }
}
