package com.example.appuva;

import android.webkit.WebView;

import androidx.annotation.NonNull;

public class JavaScriptInjection extends Thread {
    // Remove o link para o Canvas, visto que no navegador mobile fica ruim de usar e uma div em branco
    public void removeElement(@NonNull WebView webView) {
        // webView.loadUrl("javascript:(function() { document.getElementById(\"notificacao_prioritarias_div\").style.display='none';})()");
        webView.loadUrl("javascript:(function() {document.querySelector('div.col-sm-1:nth-child(2)').remove();})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"d-flex justify-content-center\"]').remove();})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"container\"]').remove();})()");// container
    }

    // Aplicando um pseudo tema escuro na tela principal do portal do aluno
    public void pseudoDarkTheme(@NonNull WebView webView) {
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"container-menu-central\"]').style.backgroundColor = \"#0f3d56\";})()");
        webView.loadUrl("javascript:(function() {document.body.style.backgroundColor = \"#004b78\";})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"modal-body d-flex justify-content-start\"]').style.backgroundColor = \"#8297b5\";})()");
        webView.loadUrl("javascript:(function() {document.getElementById(\"image-logo\").src=\"/image/Logo-uva-footer.svg\";})()");
        webView.loadUrl("javascript:(function() {document.getElementById(\"menu-area2\").style.backgroundColor = \"#ebc831\";})()");
        webView.loadUrl("javascript:(function() {document.getElementById(\"styleMenuFerramentas\").style.backgroundColor = \"#ebc831\";})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"buttonCloseBg\"]').style.backgroundColor = \"#ebc831\";})()");
    }

    // Estética para mover o banner p/ o canto inferior
    public void beautyTools(@NonNull WebView webView) {
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"container-fluid footer-central-page\"]').style.position=\"absolute\";})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"container-fluid footer-central-page\"]').style.bottom=\"0\";})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"image-footer\"]').style.position=\"absolute\";})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"image-footer\"]').style.bottom=\"0\";})()");
    }
}
