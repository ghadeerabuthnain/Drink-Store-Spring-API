package com.example.Beer.Reopsitory;

import com.example.Beer.Entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LAMA ALOSAIMY on 3/17/19 at 7:46 PM.
 */
@Repository
public interface BeerRepository extends JpaRepository<Beer, Integer> {

}
