package it.epicode.U5_W1_D1_Pratica.bean;

import it.epicode.U5_W1_D1_Pratica.enumerations.StatoTavolo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tavolo {
    private int numeroTavolo;
    private int maxCoperti;
    private StatoTavolo statoTavolo;
}
