package Classes;

import Mapa.Mapa;
import Personagens.Personagem;

public abstract class Mago extends Personagem {
    protected Mago(int forca, int agilidade, int inteligencia, int constituicao, String simbolo, boolean pertenceASociedadeDoAnel) {
        super(forca, agilidade, inteligencia, constituicao, simbolo, pertenceASociedadeDoAnel);
    }

    @Override
    public void atacar(Mapa mapa) {
        int posicao = mapa.buscarPosicao(this);
        for (int i = posicao + getDirecao(); i >= 0 && i < mapa.tamanho(); i += getDirecao()) {
            Personagem alvo = mapa.buscarCasa(i);
            if (alvo != null && alvo.isSociedade() != this.isSociedade()) {
                alvo.sofrerDano(this.inteligencia);
            }
        }
    }

    @Override
    public void mover(Mapa mapa) {
        if (mapa.todos().length == 1) {
            int posicao = mapa.buscarPosicao(this);
            int destino = posicao + getDirecao();
            if (destino >= 0 && destino < mapa.tamanho()) {
                mapa.mover(posicao, destino);
            }
        }
    }
}
