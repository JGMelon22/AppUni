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

    // Injeção JS para evitar página da carteira do estudante (pois carrega errado)
    public void injectJavaScript(@NonNull WebView webView, @NonNull String script) {
        webView.evaluateJavascript(script, null);
    }

    // Ijetando o código na WebView para avisar ao usuário da limitação do sistema
    public void customizeWebView(@NonNull WebView webView) {
        String script = "let element = document.querySelector('[title=\"Carteira de Estudante\"]');" +
                "element.onclick = function() {" +
                "  event.preventDefault();" +
                "  window.alert(\"Funcionalidade impossibilitada no App open source :(\");" +
                "}";
        injectJavaScript(webView, script);
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
    }
}
