package modulos.produtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
        app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Fazer Login
        app.findElement(By.id("com.lojinha:id/user")).click();
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys("admin");

        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys("admin");

        app.findElement(By.id("com.lojinha:id/loginButton")).click();

        // Abrir o formulário de novo produto
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();

        // Cadastrar um produto com valor inválido
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/productName")).sendKeys("Computador");

        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/productValue")).sendKeys("000");

        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/productColors")).sendKeys("prata, preto");

        app.findElement(By.id("com.lojinha:id/saveButton")).click();

        // Validar que a mensagem de valor inválido foi apresentada
        String mensagemApresentada = app.findElement(By.xpath("//android.widget.Toast")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }
}
