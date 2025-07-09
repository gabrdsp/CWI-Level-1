package ExploracaoEspacial.Planeta;

import ExploracaoEspacial.Recursos.Recursos;

import java.util.List;

public class Planeta {
    private final int posicao;
    private final List<Recursos> recursos;

    public Planeta(int posicao, List<Recursos> recursos) {
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public int getPosicao() {
        return posicao;
    }

    public List<Recursos> getRecursos() {
        return recursos;
    }

    public int getValorTotal() {
        int valorTotal = 0;
        for (Recursos recurso : this.recursos) {
            valorTotal += recurso.getValor();
        }
        return valorTotal;
    }

    public int getValorPorPeso() {
        int valorTotalPorPeso = 0;
        for (Recursos recurso : this.recursos) {
            valorTotalPorPeso += recurso.getValor() / recurso.getPeso();
        }
        return valorTotalPorPeso;
    }
}
