import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	public String imprimir(){
		StringBuilder s = new StringBuilder();
		s.append("-> Método imprimir: ");
		Celula<E> atual = topo;
		while(atual!=fundo){
			s.append(atual.getItem() + " | ");
			atual = atual.getProximo();
		}
		s.append("\n");
		return s.toString();
	}

	public void imprimirCerto(Celula<E> atual){
		if(atual!=fundo){
			imprimirCerto(atual.getProximo());
			System.out.print(atual.getItem() + " | ");
		}
	}

	public Celula<E> getTopo(){
		return topo;
	}

	public Celula<E> getFundo(){
		return fundo;
	}

	/**
	 * Cria e devolve uma nova pilha contendo os primeiros numItens elementos
	 * do topo da pilha atual.
	 * 
	 * Os elementos são mantidos na mesma ordem em que estavam na pilha original.
	 * Caso a pilha atual possua menos elementos do que o valor especificado,
	 * uma exceção será lançada.
	 *
	 * @param numItens o número de itens a serem copiados da pilha original.
	 * @return uma nova instância de Pilha<E> contendo os numItens primeiros elementos.
	 * @throws IllegalArgumentException se a pilha não contém numItens elementos.
	 */
	public Pilha<E> subPilha(int numItens) {
		
		// TODO
		return null;
	}

}