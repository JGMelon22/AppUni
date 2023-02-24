package com.example.appuva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

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
        });
    }

    // Remove o link para o Canvas, visto que no navegador mobile fica ruim de usar
    public static void removeElement(@NonNull WebView webView) {
        webView.loadUrl("javascript:(function() { document.querySelector('[title=\"Plataforma Virtual - CANVAS\"]').style.display='none';})()");
    }
}