package revisao;

public class DescontoPorMaisDeQuinhentosReais implements Desconto {

	private Desconto proximoDesconto;

	@Override
	public double calcularDesconto(Orcamento orcamento) {
		if (orcamento.getValor() > 500.0) {
			return orcamento.getValor() * 0.05;
		} else {
			return this.proximoDesconto.calcularDesconto(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.proximoDesconto = desconto;
	}

}
