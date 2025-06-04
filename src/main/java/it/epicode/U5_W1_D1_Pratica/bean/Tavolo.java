package it.epicode.U5_W1_D1_Pratica.bean;

import it.epicode.U5_W1_D1_Pratica.enumerations.StatoTavolo;


import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Tavolo {
    private int numero;
    private int numeroMaxCoperti;
    private StatoTavolo statoTavolo;
    private double costoCoperto;
}
