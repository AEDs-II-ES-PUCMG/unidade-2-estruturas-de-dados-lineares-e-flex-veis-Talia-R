import java.util.NoSuchElementException;

public class Fila<E> {

	private Celula<E> frente;
	private Celula<E> tras;
	private int qntItens;
	
	Fila() {
		
		Celula<E> sentinela = new Celula<E>();
		frente = tras = sentinela;
	}
	
	public boolean vazia() {
		
		return (frente == tras);
	}
	
	public void enfileirar(E item) {
		
		Celula<E> novaCelula = new Celula<E>(item);
		
		tras.setProximo(novaCelula);
		tras = tras.getProximo();
		qntItens++;
	}
	
	public E desenfileirar() {
		
		E item = null;
		Celula<E> primeiro;
		
		item = consultarPrimeiro();
		
		primeiro = frente.getProximo();
		frente.setProximo(primeiro.getProximo());
		
		primeiro.setProximo(null);
			
		// Caso o item desenfileirado seja também o último da fila.
		if (primeiro == tras){
			tras = frente;
		}
		qntItens--;
		return item;
	}
	
	public E consultarPrimeiro() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na fila!");
		}

		return frente.getProximo().getItem();

	}


	public int imprimirQntChar(E elemento){
		int qnt = 0;
		Celula<E> elementoAtual = frente.getProximo();
		if(!vazia()){
			while(elementoAtual != null){
				if(elemento == elementoAtual.getItem()) qnt++;
				elementoAtual = elementoAtual.getProximo();
			}
		}

		return qnt;
	}

	
	public void imprimir() {
		
		Celula<E> aux;
		
		if (vazia())
			System.out.println("A fila está vazia!");
		else {
			aux = this.frente.getProximo();
			while (aux != null) {
				System.out.println(aux.getItem());
				aux = aux.getProximo();
			}
		} 	
	}

	public Fila<E> extrairLote(int numItens){
		if(vazia()) throw new NullPointerException("Fila vazia");

		Fila<E> novaFila = new Fila<>();

		if(qntItens < numItens){
			numItens = qntItens;
		}

		for(int i = 0; i < numItens; i++){
			novaFila.enfileirar(this.desenfileirar());
		}

		return novaFila;
	}
}