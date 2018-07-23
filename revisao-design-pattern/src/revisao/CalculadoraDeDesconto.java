package revisao;

import teste.chainofresponsibility.SemDesconto;

public class CalculadoraDeDesconto {

	public double calcularDesconto(Orcamento orcamento) {
		Desconto d1 = new DescontoPorCincoItens();
		Desconto d2 = new DescontoPorMaisDeQuinhentosReais();
		Desconto semDesconto = new SemDesconto();

		d1.setProximo(d2);
		d2.setProximo(semDesconto);

		return d1.calcularDesconto(orcamento);
	}

}
