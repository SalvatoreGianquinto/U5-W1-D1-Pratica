package it.epicode.U5_W1_D1_Pratica;

import it.epicode.U5_W1_D1_Pratica.bean.Menu;
import it.epicode.U5_W1_D1_Pratica.bean.Ordine;
import it.epicode.U5_W1_D1_Pratica.bean.Tavolo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component // serve per permettere a Spring di gestire completamente la classe
// tutte le classi con component vengono istanziate direttamente da Spring e gli oggetti creati vengono salvati nel contesto
@Order(1) // deve essere il primo runner a essere lanciato
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D1PraticaApplication.class);

        Menu menu = ctx.getBean(Menu.class);
        menu.stampaMenu();

        Tavolo tavolo1 = ctx.getBean(Tavolo.class);

        Ordine ordine = ctx.getBean(Ordine.class);

        System.out.println("\n=== ORDINE ===");
        System.out.println("Numero ordine: " + ordine.getNumero());
        System.out.println("Stato ordine: " + ordine.getStatoOrdine());
        System.out.println("Tavolo: " + ordine.getTavolo().getNumeroTavolo());
        System.out.println("Numero coperti: " + ordine.getNumeroCoperti());
        System.out.println("Ora acquisizione: " + ordine.getOraAcquisizione());
        System.out.println("Elementi ordine:");
        ordine.getElementi().forEach(e ->
                System.out.println(" - " + e.getNome() + " | Prezzo: €" + e.getPrezzo()));
        System.out.println("Totale: €" + ordine.getTotale());

    }
}
