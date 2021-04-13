package junit_tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;

import org.junit.jupiter.api.Test;

import appmain.MainFrame;
import model.Ator;
import model.Dados;
import model.Estudio;
import model.Filme;
import model.PapelFeito;
import vision.CadastrarEstudio;
import vision.Menu;
import vision.RelatorioPersonagens;

/**
 * Classe para testes JUnit de uso interno.
 * 
 * @author Eduardo Rodrigues
 */
class Testes {

	/**
	 * Testa a valida��o de est�dio.
	 * 
	 * modifique as vari�veis para simular o uso com a tela.
	 */
	@Test
	void testeValidacaoEstudio() {
		CadastrarEstudio tela = new CadastrarEstudio();
		String nome = "Hollywood";
		String data = "26/12/2000";
		String dono = "Eduardo";
		String fat = "100000000";

		tela.getFieldNome().setText(nome);
		tela.getFieldData().setText(data);
		tela.getFieldDono().setText(dono);
		tela.getFieldFaturamento().setText(fat);

		assertNotNull(tela.getController().getHelper().obterModelo());
	}

	/**
	 * Testa a ativa��o dos bot�es no menu.
	 * 
	 * (Dados s�o pr�viamente cadastrados).
	 */
	@Test
	void testeAtivarBotoesMenu() {
		cadastrarDados();

		MainFrame app = new MainFrame();

		Menu menu = app.getMenu();
		menu.getController().ativarbotao();

		boolean teste = (menu.getButtonRegistrarEstudio().isEnabled() && menu.getButtonAdicionarFilme().isEnabled()
				&& menu.getButtonMostrarFilmes().isEnabled() && menu.getButtonMostrarAtores().isEnabled()
				&& menu.getButtonMostrarCache().isEnabled() && menu.getButtonMostrarPersonagens().isEnabled());

		assertTrue(teste);
	}

	/**
	 * Testa o m�todo atualizarModelo da classe RelatorioPersonagensControl.
	 * 
	 * O m�todo procura em Dados todos os atores cadastrados e retorna um
	 * DefaultComboBoxModel com o nome deles. (Dados s�o cadastrados pr�viamente).
	 */
	@Test
	void testeLerAtoresCadastrados() {
		cadastrarDados();

		RelatorioPersonagens tela = new RelatorioPersonagens();

		DefaultComboBoxModel<Object> modelo = tela.getController().atualizarModelo();

		assertFalse(modelo.getSize() == 0);
	}

	/**
	 * Cadastra em Dados dois est�dios modelo para testes.
	 */
	private void cadastrarDados() {
		String dono = "Eduardo";
		String diretor = "Pablo";
		String ator1 = "Adriano";
		String ator2 = "Cristiano";
		Calendar data = Calendar.getInstance();

		ArrayList<Filme> filmes = new ArrayList<>();
		ArrayList<Filme> filmes2 = new ArrayList<>();

		filmes.add(new Filme("filme 1", 12, 2020, 1, 100, diretor));
		filmes.add(new Filme("filme 2", 12, 2020, 2, 100, diretor));

		filmes.get(0).getNomeAtores().add(ator1);
		filmes.get(0).getNomeAtores().add(ator2);

		filmes.get(1).getNomeAtores().add(ator1);
		filmes.get(1).getNomeAtores().add(ator2);

		filmes2.add(new Filme("filme 2", 12, 2020, 2, 100, diretor));
		filmes2.add(new Filme("filme 1", 12, 2020, 1, 100, diretor));

		filmes2.get(0).getNomeAtores().add(ator1);
		filmes2.get(0).getNomeAtores().add(ator2);

		filmes2.get(1).getNomeAtores().add(ator1);
		filmes2.get(1).getNomeAtores().add(ator2);

		Dados.getEstudios().add(new Estudio("Hollywood", dono, data.getTime(), 100000));
		Dados.getEstudios().add(new Estudio("Hollywood2", dono, data.getTime(), 200000));
		Dados.getEstudios().get(0).getFilmes().add(filmes.get(0));
		Dados.getEstudios().get(0).getFilmes().add(filmes.get(1));
		Dados.getEstudios().get(1).getFilmes().add(filmes2.get(0));
		Dados.getEstudios().get(1).getFilmes().add(filmes2.get(1));

		PapelFeito papelFeito1 = new PapelFeito(100, "B1");
		PapelFeito papelFeito2 = new PapelFeito(50, "B2");

		ArrayList<PapelFeito> papeisFeitos1 = new ArrayList<>();
		papeisFeitos1.add(papelFeito1);
		papeisFeitos1.add(papelFeito2);

		ArrayList<PapelFeito> papeisFeitos2 = new ArrayList<>();
		papeisFeitos2.add(papelFeito1);

		Dados.getAtores().add(new Ator(ator1, 100, "Brasil", 15, 'M', new String[] { "corredor", "jogador" }));
		Dados.getAtores().add(new Ator(ator2, 200, "Brasil", 14, 'M', new String[] { "jogador", "corredor" }));
		Dados.getAtores().get(0).getPapeisFeitos().add(papeisFeitos1.get(0));
		Dados.getAtores().get(0).getPapeisFeitos().add(papeisFeitos1.get(1));
		Dados.getAtores().get(1).getPapeisFeitos().add(papeisFeitos2.get(0));
	}
}
