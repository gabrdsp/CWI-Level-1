package mercadodabola.Clube;

import java.math.BigDecimal;

public class Clube {
    private String nome;
    private int reputacaoHistorica;
    private BigDecimal saldoDisponivel;

    public Clube(String nome, int reputacaoHistorica, BigDecimal saldoDisponivel) {
        this.nome = nome;
        this.reputacaoHistorica = reputacaoHistorica;
        this.saldoDisponivel = saldoDisponivel;
    }

    public String getNome() {
        return nome;
    }

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }

    public BigDecimal getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void atualizarSaldo(BigDecimal novoSaldo) {
        this.saldoDisponivel = novoSaldo;
    }
}