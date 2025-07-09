package mercadodabola.Negociacao;

import mercadodabola.Clube.Clube;
import mercadodabola.Jogador.Jogador;
import java.math.BigDecimal;

public class Negociacao {
    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse) {
        // RN20: Para verificar se há interesse no clube
        if (!jogadorDeInteresse.temInteresse(clubeInteressado)) {
            return false;
        }

        // RN06: Calcula valor real de compra por tipo
        BigDecimal valorCompra = jogadorDeInteresse.calcularValorCompra();

        // RN21: Verifica se clube tem saldo
        if (clubeInteressado.getSaldoDisponivel().compareTo(valorCompra) < 0) {
            return false;
        }

        // RN22 e RN23: Realiza a transferência e atualiza o saldo
        jogadorDeInteresse.transferirClube(clubeInteressado);
        clubeInteressado.atualizarSaldo(clubeInteressado.getSaldoDisponivel().subtract(valorCompra));
        return true;
    }
}
