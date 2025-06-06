package it.epicode.U5_W1_D1_Pratica.bean;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Prodotto {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private double prezzo;
    private int calorie;

}
