package teste.chainofresponsibility;

import revisao.Desconto;
import revisao.Orcamento;

public class SemDesconto implements Desconto {

	@Override
	public double calcularDesconto(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto desconto) {

	}

}
