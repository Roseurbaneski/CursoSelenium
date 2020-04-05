import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

import junit.framework.Assert;

public class CursoCadastro {
	@Test
	public void Cadastro() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(900, 765));
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		
		//preencher o campo nome e sobrenome
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Rosilei");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Urbaneski");
		
		//clica no sexo
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		
		//clica nas comida favorita
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		
		//escolher a escolariedade
		WebElement escoleriedade = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(escoleriedade);
		combo.selectByVisibleText("Mestrado");
		
		//escolher esporte
		WebElement esportes = driver.findElement(By.id("elementosForm:esportes"));
		Select comboesporte = new Select(esportes);
		comboesporte.selectByVisibleText("Natacao");
		comboesporte.selectByVisibleText("Corrida");
		
		//Gravar Cadastro
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		//checar cadastro

		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));//verifica o inciio do bloco
		Assert.assertEquals("Nome: Rosilei", driver.findElement(By.id("descNome")).getText());
		//ou poder ser checado o final do testo
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Rosilei"));
		Assert.assertEquals("Sobrenome: Urbaneski",driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Feminino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao Corrida", driver.findElement(By.id("descEsportes")).getText());
		driver.quit();
		
	}
}
