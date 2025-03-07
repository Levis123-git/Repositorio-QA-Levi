package Testes;



import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import Metodos.MetodosDeTeste;
import Pages.LoginPage;
import Runner.Executa;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

public class LoginTest {

	MetodosDeTeste metodo = new MetodosDeTeste();
	LoginPage logar = new LoginPage();

	@Test
	@BindingPriority(1)
	public void loginSucessoTest() {
		Executa.antesDosTestes();
		logar.logar("teste@tra.com", "Rota@2025");
		metodo.esperarUrl("https://stg-new.rota361.com.br/plataforma/dashboard", 3);
		metodo.validarUrl("https://stg-new.rota361.com.br/plataforma/dashboard");
		Executa.depoisDosTestes();

	}

	@Test
	@BindingPriority(2)
	public void loginUsuarioInvalido() {
		Executa.antesDosTestes();
		logar.logar("inválido@email.com", "Rota@2025");
		metodo.esperarElementoSerVisivel(By.xpath("//div[@class='q-notification__message col']"), 3);
		metodo.pegarTextoNaClass(By.xpath("//div[@class='q-notification__message col']"),"Usuário e/ou senha incorretos.");
		metodo.capturarScreenshot();
		Executa.depoisDosTestes();
	}

	@Test
	@BindingPriority(3)
	public void loginSenhaInvalida() {
		Executa.antesDosTestes();
		logar.logar("teste@tra.com", "inválido");
		metodo.esperarElementoSerVisivel(By.xpath("//div[@class='q-notification__message col']"), 3);
		metodo.pegarTextoNaClass(By.xpath("//div[@class='q-notification__message col']"),"Usuário e/ou senha incorretos.");
		metodo.capturarScreenshot();
		Executa.depoisDosTestes();
	}

	@Test
	@BindingPriority(4)
	public void loginCamposEmBranco() {
		Executa.antesDosTestes();
		logar.logar("", "");
		metodo.esperarElementoSerVisivel(By.xpath("//div[@role='alert']"), 3);
		metodo.pegarTextoNoElemento(By.xpath("//div[@role='alert']"), "Campo obrigatório");
		metodo.capturarScreenshot();
		Executa.depoisDosTestes();
	}
	@Test
	@BindingPriority(5)
	public void logoutSucesso() {
		Executa.antesDosTestes();
		logar.logar("mateus@teste.com", "sponton3825.");
		metodo.esperarUrl("https://stg-new.rota361.com.br/plataforma/dashboard", 3);
		metodo.clicar(By.xpath("//div[@class='q-avatar__content row flex-center overflow-hidden']"));
		metodo.clicar(By.xpath("//div[text()='Sair']"));
		metodo.validarUrl("https://stg-new.rota361.com.br/login");
		Executa.depoisDosTestes();

	}

}
