package com.example.appuva;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appuva.services.JavaScriptInjectionService;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Modifica o título da top bar
        setTitle("AppUni");

        // Mostra a progress bar enquanto a página carrega
        final ProgressBar progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);

        // Abre a página e extende para que se mantenha na WebView
        webView = findViewById(R.id.webview);

        // Habilita Renderização via Hardware
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        // Habilita cache da página para melhor performance
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        webView.loadUrl("https://portalaluno.uva.br/LoginMobile");
        webView.getSettings().setJavaScriptEnabled(true);

        // Usa o Chrome para deixar usar window.alert
        webView.setWebChromeClient(new WebChromeClient());

        progressBar.setVisibility(View.INVISIBLE);

        // Durante o carregamento da página, a progressbar é vista para dar um feedback de loading
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            // E após carregar, ela é escondida
            @Override
            public void onPageFinished(WebView view, String url) {

                // Classe com injeção do JS para estética usando Thread do Java
                JavaScriptInjectionService javaScriptInjectionService = new JavaScriptInjectionService();

                javaScriptInjectionService.start();

                javaScriptInjectionService.pseudoDarkTheme(view);
                javaScriptInjectionService.beautyTools(view);
                javaScriptInjectionService.removeElement(view);
                javaScriptInjectionService.carterinhaAluno(view);

                progressBar.setVisibility(View.INVISIBLE);
            }

            // Caso o usuário esteja offline, indica que é preciso ter uma conexão de internet ativa
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                webView.loadUrl("about:blank"); // Evitar de renderizar página de sem rede genérica do android
                Intent errorIntent = new Intent(getApplicationContext(), ErrorActivity.class);
                startActivity(errorIntent);
                Toast.makeText(MainActivity.this, "Error de conexão. É necessário estar conectado a internet para usar este aplicativo!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Caso seja possível retornar a página anterior, o botão de retornar terá essa ação
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}