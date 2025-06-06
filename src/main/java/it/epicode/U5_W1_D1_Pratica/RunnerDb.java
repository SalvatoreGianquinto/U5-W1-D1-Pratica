package it.epicode.U5_W1_D1_Pratica;

import it.epicode.U5_W1_D1_Pratica.bean.Drink;
import it.epicode.U5_W1_D1_Pratica.bean.Pizza;
import it.epicode.U5_W1_D1_Pratica.bean.Topping;
import it.epicode.U5_W1_D1_Pratica.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class RunnerDb implements CommandLineRunner {

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    @Qualifier("lemonade")
    private Drink lemonade;

    @Autowired
    @Qualifier("wine")
    private Drink wine;

    @Autowired
    @Qualifier("water")
    private Drink water;

    @Autowired
    @Qualifier("tomato")
    private Topping tomato;

    @Autowired
    @Qualifier("mozzarella")
    private Topping mozzarella;

    @Autowired
    @Qualifier("ham")
    private Topping ham;

    @Autowired
    @Qualifier("margherita")
    private Pizza margherita;

    @Autowired
    @Qualifier("hawaiianPizza")
    private Pizza hawaiianPizza;

    @Override
    public void run(String... args) throws Exception {

        prodottoRepository.save(lemonade);
        prodottoRepository.save(water);
        prodottoRepository.save(wine);

        prodottoRepository.save(margherita);
        prodottoRepository.save(hawaiianPizza);

        mozzarella.setPizze(List.of(margherita, hawaiianPizza));
        tomato.setPizze(List.of(margherita, hawaiianPizza));
        ham.setPizze(List.of(hawaiianPizza));

        prodottoRepository.save(mozzarella);
        prodottoRepository.save(tomato);
        prodottoRepository.save(ham);

    }
}
