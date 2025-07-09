package Classes;

import Personagens.Personagem;
import Mapa.Mapa;

public abstract class Guerreiro extends Personagem {
    protected Guerreiro(int forca, int agilidade, int inteligencia, int constituicao, String simbolo, boolean pertenceASociedadeDoAnel) {
        super(forca, agilidade, inteligencia, constituicao, simbolo, pertenceASociedadeDoAnel);
    }

    @Override
    public void atacar(Mapa mapa) {
        int posicao = mapa.buscarPosicao(this);
        int alvoPosicao = posicao + getDirecao();

        Personagem alvo = mapa.buscarCasa(alvoPosicao);
        if (alvo != null && alvo.isSociedade() != this.isSociedade()) {
            alvo.sofrerDano(this.forca * 2);
        }
    }

    @Override
    public void mover(Mapa mapa) {
        int posicao = mapa.buscarPosicao(this);
        int destino = posicao + getDirecao();

        if (destino >= 0 && destino < mapa.tamanho() && mapa.buscarCasa(destino) == null) {
            mapa.mover(posicao, destino);
        }
    }
}
