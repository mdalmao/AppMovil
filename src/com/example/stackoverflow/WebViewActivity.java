package com.example.stackoverflow;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity {

	private WebView webView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);

		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		//webView.loadUrl("http://www.google.com");

		String customHtml = "<html><body><h1>Ayuda Via Web</h1> Integrantes:";
		customHtml+= "<BR> Karina Lanata";
		customHtml+= "<BR> Vanessa Cáseres";
		customHtml+= "<BR> Marcelo Dalmao";
		customHtml+= "<BR>";
		customHtml+= "<h2> Ayuda </h2>";
		customHtml+= "<BR> Nuevo Tema: Para crear una consulta damos en el botón + y completamos los campos. Luego los usuarios del sistema podrán proponer respuestas a tu tema. ";
		customHtml+="<BR> Busqueda: Se prodra buscar un Tema por nombre de usuario, palabra clave o fecha.";
		customHtml+= " </body></html>";
		webView.loadData(customHtml, "text/html", "UTF-8");

	}

}