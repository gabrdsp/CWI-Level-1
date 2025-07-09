package Mapa;

import Excecoes.*;
import Personagens.Personagem;

public class Mapa {
    private final Personagem[] posicoes;

    public Mapa() {
        posicoes = new Personagem[10];
    }

    public int tamanho() {
        return posicoes.length;
    }

    public void inserir(int posicao, Personagem personagem) {
        if (posicoes[posicao] != null) {
            throw new PosicaoOcupadaException(posicao);
        }
        for (Personagem p : posicoes) {
            if (p != null && p.equals(personagem)) {
                throw new PersonagemJaEstaNoMapaException();
            }
        }
        posicoes[posicao] = personagem;
    }

    public int buscarPosicao(Personagem personagem) {
        for (int i = 0; i < posicoes.length; i++) {
            if (posicoes[i] != null && posicoes[i].equals(personagem)) {
                return i;
            }
        }
        throw new PersonagemNaoEncontradoNoMapaException();
    }

    public Personagem buscarCasa(int posicao) {
        if (posicao < 0 || posicao >= posicoes.length) return null;
        Personagem personagem = posicoes[posicao];
        return (personagem != null && personagem.getConstituicao() > 0) ? personagem : null;
    }

    public void mover(int origem, int destino) {
        Personagem personagem = posicoes[origem];
        if (personagem != null) {
            posicoes[origem] = null;
            posicoes[destino] = personagem;
        }
    }

    public Personagem[] todos() {
        int count = 0;
        for (Personagem p : posicoes) {
            if (p != null && p.getConstituicao() > 0) count++;
        }

        Personagem[] vivos = new Personagem[count];
        int index = 0;
        for (Personagem personagem : posicoes) {
            if (personagem != null && personagem.getConstituicao() > 0) {
                vivos[index++] = personagem;
            }
        }
        return vivos;
    }

    public String exibir() {
        StringBuilder resultado = new StringBuilder();
        for (Personagem p : posicoes) {
            if (p != null && p.getConstituicao() > 0) {
                resultado.append("|").append(p);
            } else {
                resultado.append("| ");
            }
        }
        resultado.append("|");
        return resultado.toString();
    }
}
