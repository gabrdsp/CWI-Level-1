package mercadodabola.Jogador;

import mercadodabola.ApetiteFinanceiro.ApetiteFin;
import mercadodabola.Clube.Clube;

import java.math.BigDecimal;

/**
 * Representa um atacante com acréscimo por gols e desconto por idade.
 */
public class Atacante extends Jogador {
    private final int gols;
    private static final BigDecimal ACRESCIMO_POR_GOL = new BigDecimal("0.01");
    private static final BigDecimal DESCONTO_ACIMA_30 = new BigDecimal("0.75");

    public Atacante(final String nome, final int idade, final Clube clubeAtual,
                    final int reputacaoHistorica, final ApetiteFin apetiteFinanceiro,
                    final BigDecimal preco, final int gols) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.gols = gols;
    }

    @Override
    public boolean temInteresse(final Clube clube) {
        return clube.getReputacaoHistorica() > getReputacaoHistorica();
    }

    @Override
    public BigDecimal calcularValorCompra() {
        final BigDecimal base = super.calcularValorCompra();
        final BigDecimal acrescimo = ACRESCIMO_POR_GOL.multiply(new BigDecimal(gols));
        final BigDecimal comAcrescimo = base.multiply(BigDecimal.ONE.add(acrescimo));
        if (getIdade() > 30) {
            return comAcrescimo.multiply(DESCONTO_ACIMA_30);
        }
        return comAcrescimo;
    }
}
