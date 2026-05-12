import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lista<E> implements Iterable<E> {

    private Celula<E> primeiro;
    private Celula<E> ultimo;
    private int tamanho;

    public Lista() {
        Celula<E> sentinela = new Celula<>();
        primeiro = ultimo = sentinela;
        tamanho = 0;
    }

    public boolean vazia() {
        return primeiro == ultimo;
    }

    public int tamanho() {
        return tamanho;
    }

    public void inserirFinal(E item) {
        Celula<E> nova = new Celula<>(item);
        ultimo.setProximo(nova);
        ultimo = nova;
        tamanho++;
    }

    public void inserirInicio(E item) {
        Celula<E> nova = new Celula<>(item, primeiro.getProximo());
        if (vazia()) ultimo = nova;
        primeiro.setProximo(nova);
        tamanho++;
    }

    public E removerInicio() {
        if (vazia()) throw new NoSuchElementException("Lista vazia!");
        Celula<E> atual = primeiro.getProximo();
        primeiro.setProximo(atual.getProximo());
        if (atual == ultimo) ultimo = primeiro;
        atual.setProximo(null);
        tamanho--;
        return atual.getItem();
    }

    public void imprimir() {
        if (vazia()) {
            System.out.println("A lista está vazia!");
        } else {
            Celula<E> aux = primeiro.getProximo();
            while (aux != null) {
                System.out.println(aux.getItem());
                aux = aux.getProximo();
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Celula<E> atual = primeiro.getProximo();

            @Override
            public boolean hasNext() {
                return atual != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E item = atual.getItem();
                atual = atual.getProximo();
                return item;
            }
        };
    }

    // Tarefa 1
    public E buscarPor(Comparator<E> criterioDeBusca, E item) {
        if(vazia()) throw new NoSuchElementException("Lista vazia!");

        E itemProcurado = null;
        Celula<E> itemAtual = primeiro.getProximo();

        for(int i = 0; i < tamanho; i++){
            int resposta = criterioDeBusca.compare(item, itemAtual.getItem());
            if(resposta == 0){
                return itemAtual.getItem(); //item procurado
            }
            itemAtual = itemAtual.getProximo();
        }

        return itemProcurado;
    }

    // Tarefa 2
    public double somarMultiplicacoes(Function<E, Double> extratorValor, Function<E, Integer> extratorFator) {
        Celula<E> celulaAtual;
        Double valor, somatorio = 0d;
        int quantidade;

        if(vazia()) throw new NoSuchElementException("Lista vazia");
        celulaAtual = primeiro.getProximo();
        for (int i = 0; i < tamanho; i++) {
            valor = 0d;
            quantidade = 0;
            ItemDePedido item = (ItemDePedido) celulaAtual.getItem();

            valor = item.getPrecoVenda();
            quantidade = item.getQuantidade();

            somatorio = somatorio + (valor * quantidade);

            celulaAtual = celulaAtual.getProximo();
        }
        return somatorio;
    }

    // Tarefa 3
    public Lista<E> filtrar(Predicate<E> condicional) {

        if(vazia()) throw new IllegalStateException("Lista vazia");
        Lista<E> novaLista = new Lista<>();

        Celula<E> itemAtual = primeiro.getProximo();

        for(int i = 0; i < tamanho; i++){
            if(condicional.test(itemAtual.getItem())){
                novaLista.inserirFinal(itemAtual.getItem());
            }
            itemAtual = itemAtual.getProximo();
        }

        return novaLista;
    }
}

// verificar condicional
