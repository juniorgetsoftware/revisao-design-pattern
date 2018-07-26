package revisao;

public abstract class Imposto {

	private Imposto outroImposto;

	public Imposto() {

	}

	public Imposto(Imposto imposto) {
		this.outroImposto = imposto;
	}

	public abstract double calcularImposto(Orcamento orcamento);

	protected double calcularOutroimopsto(Orcamento orcamento) {
		if(outroImposto == null) return 0;
		return this.outroImposto.calcularImposto(orcamento);
	}

}
