package mercadodabola.Jogador;

import mercadodabola.ApetiteFinanceiro.ApetiteFin;
import mercadodabola.Clube.Clube;

import java.math.BigDecimal;

public class Jogador {
    private final String nome;
    private final int idade;
    private Clube clubeAtual;
    private final int reputacaoHistorica;
    private final ApetiteFin apetiteFinanceiro;
    private final BigDecimal preco;

    public Jogador(final String nome, final int idade, final Clube clubeAtual,
                   final int reputacaoHistorica, final ApetiteFin apetiteFinanceiro,
                   final BigDecimal preco) {
        this.nome = nome;
        this.idade = idade;
        this.clubeAtual = clubeAtual;
        this.reputacaoHistorica = reputacaoHistorica;
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public ApetiteFin getApetiteFinanceiro() {
        return apetiteFinanceiro;
    }

    public String getClubeAtual() {
        if (clubeAtual == null) {
            return "Sem Clube";
        }
        return clubeAtual.getNome();
    }

    public void transferirClube(final Clube novoClube) {
        this.clubeAtual = novoClube;
    }

    public boolean temInteresse(final Clube clube) {
        return clube.getReputacaoHistorica() >= 1;
    }

    public BigDecimal calcularValorCompra() {
        return apetiteFinanceiro.calcular(preco);
    }
}
