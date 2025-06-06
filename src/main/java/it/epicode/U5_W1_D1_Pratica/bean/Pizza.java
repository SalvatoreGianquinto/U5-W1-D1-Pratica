package it.epicode.U5_W1_D1_Pratica.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Data
@NoArgsConstructor
@ToString(callSuper = true)
//@Component // serve per IoC
@Entity
public class Pizza extends Prodotto{
//    @Autowired
    @ManyToMany(mappedBy = "pizze", fetch = FetchType.EAGER)
    private List<Topping> toppings;

//    @Autowired(required = false)
    public Pizza(List<Topping> toppings){
        this.toppings = toppings;
    }

    @Autowired(required = false)
    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
