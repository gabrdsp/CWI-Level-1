package Excecoes;

public class PosicaoOcupadaException extends RuntimeException {
    public PosicaoOcupadaException(int posicao){
        super("A posição " + posicao + " já está ocupada");
    }
}