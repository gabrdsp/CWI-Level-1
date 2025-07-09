import org.junit.Assert;
import org.junit.Test;

public class ninjaTest {

    @Test
    public void deveInicializarChakraDoNinjaCom100() {
        Jutsu jutsu = new Jutsu(2, 5);
        Ninja ninja = new Ninja("Gabriel", jutsu);
        Assert.assertEquals(100, ninja.getChakra());

    }

    @Test
    public void deveAtualizarChakraDoNinjaAposLevarUmAtaque() {
        Jutsu jutsu = new Jutsu(5, 10);
        Ninja ninjaAtacante = new Ninja("Gabriel", jutsu);
        Ninja ninjaOponente = new Ninja("Naruto", new Jutsu(10, 10));

        int nivelEsperadoDoChakraDoninjaAtacante = 100 - jutsu.getChakraConsumido();
        ninjaAtacante.atacar(ninjaOponente);

        Assert.assertEquals(nivelEsperadoDoChakraDoninjaAtacante, ninjaAtacante.getChakra());
    }

    @Test
    public void deveAtualizarOChakraDoOponenteQuandoReceberUmGolpe() {
        Ninja ninjaGolpeado = new Ninja("Hinata", new Jutsu(10, 10));
        int danoRecebido = 20;
        int chakraEsperado = 100 - danoRecebido;

        ninjaGolpeado.receberGolpe(danoRecebido);

        Assert.assertEquals(chakraEsperado, ninjaGolpeado.getChakra());
    }

    @Test
    public void deveAtualizarOChakraDoOponenteDeAcordoComODanoDoJutsoQuandoAtacar() {

    Jutsu jutsuninjaAtacante = new Jutsu(5, 10);
    Ninja ninjaAtacante = new Ninja("Gabriel", jutsuninjaAtacante);
    Jutsu jutsuninjaOponente = new Jutsu(5, 5);
    Ninja ninjaOponente = new Ninja("Garra", jutsuninjaOponente);

    int nivelChakraEsperado = 100 - jutsuninjaAtacante.getDano();

        ninjaAtacante.atacar(ninjaOponente);

        Assert.assertEquals(nivelChakraEsperado,ninjaOponente.getChakra());
    }
}
