package modulos.produtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import telas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Módulo de Produto")
public class ProdutoTest {

    private WebDriver app;
    @BeforeEach
    public void beforeEach() throws MalformedURLException{
        // Abrir o App
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName","Google Pixel 3");
        capacidades.setCapability("platform","Android");
        capacidades.setCapability("udid","192.168.56.104:5555"); //digite no prompt de comando: adb devices
        capacidades.setCapability("appPackage","com.lojinha");//No emulador, abra a lojimha, no prompt de comando digite adb shell dumpsys window | grep -i "mCurrentFocus"
        capacidades.setCapability("appActivity","com.lojinha.ui.MainActivity"); //No emulador, abra a lojimha, no prompt de comando digite adb shell dumpsys window | grep -i "mCurrentFocus"
        capacidades.setCapability("app", "C:\\Android\\Lojinha Android Nativa\\lojinha-nativa.apk");

        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades); // Ver dados no Appium
        this.app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @DisplayName("Validação do Valor de Produto Não Permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido()  {

        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirTelaAdicaoProduto()
                .preencherNomeProduto("Computador")
                .preencherValorproduto("000")
                .preencherCoresProduto("prata, preto")
                .submissaoComErro()
                .obterMensagemDeErro();

        // Validar que a mensagem de valor inválido foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @AfterEach
    public void afterEach(){
        this.app.quit();
    }
}
