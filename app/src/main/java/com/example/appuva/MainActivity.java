package com.example.appuva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Modifica o título da top bar
        getSupportActionBar().setTitle("Aplicativo Faculdade");

        // Mostra a progress bar enquanto a página carrega
        final ProgressBar progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);

        // Abre a página e extende para que se mantenha na WebView
        WebView webView = findViewById(R.id.webview);
        webView.loadUrl("https://portalaluno.uva.br/LoginMobile");
        webView.getSettings().setJavaScriptEnabled(true);

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
                super.onPageFinished(view, url);
                removeElement(view);
                progressBar.setVisibility(View.INVISIBLE);
            }

            // Caso o usuário esteja offline, indica que é preciso ter uma conexão de internet ativa
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                webView.loadUrl("about:blank");
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

    // Remove o link para o Canvas, visto que no navegador mobile fica ruim de usar
    public static void removeElement(@NonNull WebView webView) {
        webView.loadUrl("javascript:(function() { document.querySelector('[title=\"Plataforma Virtual - CANVAS\"]').style.display='none';})()");
    }
}