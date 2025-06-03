package it.epicode.U5_W1_D1_Pratica.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
//@Component // serve per IoC
public class Pizza extends Prodotto{
//    @Autowired
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
