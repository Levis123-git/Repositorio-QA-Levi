package Testes;

import Pages.PPRPage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import Metodos.MetodosDeTeste;
import Pages.LoginPage;
import Runner.Executa;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudPPRTest {

	LoginPage login = new LoginPage();
	PPRPage ppr = new PPRPage();
	MetodosDeTeste metodo = new MetodosDeTeste();

	@Test
	@Order(1)
	public void cadastroPPRSucesso() {
		Executa.antesDosTestes();
		login.logar("teste@tra.com", "Rota@2025");
		ppr.cadastrarPPR("PPR teste", "-23.499727839835238", "-46.845637285819656");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		metodo.pegarTextoNaClass(By.xpath("//div[@class='q-notification__message col']"), "Item cadastrado");
		metodo.capturarScreenshot();
		Executa.depoisDosTestes();

	}

	@Test
	@Order(5)
	public void cadastroPPRInválido() {
		Executa.antesDosTestes();
		login.logar("teste@tra.com", "Rota@2025");
		ppr.cadastrarPPR("PPR teste", "000", "000");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		metodo.pegarTextoNaClass(By.xpath("//div[@class='q-notification__message col']"), "Endereço Invalido");
		metodo.capturarScreenshot();
		Executa.depoisDosTestes();

	}

	@Test
	@Order(6)
	public void cadastroPPREmBranco() {
		Executa.antesDosTestes();
		login.logar("teste@tra.com", "Rota@2025");
		ppr.cadastrarPPR("", "", "");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		metodo.pegarTextoNoElemento(By.xpath("//div[@role='alert']"), "campo obrigatório");
		metodo.capturarScreenshot();
		Executa.depoisDosTestes();

	}

	@Test
	@Order(3)
	public void consultarPPR() {
		Executa.antesDosTestes();
		login.logar("teste@tra.com", "Rota@2025");
		ppr.consultarPPR();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		metodo.esperarElementoSerVisivel(By.xpath("//div[@class='card'][1]"), 2);
		metodo.capturarScreenshot();
		Executa.depoisDosTestes();

	}
	@Test
	@Order(2)
	public void atualizarPPR() {

		Executa.antesDosTestes();
		login.logar("teste@tra.com", "Rota@2025");
		ppr.editarPPR("PPR Atualizada", "-23.499146444551368", "-46.84402261835825");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		metodo.pegarTextoNaClass(By.xpath("//div[@class='q-notification__message col']"), "Item atualizado");
		metodo.capturarScreenshot();
		Executa.depoisDosTestes();
	}

	@Test
	@Order(4)
	public void excluirPPR() {
		Executa.antesDosTestes();
		login.logar("teste@tra.com", "Rota@2025");
		ppr.excluirPPR();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		metodo.pegarTextoNaClass(By.xpath("//div[@class='q-notification__message col']"), "Item removido");
		metodo.capturarScreenshot();
		Executa.depoisDosTestes();
	}

}
