package ExploracaoEspacial.Nave;

import ExploracaoEspacial.Planeta.Planeta;
import ExploracaoEspacial.Recursos.Recursos;

import java.util.ArrayList;
import java.util.List;

public class Nave {
    private int posicao;
    private int combustivel;
    private static final int litrosCombustivelGastosPorPosicao = 3;

    public Nave(int quantidadeCombustivel) {
        this.posicao = 0;
        this.combustivel = quantidadeCombustivel;
    }

    public int getQuantidadeDeCombustivel() {
        return combustivel;
    }

    public int getPosicao() {
        return posicao;
    }

    public List<Recursos> explorar(List<Planeta> planetas) {
        List<Recursos> recursosColetados = new ArrayList<>();
        int posicaoBase = 0;

        for (Planeta planeta : planetas) {
            boolean naveChegouAoDestino = moverAteDestino(planeta.getPosicao());

            if (naveChegouAoDestino) {
                recursosColetados.addAll(planeta.getRecursos());
            } else {
                break;
            }
        }

        moverAteDestino(posicaoBase);
        return recursosColetados;
    }

    public List<Recursos> explorar(Planeta planeta) {
        List<Planeta> listaDeUmUnicoPlaneta = new ArrayList<>();
        listaDeUmUnicoPlaneta.add(planeta);
        return explorar(listaDeUmUnicoPlaneta);
    }

    private boolean moverAteDestino(int destino) {
        int distancia = Math.abs(destino - this.posicao);
        int combustivelNecessario = distancia * litrosCombustivelGastosPorPosicao;

        if (this.combustivel >= combustivelNecessario) {
            this.combustivel -= combustivelNecessario;
            this.posicao = destino;
            return true;
        } else {
            int movimentosPossiveis = Math.min(this.combustivel / litrosCombustivelGastosPorPosicao, distancia);
            int direcao = Integer.compare(destino, this.posicao);
            this.posicao = this.posicao + (movimentosPossiveis * direcao);
            this.combustivel -= movimentosPossiveis * litrosCombustivelGastosPorPosicao;
            return false;
        }
    }
}
