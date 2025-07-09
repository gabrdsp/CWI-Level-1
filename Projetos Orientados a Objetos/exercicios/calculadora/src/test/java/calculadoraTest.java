import org.junit.Assert;
import org.junit.Test;
public class calculadoraTest {

    @Test
    public void deveSomarCorretamenteQuandoOsValoresForemInteiros() {

        // Arrange
        double a = 5;
        double b = 10;
        double resultadoEsperado = 15;

        Calculadora calculadora = new Calculadora();
        System.out.println("Números para a operação: " + a + " e " + b);

        // Act
        double resultadoCalculado = calculadora.somar(a, b);
        System.out.println("Resultado da soma: " + resultadoCalculado);

        // Assert
        Assert.assertEquals(resultadoEsperado, resultadoCalculado, 0.01);
        System.out.println("Cálculo executado com sucesso!");

    }

    @Test
    public void deveSubtrairCorretamenteQuandoOsValoresForemInteiros() {

        // Arrange
        double a = 100;
        double b = 25;
        double resultadoEsperado = 75;

        Calculadora calculadora = new Calculadora();
        System.out.println("Números para a operação " + a + " e " + b);

        // Act
        double resultadoCalculado = calculadora.subtrair(a, b);
        System.out.println("Resultado da subtração: " + resultadoCalculado);

        // Assert
        Assert.assertEquals(resultadoEsperado, resultadoCalculado, 0.01);
        System.out.println("Cálculo executado com sucesso!");

    }

    @Test
    public void deveMultiplicarCorretamenteQuandoNumerosForemInteiros() {

        // Arrange
        double a = 3;
        double b = 675;
        double resultadoEsperado = 2025;

        Calculadora calculadora = new Calculadora();
        System.out.println("Números para a operação: " + a + " e " + b);

        // Act
        double resultadoCalculado = calculadora.multiplicar(a, b);
        System.out.println("Resultado da multiplicação: " + resultadoCalculado);

        // Assert
        Assert.assertEquals(resultadoEsperado, resultadoCalculado, 0.01);
        System.out.println("Cálculo executado com sucesso!");

    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosForemInteiros() {

        // Arrange
        double a = 75;
        double b = 15;
        double resultadoEsperado = 5;

        Calculadora calculadora = new Calculadora();
        System.out.println("Números para a operação: " + a + " e " + b);

        // Act
        double resultadoCalculado = calculadora.dividir(a, b);
        System.out.println("Resultado da divisão: " + resultadoCalculado);

        // Assert
        Assert.assertEquals(resultadoEsperado, resultadoCalculado, 0.01);
        System.out.println("Cálculo executado com sucesso!");

    }

    @Test
    public void deveDividirCorretamenteQuandoNumerosPossuemPontosFlutuantes() {

        // Arrange
        double a = 3.5;
        double b = 0.5;
        double resultadoEsperado = 7;

        Calculadora calculadora = new Calculadora();
        System.out.println("Números para a operação: " + a + " e " + b);

        // Act
        double resultadoCalculado = calculadora.dividir(a, b);
        System.out.println("Resultado da divisão: " + resultadoCalculado);

        // Assert
        Assert.assertEquals(resultadoEsperado, resultadoCalculado, 0.01);
        System.out.println("Cálculo executado com sucesso!");

    }

}
