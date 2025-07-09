package mercadodabola.Negociacao;

import mercadodabola.ApetiteFinanceiro.Conservador;
import mercadodabola.ApetiteFinanceiro.Indiferente;
import mercadodabola.ApetiteFinanceiro.Mercenario;
import mercadodabola.Clube.Clube;
import mercadodabola.Jogador.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class NegociacaoTest {

    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {

        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Corinthians", 10, BigDecimal.valueOf(100000000));
        Goleiro goleiro = new Goleiro("Gabriel", 21, null, 8, new Indiferente(), BigDecimal.valueOf(800500), 12);

        // Act
        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        // Assert
        assertTrue(foiPossivelNegociar);

    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(100000000));
        Atacante atacante = new Atacante("Paulo", 35, null, 10, new Conservador(), BigDecimal.valueOf(800500), 20);

        // Act
        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        // Assert
        assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Paiva FC", 10, BigDecimal.valueOf(100));
        Goleiro goleiro = new Goleiro("Souza", 30, null, 6, new Indiferente(), BigDecimal.valueOf(1000), 3);

        // Act
        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        // Assert
        assertFalse(foiPossivelNegociar);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos() {
        // Arrange
        MeioCampo jogador = new MeioCampo("Vieira", 25, null, 6, new Indiferente(), BigDecimal.valueOf(1000));

        // Act
        BigDecimal valor = jogador.calcularValorCompra();

        // Assert
        assertEquals(BigDecimal.valueOf(1000), valor);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos() {
        // Arrange
        MeioCampo jogador = new MeioCampo("Gabriel", 31, null, 6, new Indiferente(), BigDecimal.valueOf(1000));

        // Act
        BigDecimal valor = jogador.calcularValorCompra();

        // Assert
        assertEquals(BigDecimal.valueOf(700.0), valor);
    }

    @Test
    public void atacanteDeveTerInteressePorClubeSuperior() {
        // Arrange
        Atacante atacante = new Atacante("Ferreira", 26, null, 8, new Mercenario(), BigDecimal.valueOf(800500), 10);
        Clube clube = new Clube("São Paulo", 10, BigDecimal.valueOf(100000000));

        // Act
        boolean interessado = atacante.temInteresse(clube);

        // Assert
        assertTrue(interessado);
    }

    @Test
    public void atacanteNaoDeveTerInteressePorClubeInferior() {
        // Arrange
        Atacante atacante = new Atacante("Alexandre", 26, null, 10, new Mercenario(), BigDecimal.valueOf(800500), 9);
        Clube clube = new Clube("São Paulo", -1, BigDecimal.valueOf(100000000));

        // Act
        boolean interessado = atacante.temInteresse(clube);

        // Assert
        assertFalse(interessado);
    }

    @Test
    public void lateralNovoComCruzamentosCalculaCorretamente() {
        // Arrange
        Lateral lateral = new Lateral("Pedro Lucas", 24, null, 8, new Indiferente(), BigDecimal.valueOf(800500), 16);

        // Act
        BigDecimal calculado = lateral.calcularValorCompra();

        // Assert
        assertEquals(0, calculado.compareTo(BigDecimal.valueOf(1056660)));
    }

    @Test
    public void clubeNaoTemDinheiroParaNegociarJogador() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clubeInteressado = new Clube("Palmeiras", 5, BigDecimal.valueOf(800500));
        Goleiro goleiro = new Goleiro("Gabrielle", 31, null, 10, new Mercenario(), BigDecimal.valueOf(100000000), 20);

        // Act
        boolean resultado = negociacao.negociar(clubeInteressado, goleiro);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void deveSerPossivelNegociarUmZagueiroComMaisDeTrintaAnosComDescontoAplicado() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube gremio = new Clube("Grêmio", 9, BigDecimal.valueOf(10000000));
        Zagueiro zagueiro = new Zagueiro("Alexandre", 33, null, 7, new Indiferente(), BigDecimal.valueOf(1000000));

        // Act
        boolean negociado = negociacao.negociar(gremio, zagueiro);

        // Assert
        assertTrue(negociado);
    }

    @Test
    public void meioCampistaNaoDeveAceitarClubeComReputacaoMuitoAlta() {
        // Arrange
        MeioCampo meio = new MeioCampo("Gabriel", 30, null, 8, new Indiferente(), BigDecimal.valueOf(1200000));
        Clube fortaleza = new Clube("Fortaleza", 9, BigDecimal.valueOf(10000000));

        // Act
        boolean interessado = meio.temInteresse(fortaleza);

        // Assert
        assertFalse(interessado);
    }

    @Test
    public void deveCalcularValorDoAtacanteComGolsEAbaixoDos30SemDesconto() {
        // Arrange
        Atacante atacante = new Atacante("Gabrielle", 27, null, 8, new Indiferente(), BigDecimal.valueOf(1000000), 10);

        // Act
        BigDecimal valor = atacante.calcularValorCompra();

        // Assert
        // Valor base: 1000000, 10 gols = +10% => 1.10 x 1000000 = 1.100.000
        assertEquals(0, valor.compareTo(BigDecimal.valueOf(1100000)));
    }

    @Test
    public void clubeComReputacaoZeroNaoPodeContratarJogador() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube americaNatal = new Clube("América Natal", 0, BigDecimal.valueOf(5000000));
        Atacante atacante = new Atacante("Gabriel", 28, null, 5, new Indiferente(), BigDecimal.valueOf(1000000), 0);

        // Act
        boolean negociado = negociacao.negociar(americaNatal, atacante);

        // Assert
        assertFalse(negociado);
    }

    @Test
    public void deveSerPossivelNegociarLateralJovemComClubeRico() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube gremio = new Clube("Grêmio", 9, BigDecimal.valueOf(2000000));
        Lateral lateral = new Lateral("Gabrielle", 24, null, 7, new Indiferente(), BigDecimal.valueOf(800000), 10);

        // Act
        boolean negociado = negociacao.negociar(gremio, lateral);

        // Assert
        assertTrue(negociado);
    }

    @Test
    public void naoDeveNegociarZagueiroComClubeSemSaldo() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube fortaleza = new Clube("Fortaleza", 8, BigDecimal.valueOf(10000));
        Zagueiro zagueiro = new Zagueiro("Gabriel", 30, null, 6, new Conservador(), BigDecimal.valueOf(500000));

        // Act
        boolean negociado = negociacao.negociar(fortaleza, zagueiro);

        // Assert
        assertFalse(negociado);
    }

    @Test
    public void atacanteDeveTerInteresseEmClubeSuperior() {
        // Arrange
        Atacante atacante = new Atacante("Paiva", 27, null, 7, new Indiferente(), BigDecimal.valueOf(900000), 5);
        Clube corinthians = new Clube("Corinthians", 9, BigDecimal.valueOf(10000000));

        // Act
        boolean interessado = atacante.temInteresse(corinthians);

        // Assert
        assertTrue(interessado);
    }
}

