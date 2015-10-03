package br.com.caelum.agiletickets.integration.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.agiletickets.models.Estabelecimento;
import br.com.caelum.agiletickets.persistencia.JPAEstabelecimentoDao;

public class JPAEstabelecimentoDaoTest {

	private static EntityManagerFactory emf;
	private EntityManager manager;
	private JPAEstabelecimentoDao dao;
	
	@BeforeClass
	public static void beforeClass() {
		emf = Persistence.createEntityManagerFactory("tests");
	}
	
	@Before
	public void before() {
		this.manager = emf.createEntityManager();
		this.manager.getTransaction().begin();
		this.dao = new JPAEstabelecimentoDao(manager);
	}
	
	@After
	public void after() {
		this.manager.getTransaction().rollback();
		this.manager.close();
	}
	
	@AfterClass
	public static void afterClass() {
		emf.close();
	}
	
	@Test
	public void deveAdicionarUmEstabelecimento() {
		Estabelecimento novo = new Estabelecimento();
		novo.setNome("Novo estabelecimento de testes");
		novo.setEndereco("Endereco do estabelecimento de testes");
		novo.setTemEstacionamento(true);
		
		dao.adiciona(novo);
		
		Estabelecimento adicionado = manager.find(Estabelecimento.class, novo.getId());
		Assert.assertEquals(adicionado, novo);
	}

	@Test
	public void deveListarTodosEstabelecimentosCadastrados() {
		
		Estabelecimento primeiro = criaEstabelecimento("Estab de Teste 1", "Ender 1", true);
		Estabelecimento segundo = criaEstabelecimento("Estab de Teste 2", "Ender 2", true);
		Estabelecimento terceiro = criaEstabelecimento("Estab de Teste 3", "Ender 3", false);
		
		List<Estabelecimento> todos = dao.todos();
		
		Assert.assertEquals(3, todos.size());
		Assert.assertTrue(todos.containsAll(Arrays.asList(primeiro,segundo,terceiro)));
	}

	private Estabelecimento criaEstabelecimento(String nome, String endereco, boolean temEstacionamento) {
		
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setNome(nome);
		estabelecimento.setEndereco(endereco);
		estabelecimento.setTemEstacionamento(temEstacionamento);
		
		this.manager.persist(estabelecimento);
		
		return estabelecimento;
	}
}