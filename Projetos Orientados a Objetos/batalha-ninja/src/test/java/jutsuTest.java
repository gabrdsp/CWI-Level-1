import org.junit.Assert;
import org.junit.Test;

public class jutsuTest {

    @Test
    public void deveLimitarOChakraConsumidoAoMaximoPermitido() {

        Jutsu jutsu = new Jutsu(10, 5);
        Assert.assertEquals(5, jutsu.getChakraConsumido());

    }

    @Test
    public void deveLimitarODanoAoMaximoPermitido() {

        Jutsu jutsu = new Jutsu(3, 15);
        Assert.assertEquals(10, jutsu.getDano());

    }

    @Test
    public void deveAtribuirODanoCorretamente() {
        Jutsu jutsu = new Jutsu(3, 7);
        Assert.assertEquals(7, jutsu.getDano());
    }


}
