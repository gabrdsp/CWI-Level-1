package mercadodabola.ApetiteFinanceiro;

import mercadodabola.ApetiteFinanceiro.ApetiteFin;

import java.math.BigDecimal;

public class Indiferente extends ApetiteFin {
    @Override
    public BigDecimal calcular(final BigDecimal preco) {
        return preco;
    }
}
