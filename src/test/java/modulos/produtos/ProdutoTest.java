package modulos.produtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@DisplayName("Testes Mobile do Módulo de Produto")
public class ProdutoTest {
    @DisplayName("Validação do Valor de Produto Não Permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido() throws MalformedURLException {
        // Abrir o App
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName","Google Pixel 3");
        capacidades.setCapability("platform","Android");
        capacidades.setCapability("udid","192.168.56.104:5555"); //digite no prompt de comando: adb devices
        capacidades.setCapability("appPackage","com.lojinha");//No emulador, abra a lojimha, no prompt de comando digite adb shell dumpsys window | grep -i "mCurrentFocus"
        capacidades.setCapability("appActivity","com.lojinha.ui.MainActivity"); //No emulador, abra a lojimha, no prompt de comando digite adb shell dumpsys window | grep -i "mCurrentFocus"
        capacidades.setCapability("app", "C:\\Android\\Lojinha Android Nativa\\lojinha-nativa.apk");

        WebDriver app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades); // Ver dados no Appium

        // Fazer Login

        // Abrir o formulário de novo produto

        // Cadastrar um produto com valor inválido

        // Validar que a mensagem de valor inválido foi apresentada
    }
}
