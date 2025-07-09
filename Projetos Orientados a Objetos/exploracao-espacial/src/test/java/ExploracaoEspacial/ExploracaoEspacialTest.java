package ExploracaoEspacial;

import ExploracaoEspacial.Nave.Nave;
import org.junit.Assert;
import org.junit.Test;
import ExploracaoEspacial.Planeta.Planeta;
import ExploracaoEspacial.Recursos.*;

import java.util.ArrayList;
import java.util.List;

public class ExploracaoEspacialTest {

    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
        // Arrange
        int posicaoEsperada = 2;
        int combustivelEsperado = 1;
        Nave orion = new Nave(7);
        Planeta marte = new Planeta(3, new ArrayList<Recursos>());

        // Act
        List<Recursos> recursos = orion.explorar(marte);
        int posicaoResultado = orion.getPosicao();
        int combustivelFinal = orion.getQuantidadeDeCombustivel();

        // Assert
        System.out.println("Nave ficou à deriva na posição: " + posicaoResultado);
        System.out.println("Combustível restante: " + combustivelFinal + "L");
        Assert.assertTrue(recursos.isEmpty());
        Assert.assertEquals(combustivelEsperado, combustivelFinal);
        Assert.assertEquals(posicaoEsperada, posicaoResultado);
    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {
        // Arrange
        Planeta netuno = new Planeta(7, new ArrayList<Recursos>());

        // Act
        int valorTotalResultadp = netuno.getValorTotal();

        // Assert
        System.out.println("Valor total dos recursos do planeta Netuno: " + valorTotalResultadp);
        Assert.assertEquals(0, valorTotalResultadp);
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta() {
        // Arrange
        List<Recursos> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Ferro());
        recursos.add(new Oxigenio());
        recursos.add(new Silicio());

        Planeta jupiter = new Planeta(8, recursos);

        // Act
        int valorTotalResultado = jupiter.getValorTotal();

        // Assert
        System.out.println("Valor total dos recursos do planeta Júpiter: " + valorTotalResultado);
        Assert.assertEquals(490, valorTotalResultado);
    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {
        // Arrange
        Planeta urano = new Planeta(5, new ArrayList<Recursos>());

        // Act
        int valorPorPesoResultado = urano.getValorPorPeso();

        // Assert
        System.out.println("Valor por peso dos recursos do planeta Urano (sem recursos): " + valorPorPesoResultado);
        Assert.assertEquals(0, valorPorPesoResultado);
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta() {
        // Arrange
        List<Recursos> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Ferro());
        recursos.add(new Oxigenio());
        recursos.add(new Silicio());

        Planeta plutao = new Planeta(9, recursos);

        // Act
        int valorPorPesoResultado = plutao.getValorPorPeso();

        // Assert
        System.out.println("Valor por peso dos recursos do planeta Plutão: " + valorPorPesoResultado);
        Assert.assertEquals(58, valorPorPesoResultado);
    }
}