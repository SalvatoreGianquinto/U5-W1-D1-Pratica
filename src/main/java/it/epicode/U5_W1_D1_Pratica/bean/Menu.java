package it.epicode.U5_W1_D1_Pratica.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@Component
public class Menu {
    @Autowired
    private List<Pizza> pizze;
    @Autowired
    private List<Topping> toppings;
    @Autowired
    private List<Drink> drinks;

    public void stampaMenu(){
        System.out.println("MENU' DELLA PIZZERIA");

        System.out.println("PIZZE");
        for (Pizza p : pizze){
            System.out.println("- " + p.getNome() + " (€" + p.getPrezzo() + ", " + p.getCalorie() + " kcal)");
        }

        System.out.println("\n TOPPINGS:");
        for (Topping t : toppings) {
            System.out.println("- " + t.getNome() + " (€" + t.getPrezzo() + ", " + t.getCalorie() + " kcal)");
        }

        System.out.println("\n BEVANDE:");
        for (Drink d : drinks) {
            System.out.println("- " + d.getNome() + " (€" + d.getPrezzo() + ", " + d.getCalorie() + " kcal)");
        }
    }


}
