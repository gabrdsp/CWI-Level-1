import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DicionarioTest {

    @Test
    public void deveTraduzirCarroELivroDoInglesParaPortuguesEDoPortuguesParaOIngles() throws PalavraNaoEncontradaExeption {

        Dicionario dicionario = new Dicionario();
        dicionario.adicionarUmaPalavra("Carro", "Car", TipoDicionario.Ingles);
        dicionario.adicionarUmaPalavra("Livro", "Book", TipoDicionario.Ingles);
        dicionario.adicionarUmaPalavra("Tiger", "Tigre", TipoDicionario.Portugues);
        dicionario.adicionarUmaPalavra("Paper", "Papel", TipoDicionario.Portugues);

        assertEquals("Car", dicionario.traduzir("Carro", TipoDicionario.Ingles));
        assertEquals("Book", dicionario.traduzir("Livro", TipoDicionario.Ingles));

        assertEquals("Papel", dicionario.traduzir("Paper", TipoDicionario.Portugues));
        assertEquals("Tigre", dicionario.traduzir("Tiger", TipoDicionario.Portugues));

    }

    @Test(expected = PalavraNaoEncontradaExeption.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontrada() throws PalavraNaoEncontradaExeption {

        Dicionario dicionario = new Dicionario();
        dicionario.adicionarUmaPalavra("Carro", "Car", TipoDicionario.Ingles);
        dicionario.adicionarUmaPalavra("Livro", "Book", TipoDicionario.Ingles);

        String traducao = dicionario.traduzir("Caneta", TipoDicionario.Ingles);
    }

    @Test
    public void deveTraduzirPalavrasComAcentos() throws PalavraNaoEncontradaExeption {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarUmaPalavra("Café", "Coffee", TipoDicionario.Ingles);
        dicionario.adicionarUmaPalavra("Computador", "Computer", TipoDicionario.Ingles);

        assertEquals("Coffee", dicionario.traduzir("CAFÉ", TipoDicionario.Ingles));
        assertEquals("Computer", dicionario.traduzir("computador", TipoDicionario.Ingles));
    }
}

