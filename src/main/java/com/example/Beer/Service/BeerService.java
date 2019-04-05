package com.example.Beer.Service;

import com.example.Beer.Entity.Beer;
import com.example.Beer.Reopsitory.BeerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by LAMA ALOSAIMY on 3/17/19 at 7:47 PM.
 */
@Service
public class BeerService {

    private static Logger LOG = LoggerFactory.getLogger(BeerService.class);

    private static BeerRepository beerRepository;

    @Autowired
    public void setBeerRepository(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public Optional<Beer> getBeer(int id) {
        LOG.info("Getting the Beer with given id:" + id);

        return beerRepository.findById(id);
//        return beerRepository.findOne(id);
    }

    public  Beer saveBeer(Beer beer) {
        Beer BeerToSave;
        try {
            LOG.info("Saving Beer...");
            BeerToSave = beerRepository.save(beer);
            return BeerToSave;
        } catch (Exception e) {
            LOG.error("An error occurred during Beer saving:" + e.getMessage());
        }
        return new Beer();
    }

    public  Beer updateBeer(Beer BeerToUpdate, int id) {
        Beer foundBeer = beerRepository.getOne(id);
        try {
            foundBeer.setName(BeerToUpdate.getName());


            return beerRepository.save(foundBeer);
        } catch (Exception e) {
            LOG.error("An error occurred during update of Beer" + e.getMessage());
        }
        return BeerToUpdate;
    }

    public  void deleteBeer(int id) {
        try {
            beerRepository.deleteById(id);
        } catch (Exception e) {
            LOG.error("An error occurred during deleting of Beer:" + e.getMessage());
        }
    }

    public List<Beer> getAllBeer() {
        return beerRepository.findAll();
    }
}

