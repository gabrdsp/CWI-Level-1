package Pilotos;

import Militares.Militares;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pilotos extends Militares {
    private LocalDate dataValidadeLicenca;

    public Pilotos(BigDecimal valorSalario, LocalDate dataValidadeLicenca) {
        super(valorSalario);
        this.dataValidadeLicenca = dataValidadeLicenca;
    }

    public LocalDate getDataValidadeLicenca() {
        return dataValidadeLicenca;
    }
}
