package Simulador;

import Excecoes.SauronDominaOMundoException;
import Mapa.Mapa;
import Personagens.Personagem;

public class Simulador {
    private final Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public void simular() {
        while (true) {
            executarTurnoDosPersonagens();

            if (sociedadeConquistouObjetivo()) return;

            if (!sociedadeAindaViva()) {
                throw new SauronDominaOMundoException();
            }
        }
    }

    private void executarTurnoDosPersonagens() {
        for (Personagem p : mapa.todos()) {
            if (p.getConstituicao() == 0) continue;
            p.atacar(mapa);
            p.mover(mapa);
        }
    }

    private boolean sociedadeConquistouObjetivo() {
        for (Personagem p : mapa.todos()) {
            if (p.isSociedade()) {
                int pos = mapa.buscarPosicao(p);
                if (pos == mapa.tamanho() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean sociedadeAindaViva() {
        for (Personagem p : mapa.todos()) {
            if (p.isSociedade()) {
                return true;
            }
        }
        return false;
    }
}
