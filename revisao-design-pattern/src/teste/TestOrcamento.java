package teste;

import org.junit.*;
import revisao.Orcamento;
import revisao.Item;

public class TestOrcamento {

	private Orcamento orcamento;

	@Before
	public void setUp() {
		this.orcamento = new Orcamento();
	}

	@After
	public void tearDown() {
		this.orcamento = null;
	}

	@Test
	public void deveAdicionarUmItem() {
		this.orcamento.add(new Item("Livro", 150.0));
		Assert.assertEquals(orcamento.totalItens(), 1);
		this.orcamento.add(new Item("Mouse", 100.0));
		Assert.assertEquals(orcamento.totalItens(), 2);
	}

	@Test
	public void deveCalcularOValorTotalDosItens() {
		this.orcamento.add(new Item("Livro", 150.0));
		this.orcamento.add(new Item("Mouse", 100.0));

		double valotToal = orcamento.getValor();

		Assert.assertEquals(250.0, valotToal, 0.0001);
	}

}
