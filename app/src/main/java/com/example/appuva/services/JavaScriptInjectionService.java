package com.example.appuva.services;

import android.webkit.WebView;

import androidx.annotation.NonNull;

public class JavaScriptInjectionService extends Thread {
    public void removeElement(@NonNull WebView webView) {
        webView.loadUrl("javascript:(function() {document.querySelector('div.col-sm-1:nth-child(2)').remove();})()");

        // Remove botão de reset de senha e de logout
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"button-link\"]').remove();})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"button-link\"]').remove();})()");

        // Remove o link para o Canvas, visto que no navegador mobile fica ruim de usar e uma div em branco
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"d-flex justify-content-center\"]').remove();})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"container\"]').remove();})()");

        // Desabilita o clique dos botões na div
        webView.evaluateJavascript("const buttons = document.querySelectorAll('.button-info-center');" +
                "for (let i = 0; i < buttons.length; i++) {" +
                "  buttons[i].disabled = true;" +
                "}", null);
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

        // Input de login e senha agora respeitam a cor branca, não mudando para o azul do backround
        webView.loadUrl("javascript:(function() {document.getElementById(\"LoginEntrada_login\").style.backgroundColor = \"#ffffff\";})()");
        webView.loadUrl("javascript:(function() {document.getElementById(\"LoginEntrada_senha\").style.backgroundColor = \"#ffffff\";})()");

        // Plataforma de cobrança com fundo branco
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"container body-content\"]').style.backgroundColor = \"#ffffff\";})()");
    }

    // Estética para mover o banner p/ o canto inferior
    public void beautyTools(@NonNull WebView webView) {
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"container-fluid footer-central-page\"]').style.position=\"absolute\";})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"container-fluid footer-central-page\"]').style.bottom=\"0\";})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"image-footer\"]').style.position=\"absolute\";})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"image-footer\"]').style.bottom=\"0\";})()");

        // Muda a cor da fonte de recuperar senha
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"text-muted paragraph-color\"]').style.color = \"#FFFF\";})()");

        // Muda a cor do botão de login e sua fonte
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"button-type-mobile btn-style\"]').style.background = \"#ffd000\";})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"button-type-mobile btn-style\"]').style.color = \"#014b78\";})()");
    }
}