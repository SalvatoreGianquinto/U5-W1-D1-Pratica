package it.epicode.U5_W1_D1_Pratica.bean;

import it.epicode.U5_W1_D1_Pratica.enumerations.StatoOrdine;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Ordine {
    private int numero;
    private StatoOrdine statoOrdine;
    private int numeroCoperti;
    private LocalDate oraAcquisizione;
    private Tavolo tavolo;
    private List<Prodotto> elementi;

    public double getTotale() {
        double totaleElementi = elementi.stream()
                .mapToDouble(Prodotto::getPrezzo)
                .sum();
        double costoCoperti = numeroCoperti * 2.0;
        return totaleElementi + costoCoperti;
    }

}
