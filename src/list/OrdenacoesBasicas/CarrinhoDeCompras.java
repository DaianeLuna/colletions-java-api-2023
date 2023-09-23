package list.OrdenacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;
    public CarrinhoDeCompras() {

        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemParaRemover = new ArrayList<>();
        for (Item t : itemList) {
            if (t.getNome().equalsIgnoreCase(nome)) ;
            {
                itemParaRemover.add(t);
            }
        }
        itemList.removeAll(itemParaRemover);
    }

    public double quantidadeValorTotal() {//
        return itemList.size(); //Para retornar quantidade
    }

    public double calcularValorTotal() {
        double valorTotal = 0d; //Para retornar o valor
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem; //valorTotal = valorTotal + valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public String exibirItens() {
        return itemList.toString();
    }

    public static void main(String[] args) {

        CarrinhoDeCompras carinhodeCompras = new CarrinhoDeCompras();

        carinhodeCompras.adicionarItem("Item 1", 2,3);
        carinhodeCompras.adicionarItem("Item 2", 3, 5);

        System.out.println("O número total da lista de itens é " + carinhodeCompras.quantidadeValorTotal());
        System.out.println("O valor total dos preços da itens é " + carinhodeCompras.calcularValorTotal());
        System.out.println("O descrição dos itens é " + carinhodeCompras.exibirItens());

    }
}
