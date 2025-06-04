package it.epicode.U5_W1_D1_Pratica.configuration;


import it.epicode.U5_W1_D1_Pratica.bean.*;
import it.epicode.U5_W1_D1_Pratica.enumerations.StatoTavolo;
import it.epicode.U5_W1_D1_Pratica.enumerations.TipoDrink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean (name = "water")
    public Drink getWater() {
        Drink water = new Drink();
        water.setTipoDrink(TipoDrink.ANALCOLICO);
        water.setCalorie(0);
        water.setPrezzo(1);
        water.setNome("Water (0.5l)");
        return water;
    }

    @Bean(name = "lemonade")
    public Drink getLemonade() {
        Drink lemonade = new Drink();
        lemonade.setTipoDrink(TipoDrink.ANALCOLICO);
        lemonade.setCalorie(128);
        lemonade.setPrezzo(1.29);
        lemonade.setNome("Lemonade (0.33l)");
        return lemonade;

    }

    @Bean(name = "wine")
    public Drink getWine() {
        Drink wine = new Drink();
        wine.setTipoDrink(TipoDrink.ALCOLICO);
        wine.setCalorie(607);
        wine.setPrezzo(7.49);
        wine.setNome("Wine (0.75l, 13%)");
        return wine;
    }

    @Bean(name = "tomato")
    @Primary // Dai precedenza a questo bean nel caso ce ne siano più di uno dello stesso tipo
    public Topping getTomato() {
        Topping tomato = new Topping();
        tomato.setNome("tomato");
        tomato.setPrezzo(1);
        tomato.setCalorie(100);
        tomato.setGlutenFree(true);
        return tomato;
    }

    @Bean(name = "mozzarella")
    public Topping getMozzarella() {
        Topping mozzarella = new Topping();
        mozzarella.setNome("mozzarella");
        mozzarella.setPrezzo(1);
        mozzarella.setCalorie(200);
        mozzarella.setGlutenFree(true);
        return mozzarella;
    }

    @Bean(name = "Ham")
    public Topping getHam() {
        Topping ham = new Topping();
        ham.setNome("Ham");
        ham.setPrezzo(0.99);
        ham.setCalorie(92);
        ham.setGlutenFree(true);
        return ham;
    }

    @Bean(name = "onions")
    public Topping getOnions() {
        Topping onions = new Topping();
        onions.setNome("Onions");
        onions.setPrezzo(0.69);
        onions.setCalorie(22);
        onions.setGlutenFree(true);
        return onions;
    }

    @Bean(name = "pineapple")
    public Topping getPineapplea() {
        Topping pineapple = new Topping();
        pineapple.setNome("Pineapple");
        pineapple.setPrezzo(0.79);
        pineapple.setCalorie(24);
        pineapple.setGlutenFree(true);
        return pineapple;
    }

    @Bean(name = "salami")
    public Topping getSalami() {
        Topping salami = new Topping();
        salami.setNome("Salami");
        salami.setPrezzo(0.99);
        salami.setCalorie(86);
        salami.setGlutenFree(true);
        return salami;
    }

    @Bean(name = "margherita")
    public Pizza getMargherita() {
        Pizza margherita = new Pizza();
        margherita.setNome("Pizza Margherita (tomato, mozzarella)");
        margherita.setPrezzo(4.99);
        margherita.setCalorie(1104);
        return margherita;
    }

    @Bean(name = "hawaiianPizza")
    public Pizza getHawaiianPizza() {
        Pizza hawaiian = new Pizza();
        hawaiian.setNome("Hawaiian Pizza (tomato, mozzarella, ham, pineapple)");
        hawaiian.setPrezzo(6.49);
        hawaiian.setCalorie(1024);
        return hawaiian;
    }

    @Bean(name = "salamiPizza")
    public Pizza getsalamiPizza() {
        Pizza salami = new Pizza();
        salami.setNome("Salami Pizza (tomato, mozzarella, salami)");
        salami.setPrezzo(5.99);
        salami.setCalorie(1160);
        return salami;
    }

    @Bean("t1")
    public Tavolo getTavolo1(@Value("${tavolo1.coperto}") double costoCoperto){
        Tavolo t1 = new Tavolo();
        t1.setCostoCoperto(costoCoperto);
        t1.setStatoTavolo(StatoTavolo.LIBERO);
        t1.setNumero(1);
        t1.setNumeroMaxCoperti(6);
        return t1;
    }
    @Bean("t2")
    public Tavolo getTavolo2(@Value("${tavolo2.coperto}") double costoCoperto){
        Tavolo t2 = new Tavolo();
        t2.setNumero(2);
        t2.setNumeroMaxCoperti(4);
        t2.setStatoTavolo(StatoTavolo.LIBERO);
        t2.setCostoCoperto(costoCoperto);
        return t2;
    }
}
