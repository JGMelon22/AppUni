package com.example.appuva.services;

import android.webkit.WebView;

import androidx.annotation.NonNull;

public class JavaScriptInjectionService {

    public void removeElement(@NonNull WebView webView) {
        // Remove diversidade humana e canvas
        webView.loadUrl("javascript:(function() {document.querySelector('div.col-sm-1:nth-child(3)').remove()})()");
        webView.loadUrl("javascript:(function() {document.querySelector('div.col-sm-1:nth-child(2)').remove()})()");

        // Remove botão de reset de senha e de logout
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"profile-container-button\"]').remove()})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"profile-container-button\"]').remove()})()");

        // Remove os botões de logout e reset de senha na aba de perfil
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"d-flex justify-content-center profile-container-section\"]').remove()})()");

        // Desabilita o clique dos botões na div
        webView.evaluateJavascript("const buttons = document.querySelectorAll('.button-info-center');" +
                "for (let i = 0; i < buttons.length; i++) {" +
                "   buttons[i].disabled = true;" +
                "}", null);
    }

    // Aplicando um pseudo tema escuro na tela principal do portal do aluno
    public void pseudoDarkTheme(@NonNull WebView webView) {
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"container-menu-central\"]').style.backgroundColor = \"#0f3d56\"})()");
        webView.loadUrl("javascript:(function() {document.body.style.backgroundColor = \"#004b78\"})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"modal-body d-flex justify-content-start\"]').style.backgroundColor = \"#8297b5\"})()");
        webView.loadUrl("javascript:(function() {document.getElementById(\"image-logo\").src=\"/image/uva/desktop/logo_footer.svg\"})()"); // Logo superior igual a inferior (fonte em branco)
        webView.loadUrl("javascript:(function() {document.getElementById(\"menu-area2\").style.backgroundColor = \"#ebc831\"})()");
        webView.loadUrl("javascript:(function() {document.getElementById(\"styleMenuFerramentas\").style.backgroundColor = \"#ebc831\"})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"buttonCloseBg\"]').style.backgroundColor = \"#ebc831\"})()");

        // Input de login e senha agora respeitam a cor branca, não mudando para o azul do backround
        webView.loadUrl("javascript:(function() {document.getElementById(\"LoginEntrada_login\").style.backgroundColor = \"#ffffff\"})()");
        webView.loadUrl("javascript:(function() {document.getElementById('LoginEntrada_login').style.color = '#000000';})()");

        webView.loadUrl("-javascript:(function() {document.getElementById(\"LoginEntrada_senha\").style.backgroundColor = \"#ffffff\"})()");
        webView.loadUrl("javascript:(function() {document.getElementById('LoginEntrada_senha').style.color = '#000000';})()");

        // Input de login e data nascimento na tela de recuperação de senha com fundo branco
        webView.loadUrl("javascript:(function() { " +
                "var elements = document.getElementsByName('cpf'); " +
                "for (var i = 0; i < elements.length; i++) { " +
                "    elements[i].style.backgroundColor = '#ffffff'; " +
                "    elements[i].style.color = '#000000'; " +
                "} " +
                "})()");

        webView.loadUrl("javascript:(function() { " +
                "var elements = document.getElementsByName('dtNascimento'); " +
                "for (var i = 0; i < elements.length; i++) { " +
                "    elements[i].style.backgroundColor = '#ffffff'; " +
                "    elements[i].style.color = '#000000'; " +
                "} " +
                "})()");

        // Plataforma de cobrança com fundo branco
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"container body-content\"]').style.backgroundColor = \"#ffffff\"})()");
    }

    // Estética para mover o banner p/ o canto inferior
    public void beautyTools(@NonNull WebView webView) {

        // Muda a cor da fonte de recuperar senha
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"paragraph-color\"]').style.color = \"#FFFF\"})()");

        // Muda a logo da tela de login
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"header\"]').outerHTML = '<img src=\"https://i.imgur.com/SzxKhmN.jpeg\" alt=\"Image\" style=\"height: auto;\">'})()"); // Funcional

        // Muda a cor do botão de login e sua fonte
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"button-type-mobile btn-style\"]').style.background = \"#ffd000\"})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"button-type-mobile btn-style\"]').style.color = \"#014b78\"})()");

        // Muda a cor do botão de reset de senha e sua fonte
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"style-inputs color-btn\"]').style.background = \"#ffd000\"})()");
        webView.loadUrl("javascript:(function() {document.querySelector('[class=\"style-inputs color-btn\"]').style.color = \"#014b78\"})()");
    }

    // Avisa ao usuário para considerar em bater um print da carteirinha do aluno
    public void carterinhaAluno(@NonNull WebView webView) {
        String avisoCarterinha = "function avisoCarterinha() { window.alert('Considere tirar um print da carterinha!'); }";
        String cliqueCarterinha = "var button = document.getElementById('btn_acionar_carterinha').querySelector('button');" +
                "if (button) {" +
                "   button.addEventListener('click', function() { avisoCarterinha(); chamarCarterinha(); });" +
                "}";

        webView.loadUrl("javascript:" + avisoCarterinha);
        webView.loadUrl("javascript:" + cliqueCarterinha);
    }

}