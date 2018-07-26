package revisao;

public class ICMS extends Imposto {

	public ICMS(Imposto imposto) {
		super(imposto);
	}

	public ICMS() {

	}

	@Override
	public double calcularImposto(Orcamento orcamento) {
		return orcamento.getValor() * 0.1 + calcularOutroimopsto(orcamento);
	}

}
