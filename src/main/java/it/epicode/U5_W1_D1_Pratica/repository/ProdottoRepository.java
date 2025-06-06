package it.epicode.U5_W1_D1_Pratica.repository;

import it.epicode.U5_W1_D1_Pratica.bean.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {

    List<Prodotto> findByCalorieGreaterThan(int calorie);

    List<Prodotto> findByNomeLike(String nome);
}
