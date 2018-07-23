package estrategy;

public class CalculadorDeImposto {
	
	public double realizarCalculo(Orcamento orcamento, Imposto imposto) {
		return imposto.calcularImposto(orcamento);
	}
}
