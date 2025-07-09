package Excecoes;

public class PersonagemJaEstaNoMapaException extends RuntimeException {
    public PersonagemJaEstaNoMapaException() {
        super("O personagem já está inserido no mapa");
    }
}