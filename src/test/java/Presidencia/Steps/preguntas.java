package Presidencia.Steps;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ibm.icu.text.SimpleDateFormat;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

public class preguntas {

	private WebDriver driver;

	public preguntas(WebDriver driver) {
		this.driver = driver;
	}

	// Metodo generico para dar clic a un elemento
	public void clickOnElement(WebElement element) {
		element.click();
	}

	@Step
	public void screenShot() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File dest = new File("C:\\Users\\jmedina\\Documents\\Captura\\screenshot" + filename + ".png");
		try {
			FileUtils.copyFile(scr, dest);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@Step
	public void tiempoSegundos(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Step
	public void impliciWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Step
	public void esperarElemento() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Step
	public void AsserCargaArchivoMaximo() {
		String mensaje = driver.findElement(By.xpath("//div[contains(text(),'Límite de archivos a anexar 5')]"))
				.getText();
		System.out.println(mensaje);
		Assert.assertEquals("Alerta\n" + "Límite de archivos a anexar 5", mensaje);

	}

	@Step
	public void AsserGuardarCumpliento() {

		String mensaje = driver.findElement(By.xpath("//div[@role = 'dialog']//h2")).getText();
		Assert.assertEquals("¿Está seguro que desea registrar esta información para el periodo de cumplimiento?",
				mensaje);

	}

	@Step
	public void AsserSeguroContinuar() {

		String mensaje = driver.findElement(By.xpath("//div[@id = 'alert-dialog-title']//h2")).getText();
		Assert.assertEquals("¿Está seguro que desea continuar?", mensaje);

	}

	@Step
	public void AsserContinuarPiramide() {

		String mensaje = driver.findElement(By.xpath("//div[@id = 'alert-dialog-title']//h2")).getText();
		Assert.assertEquals("¿Está seguro que desea registrar estas denominaciones para la pirámide de cumplimiento?",
				mensaje);

	}

	@Step
	public void AsserEvaluacionRiesgos() {

		String mensaje = driver.findElement(By.xpath("//div[@id = 'alert-dialog-title']//h2")).getText();
		Assert.assertEquals("¿Está seguro que desea dejar estos elementos configurados para este periodo?", mensaje);

	}
}