package Excecoes;

public class PersonagemNaoEncontradoNoMapaException extends RuntimeException {
    public PersonagemNaoEncontradoNoMapaException() {
        super("O personagem procurado não está no mapa");
    }
}