package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTela extends BaseTela {

    public LoginTela(WebDriver app) {
        super(app);
    }

    public LoginTela preencherUsuario(String usuario){
        this.app.findElement(By.id("com.lojinha:id/user")).click();
        this.app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys(usuario);

        return this;
    }

    public LoginTela preencherSenha(String senha){
        this.app.findElement(By.id("com.lojinha:id/password")).click();
        this.app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys(senha);

        return this;
    }

    public ListagemDeProdutosTela submeterLogin(){
        this.app.findElement(By.id("com.lojinha:id/loginButton")).click();

        return new ListagemDeProdutosTela(this.app);
    }
}
