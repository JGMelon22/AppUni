package com.example.appuva.services;

import android.webkit.WebView;

import androidx.annotation.NonNull;

public class JavaScriptInjectionService {
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
