package it.epicode.U5_W1_D1_Pratica.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@NoArgsConstructor
@ToString(callSuper = true, exclude = "pizze")
@Entity
public class Topping extends Prodotto{
    private boolean glutenFree;
    @ManyToMany
    @JoinTable(name = "topping_pizza",
            joinColumns = @JoinColumn(name = "topping_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    List<Pizza> pizze;
}
