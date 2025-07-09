package Classes;

import Mapa.Mapa;
import Personagens.Personagem;

public abstract class Arqueiro extends Personagem {
    protected Arqueiro(int forca, int agilidade, int inteligencia, int constituicao, String simbolo, boolean pertenceASociedadeDoAnel) {
        super(forca, agilidade, inteligencia, constituicao, simbolo, pertenceASociedadeDoAnel);
    }

    @Override
    public void atacar(Mapa mapa) {
        int posicao = mapa.buscarPosicao(this);
        for (int distancia = 3; distancia >= 1; distancia--) {
            int alvoPosicao = posicao + (getDirecao() * distancia);
            Personagem alvo = mapa.buscarCasa(alvoPosicao);
            if (alvo != null && alvo.isSociedade() != this.isSociedade()) {
                alvo.sofrerDano(distancia * agilidade);
                break;
            }
        }
    }

    @Override
    public void mover(Mapa mapa) {
        int posicao = mapa.buscarPosicao(this);
        int destino2 = posicao + (2 * getDirecao());
        int destino1 = posicao + getDirecao();

        if (destino2 >= 0 && destino2 < mapa.tamanho()
                && mapa.buscarCasa(destino2) == null
                && mapa.buscarCasa(destino1) == null) {
            mapa.mover(posicao, destino2);
        } else if (destino1 >= 0 && destino1 < mapa.tamanho()
                && mapa.buscarCasa(destino1) == null) {
            mapa.mover(posicao, destino1);
        }
    }
}
