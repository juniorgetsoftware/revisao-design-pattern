package revisao;

public class DescontoPorCincoItens implements Desconto {

	private Desconto proximoDesconto;

	@Override
	public double calcularDesconto(Orcamento orcamento) {
		if (orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.10;
		} else {
			return this.proximoDesconto.calcularDesconto(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.proximoDesconto = desconto;
	}

}
