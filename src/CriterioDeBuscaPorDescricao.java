import java.util.Comparator;

public class CriterioDeBuscaPorDescricao implements Comparator<ItemDePedido> {

    @Override
    public int compare(ItemDePedido item1, ItemDePedido item2) {
        int res = -1;
        if(item1.getProduto().descricao == item1.getProduto().descricao) res = 0;
        if(item1.getProduto().descricao != item1.getProduto().descricao) res =  1;
        return res;
    }
}

