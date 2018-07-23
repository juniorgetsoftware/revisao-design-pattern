package revisao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {

	private final List<Item> itens;

	public Orcamento() {
		this.itens = new ArrayList<>();
	}

	public void add(Item item) {
		this.itens.add(item);
	}

	public double getValor() {
		return this.itens.stream().mapToDouble(Item::getValor).sum();
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public int totalItens() {
		return this.itens.size();
	}

	public boolean temItemComValorMaiorQue(double valor) {
		for (Item item : itens) {
			if (item.getValor() > valor) {
				return true;
			}
		}
		return false;
	}
}
