package mercadodabola.Jogador;

import mercadodabola.ApetiteFinanceiro.ApetiteFin;
import mercadodabola.Clube.Clube;

import java.math.BigDecimal;

public class Lateral extends Jogador {
    private final int cruzamentosCerteiros;
    private static final BigDecimal ACRESCIMO_POR_CRUZAMENTO = new BigDecimal("0.02");
    private static final BigDecimal DESCONTO_ACIMA_28 = new BigDecimal("0.7");

    public Lateral(final String nome, final int idade, final Clube clubeAtual,
                   final int reputacaoHistorica, final ApetiteFin apetiteFinanceiro,
                   final BigDecimal preco, final int cruzamentosCerteiros) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.cruzamentosCerteiros = cruzamentosCerteiros;
    }

    @Override
    public BigDecimal calcularValorCompra() {
        final BigDecimal valorBase = super.calcularValorCompra();
        final BigDecimal acrescimo = ACRESCIMO_POR_CRUZAMENTO.multiply(new BigDecimal(cruzamentosCerteiros));
        final BigDecimal comAcrescimo = valorBase.multiply(BigDecimal.ONE.add(acrescimo));
        if (getIdade() > 28) {
            return comAcrescimo.multiply(DESCONTO_ACIMA_28);
        }
        return comAcrescimo;
    }
}
