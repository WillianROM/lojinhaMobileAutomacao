package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicaoProdutoTela extends BaseTela{
    public FormularioAdicaoProdutoTela(WebDriver app) {
        super(app);
    }

    public FormularioAdicaoProdutoTela preencherNomeProduto(String produtoNome){
        this.app.findElement(By.id("com.lojinha:id/productName")).click();
        this.app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/productName")).sendKeys(produtoNome);

        return this;
    }

    public FormularioAdicaoProdutoTela preencherValorproduto(String valorProduto){
        this.app.findElement(By.id("com.lojinha:id/productValue")).click();
        this.app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/productValue")).sendKeys(valorProduto);

        return this;
    }

    public FormularioAdicaoProdutoTela preencherCoresProduto(String coresProduto){
        this.app.findElement(By.id("com.lojinha:id/productColors")).click();
        this.app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/productColors")).sendKeys(coresProduto);

        return this;
    }

    public FormularioAdicaoProdutoTela submissaoComErro(){
        this.app.findElement(By.id("com.lojinha:id/saveButton")).click();

        return this;
    }

    public String obterMensagemDeErro(){
        return capturarToast();
    }
}
