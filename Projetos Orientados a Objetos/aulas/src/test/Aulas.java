import org.junit.Assert;
import org.junit.Test;

public class Aulas {
    @Test
    public void exemploVariavel() {
        //Imprimindo numero
        System.out.println(21);
        /*
            A variavel de nome idade que é do tipo inteiro deve valer 21
        */
        int idade = 19;

        //Imprimindo o valor da variavel idade
        System.out.println(idade);
    }

    @Test
    public void exemploCalculoAreaQuadrado() {
        int ladoA = 2;
        int ladoB = 3;
        int area = ladoA * ladoB;

        System.out.println(area);
    }

    @Test
    public void exemploCalculoAreaCirculo(){
        double raio = 1.5;
        final double pi = 3.14159;
        double area = pi * raio;

        System.out.println(area);
    }

    @Test
    public void exemploBoolean() {
        boolean informacao = true;
        System.out.println(informacao);

        boolean umEMaiorQueZero = 1 > 0;
        System.out.println(umEMaiorQueZero);
    }

    @Test
    public void exemploChar() {
        char primeiraLetraNome = 'G';
        System.out.println(primeiraLetraNome);
    }

    @Test
    public void copiaValoresEntreVariaveisPrimitivas() {
        int a =2;
        int b = a;

        System.out.println(a);
        System.out.println(b);

        a = 3;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void castVariaveisPrimitivas() {
        double pi = 3.14159;
       // int piInteiro = pi; --- Essa atribuição não é possível, é preciso fazer uma conversão antes.
        int piInteiro = (int) pi;
        System.out.println(pi);
        System.out.println(piInteiro);

        int variavelInteiro = 4;
        double variavelFlutuante = variavelInteiro;
        System.out.println(variavelInteiro);
        System.out.println(variavelFlutuante);
    }

    @Test
    public void texto() {
        System.out.println("Gabriel");

        String meuNome = "Gabriel Paiva";
        System.out.println(meuNome);
    }

    // Operadores Aritmeticos

    @Test
    public void operadoresAritmeticos(){
        System.out.println(2+2);

        int soma = 2+2;
        System.out.println("Imprimindo a soma: " + soma);

        int valorA = 5;
        int valorB = 3;
        int subtracao = valorA - valorB;
        System.out.println("Imprimindo a subtração: " + subtracao);

        System.out.println("Imprimindo operadors aritmeticos com inteiros");
        int a = 8;
        int b = 3;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println("Modulo: " + a % b);

        System.out.println("Imprimindo operadores aritmeticos com double");
        double y = 3.2;
        double x = 2.1;
        System.out.println(y + x);
        System.out.println(y - x);
        System.out.println(y * x);
        System.out.println(y / x);
        System.out.println("Modulo: " + y % x);
    }

    @Test
    public void somaESubtracao() {
        int valorA = 2;
        int valorB = 2;
        System.out.println("O resultado da soma de valorA com valorB é: " + (valorA + valorB));

        int soma = valorA + valorB;
        System.out.println("O resultado da soma de valorA com valorB é: " + soma + " e o valor esperado é 4");

        int subtracao = valorA - valorB;
        System.out.println("O resultado da subtração de valorA com valorB é: " + subtracao + " e o valor esperado é 0");
    }

    @Test
    public void deveSomarCorretamenteQuandoOsNumerosForemInteiros() {
        // Triple A -> AAA (Arrange, Act e Assert)

        // Arrange
        int valorA = 2;
        int valorB = 2;
        int resultadoEsperado = 4;

        // Act
        int soma = valorA + valorB;

        // Assert
        Assert.assertEquals(resultadoEsperado, soma);
    }

    @Test
    public void delta() {
        // Arrange
        double valorA = 1.5;
        double valorB = 2;
        double resultadoEsperado = 3.5;

        // Act
        double soma = valorA + valorB;

        // Assert
        Assert.assertEquals(resultadoEsperado, soma, 0);
    }

    @Test
    public void testDelta() {
        //Arrange
        double pi = 3.1415;
        double valorComparacao = 3.14;

        // Assert
        Assert.assertEquals(pi, valorComparacao, 0.01);
    }

    @Test
    public void operadoresLogicos() {
        System.out.println(true);
        System.out.println(false);

        boolean umEMaiorQueDois = 1 > 2;
        System.out.println(1 > 2);
        System.out.println(1 == 2);
        System.out.println(1 < 2);

        // Tabela verdade e (and)
        System.out.println("Tabela verdade e (and) - condicao e condicao");
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);
        boolean umEMaiorQueZero = 1 >0;
        boolean umEMaiorQueMenosUm = 1 > -1;
        System.out.println(umEMaiorQueZero && umEMaiorQueMenosUm);
        System.out.println( umEMaiorQueDois && umEMaiorQueZero && umEMaiorQueMenosUm);

        // Tabela verdade ou (or)
        System.out.println("Tabela verdade ou (or) - condicao ou condicao");
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);
        System.out.println(1 > 3 || umEMaiorQueDois);
        System.out.println(umEMaiorQueMenosUm || umEMaiorQueZero);


        // Tabela verdade ou exclusivo (xor)
        System.out.println("Tabela verdade ou exclusivo (xor) - condicao xor condicao");
        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ true);
        System.out.println(false ^ false);
        System.out.println(1 > 3 ^ umEMaiorQueDois);
        System.out.println(umEMaiorQueMenosUm ^ umEMaiorQueZero);

        // Tabela verdade da negação (not)
        System.out.println("Tabela verdade da negação (not) - condicao ou condicao");
        System.out.println(!true);
        System.out.println(!false);
        System.out.println(!umEMaiorQueZero);

    }

    @Test
    public void operadoresRelacionais() {
        System.out.println(3 > 7);
        System.out.println(3 > 2);
        System.out.println(3 >= 7);
        System.out.println(3 >= 3);
        System.out.println(4 < 4);
        System.out.println(4 <= 4);
        System.out.println(4 != 5);
        System.out.println(4 != 4);
        System.out.println(4 == 4);

    }
}

