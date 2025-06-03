package it.epicode.U5_W1_D1_Pratica.bean;

import it.epicode.U5_W1_D1_Pratica.enumerations.TipoDrink;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Drink extends Prodotto{
    private TipoDrink tipoDrink;
}
