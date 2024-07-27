package com.example.appuva.services;

import android.webkit.WebView;
import androidx.annotation.NonNull;

public class JavaScriptInjectionService {

    public void applyCustomStyle(@NonNull WebView webView) {
        // Body em azul
        webView.loadUrl(
            "javascript:(function() {document.body.style.background = '#004B78'})()"
        );

        // Muda a logo da tela de login
        webView.loadUrl(
            "javascript:(function() {document.querySelector('.header').outerHTML = '<img src=\"https://i.imgur.com/SzxKhmN.jpeg\" alt=\"Image\" style=\"height: auto;\">'})()"
        );

        // Tag em branco referente ao "Esqueci a senha"
        webView.loadUrl(
            "javascript:(function() {document.querySelector('a[href=\"/EsqueciSenhaMobile\"]').style.color = 'White'})()"
        );

        // Texto de recuperação de senha em branco
        webView.loadUrl(
                "javascript:(function() {Array.from(document.querySelectorAll('h1')).find(h1 => h1.textContent.trim() === 'Recuperação de Senha')?.style.setProperty('color', 'white');})()"
        );

        // Botão de entrar e recuperar em amarelo
        webView.loadUrl(
            "javascript:(function() {document.querySelector('button.button-type-mobile.btn-style').style.background = '#FFD000'})()"
        );

        // Logo superior identica a inferior
        webView.loadUrl(
            "javascript:(function() {document.getElementById('image-logo').src='/image/uva/desktop/logo_footer.svg'})()"
        );
    }

    public void removeElements(@NonNull WebView webView) {
        // Remove diversidade humana
        webView.loadUrl(
            "javascript:(function() {document.querySelectorAll('a[title = \"Diversidade Humana\"]')[0].parentElement.parentElement.parentElement.remove()})()"
        );

        // Remove acessol ao CANVAS
        webView.loadUrl(
            "javascript:(function() {document.querySelectorAll('a[title = \"Plataforma Virtual - CANVAS\"]')[0].parentElement.parentElement.parentElement.remove()})()"
        );

        // Remove botão de reset de senha do perfil do usuário
        webView.loadUrl(
            "javascript:(function() {" +
            "  var buttonRemovePassword = Array.from(document.querySelectorAll('.profile-container-button'))" +
            "    .find(buttonRemovePassword => buttonRemovePassword.textContent.trim() === 'Alterar senha');" +
            "  if (buttonRemovePassword) {" +
            "    buttonRemovePassword.remove();" +
            "  }" +
            "})()"
        );

        // Remove botão de logout do perfil do usuário
        webView.loadUrl(
            "javascript:(function() {" +
            "  var buttonRemovePassword = Array.from(document.querySelectorAll('.profile-container-button'))" +
            "    .find(buttonRemovePassword => buttonRemovePassword.textContent.trim() === 'Sair do portal');" +
            "  if (buttonRemovePassword) {" +
            "    buttonRemovePassword.remove();" +
            "  }" +
            "})()"
        );

        // Desabilita o clique dos botões na div
        webView.evaluateJavascript(
            "const buttons = document.querySelectorAll('.button-info-center');" +
            "for (let i = 0; i < buttons.length; i++) {" +
            "   buttons[i].disabled = true;" +
            "}",
            null
        );
    }
}
