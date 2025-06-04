package it.epicode.U5_W1_D1_Pratica;

import it.epicode.U5_W1_D1_Pratica.bean.*;
import it.epicode.U5_W1_D1_Pratica.enumerations.StatoTavolo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class U5W1D1PraticaApplicationTests {

	private static AnnotationConfigApplicationContext ctx;

	@BeforeAll
	public static void creaContesto() {
		ctx = new AnnotationConfigApplicationContext(U5W1D1PraticaApplication.class);
	}
//
//	@BeforeEach
//	public void primaDelTest() {
//		System.out.println("inizio test");
//	}
//
//
//	@Test
//	public void verificaCostoCopertoTavolo1() {
//		Tavolo t1 = ctx.getBean("t1", Tavolo.class);
//		Assertions.assertEquals(3, t1.getCostoCoperto());
//	}
//
//	@Test
//	public void verificaNumeroPizzeEDrinks() {
//		Menu menu = ctx.getBean(Menu.class);
//		long count = menu.getPizze().stream().count();
//		long count2 = menu.getDrinks().stream().count();
//
//		Assertions.assertAll(
//				() -> Assertions.assertEquals(3, count),
//				() -> Assertions.assertEquals(3, count2)
//		);
//	}
//
//	@AfterEach
//	public void DopoIlTest() {
//		System.out.println("fine test");
//	}
//
//	@AfterAll
//	public static void chiudiContest() {
//		ctx.close();
//	}
//
//	@ParameterizedTest
//	@ValueSource(strings = {"tomato", "mozzarella", "salami"})
//	public void verificaBeanEsistenti(String topping) {
//
//		Menu menu = ctx.getBean(Menu.class);
//		boolean exist = menu.getToppings().stream().anyMatch(toppings -> toppings.getNome().equalsIgnoreCase(topping));
//		Assertions.assertTrue(exist);
//	}
//
//	@ParameterizedTest
//	@CsvSource({"tomato, 1", "mozzarella, 1", "salami, 1"})
//	public void verificaToppingMenu(String topping, int atteso) {
//
//		Menu menu = ctx.getBean(Menu.class);
//		long count = menu.getToppings().stream().filter(toppings -> toppings.getNome().equalsIgnoreCase(topping)).count();
//		Assertions.assertEquals(atteso, count);
//	}

	// ESERCIZIO 04/06/025

	// Test 1
	@Test
	public void statoInizialeTavoloT1Test() {
		Tavolo t1 = ctx.getBean("t1", Tavolo.class);

		Assertions.assertEquals(StatoTavolo.OCCUPATO, t1.getStatoTavolo());
	}

	// Test 2
	@Test
	public void verificaNumeroMaxCopertiTavolo2() {
		Tavolo t2 = ctx.getBean("t2", Tavolo.class);
		Assertions.assertEquals(4, t2.getNumeroMaxCoperti());
	}

	// Test 3
	@Test
	public void tuttiIDrinkCostanoPiuDiZero(){
		Menu menu = ctx.getBean(Menu.class);
		boolean tuttiPrezziMaggioriDiZero = menu.getDrinks().stream().allMatch(drink -> drink.getPrezzo() > 0);
		Assertions.assertTrue(tuttiPrezziMaggioriDiZero);
	}

	// Test 4
	@Test
	void verificaCalorieDrinkAlcolici() {
		Menu menu = ctx.getBean(Menu.class);

		boolean calorieSuperioriA500 = menu.getDrinks().stream()
				.filter(d -> d.getTipoDrink().name().equalsIgnoreCase("ALCOLICO"))
				.allMatch(d -> d.getCalorie() > 500);

		Assertions.assertTrue(calorieSuperioriA500);
	}

	// Test 5 Parametrizzato
	@ParameterizedTest
	@CsvSource({"t1, 6", "t2, 4"})
	void verificaNumeroMaxCopertiTavoli(String beanName, int copertiAttesi) {
		Tavolo tavolo = ctx.getBean(beanName, Tavolo.class);
		Assertions.assertEquals(copertiAttesi, tavolo.getNumeroMaxCoperti());
	}

}
