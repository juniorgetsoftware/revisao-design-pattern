package revisao;

public class COFINS extends Imposto {

	public COFINS(Imposto imposto) {
		super(imposto);
	}

	public COFINS() {

	}

	@Override
	public double calcularImposto(Orcamento orcamento) {
		return orcamento.getValor() * 0.03 + calcularOutroimopsto(orcamento);
	}

}
