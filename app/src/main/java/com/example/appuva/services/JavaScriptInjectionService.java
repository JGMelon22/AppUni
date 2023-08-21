package com.example.appuva.services;

import android.webkit.WebView;

import androidx.annotation.NonNull;

public class JavaScriptInjectionService extends Thread {
    public void removeElement(@NonNull WebView webView) {
        String removeDiversidadeHumana = "document.querySelector('div.col-sm-1:nth-child(3)').remove();";
        String removeCanvas = "document.querySelector('div.col-sm-1:nth-child(2)').remove();";
        String removeReseteSenha = "document.querySelector('[class=\"button-link\"]').remove();";
        String removeLogout = "document.querySelector('[class=\"d-flex justify-content-center\"]').remove();";
        String removeContainer = "document.querySelector('[class=\"container\"]').remove();";
        String disableButtons = "const buttons = document.querySelectorAll('.button-info-center');" +
                "for (let i = 0; i < buttons.length; i++) {" +
                "  buttons[i].disabled = true;" +
                "}";

        webView.loadUrl("javascript:" + removeDiversidadeHumana);
        webView.loadUrl("javascript:" + removeCanvas);
        webView.loadUrl("javascript:" + removeReseteSenha);
        webView.loadUrl("javascript:" + removeLogout);
        webView.loadUrl("javascript:" + removeContainer);
        webView.evaluateJavascript(disableButtons, null);
    }

    // Aplicando um pseudo tema escuro na tela principal do portal do aluno
    public void pseudoDarkTheme(@NonNull WebView webView) {
        String setContainerMenuColor = "document.querySelector('[class=\"container-menu-central\"]').style.backgroundColor = \"#0f3d56\";";
        String setBodyBackgroundColor = "document.body.style.backgroundColor = \"#004b78\";";
        String setModalBackgroundColor = "document.querySelector('[class=\"modal-body d-flex justify-content-start\"]').style.backgroundColor = \"#8297b5\";";
        String changeImageLogo = "document.getElementById(\"image-logo\").src=\"/image/Logo-uva-footer.svg\";";
        String setMenuArea2Color = "document.getElementById(\"menu-area2\").style.backgroundColor = \"#ebc831\";";
        String setStyleMenuFerramentasColor = "document.getElementById(\"styleMenuFerramentas\").style.backgroundColor = \"#ebc831\";";
        String setButtonCloseBgColor = "document.querySelector('[class=\"buttonCloseBg\"]').style.backgroundColor = \"#ebc831\";";
        String setInputLoginBgColor = "document.getElementById(\"LoginEntrada_login\").style.backgroundColor = \"#ffffff\";";
        String setInputSenhaBgColor = "document.getElementById(\"LoginEntrada_senha\").style.backgroundColor = \"#ffffff\";";
        String setPlataformaCobrancaBgColor = "document.querySelector('[class=\"container body-content\"]').style.backgroundColor = \"#ffffff\";";

        webView.loadUrl("javascript:" + setContainerMenuColor);
        webView.loadUrl("javascript:" + setBodyBackgroundColor);
        webView.loadUrl("javascript:" + setModalBackgroundColor);
        webView.loadUrl("javascript:" + changeImageLogo);
        webView.loadUrl("javascript:" + setMenuArea2Color);
        webView.loadUrl("javascript:" + setStyleMenuFerramentasColor);
        webView.loadUrl("javascript:" + setButtonCloseBgColor);
        webView.loadUrl("javascript:" + setInputLoginBgColor);
        webView.loadUrl("javascript:" + setInputSenhaBgColor);
        webView.loadUrl("javascript:" + setPlataformaCobrancaBgColor);
    }

    // Estética para mover o banner p/ o canto inferior
    public void beautyTools(@NonNull WebView webView) {
        String setFooterPosition = "document.querySelector('[class=\"container-fluid footer-central-page\"]').style.position = \"absolute\";";
        String setFooterBottom = "document.querySelector('[class=\"container-fluid footer-central-page\"]').style.bottom = \"0\";";
        String setImageFooterPosition = "document.querySelector('[class=\"image-footer\"]').style.position = \"absolute\";";
        String setImageFooterBottom = "document.querySelector('[class=\"image-footer\"]').style.bottom = \"0\";";
        String changeRecuperarSenhaFontColor = "document.querySelector('[class=\"text-muted paragraph-color\"]').style.color = \"#FFFF\";";
        String setLoginButtonBackground = "document.querySelector('[class=\"button-type-mobile btn-style\"]').style.background = \"#ffd000\";";
        String setLoginButtonFontColor = "document.querySelector('[class=\"button-type-mobile btn-style\"]').style.color = \"#014b78\";";
        String setResetButtonBackground = "document.querySelector('[class=\"style-inputs color-btn\"]').style.background = \"#ffd000\";";
        String setResetButtonFontColor = "document.querySelector('[class=\"style-inputs color-btn\"]').style.color = \"#014b78\";";

        webView.loadUrl("javascript:" + setFooterPosition);
        webView.loadUrl("javascript:" + setFooterBottom);
        webView.loadUrl("javascript:" + setImageFooterPosition);
        webView.loadUrl("javascript:" + setImageFooterBottom);
        webView.loadUrl("javascript:" + changeRecuperarSenhaFontColor);
        webView.loadUrl("javascript:" + setLoginButtonBackground);
        webView.loadUrl("javascript:" + setLoginButtonFontColor);
        webView.loadUrl("javascript:" + setResetButtonBackground);
        webView.loadUrl("javascript:" + setResetButtonFontColor);
    }

    public void carterinhaAluno(@NonNull WebView webView) {
        String avisoCarterinha = "function avisoCarterinha() { window.alert(\"Considere tirar um print da carterinha!\"); }";
        String cliqueCarterinha = "document.getElementById(\"btn_acionar_carterinha\").addEventListener(\"click\", avisoCarterinha);";

        webView.loadUrl("javascript:" + avisoCarterinha);
        webView.loadUrl("javascript:" + cliqueCarterinha);
    }
}