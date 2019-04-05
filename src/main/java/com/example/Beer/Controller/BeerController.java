package com.example.Beer.Controller;

import com.example.Beer.Service.BeerService;
import com.example.Beer.Entity.Beer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Optional;

/**
 * Created by LAMA ALOSAIMY on 3/17/19 at 8:10 PM.
 */

@RestController
@RequestMapping(path = "/beers/")
@Api(value = "BeerControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class BeerController {

    private BeerService beerService;

    private Logger LOG = LoggerFactory.getLogger(BeerController.class);

    @Autowired
    public void setBeerService(BeerService BeersService) {
        this.beerService = BeersService;
    }


    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("Gets All the Beers")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Beer.class)})
    public List<Beer> getAllBeer() {
        return beerService.getAllBeer();
    }


    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation("Gets the Beer with specific id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Beer.class)})
    public Optional<Beer> getBeer(@PathVariable(name = "id") int id) {
        return beerService.getBeer(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Beer saveBeer(@RequestBody Beer BeerToSave) {
        return beerService.saveBeer(BeerToSave);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Beer updateBeer(@RequestBody Beer BeerToUpdate, @PathVariable(name = "id") int id) {
        return beerService.updateBeer(BeerToUpdate, id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteBeer(@PathVariable(name = "id") int id) {
        beerService.deleteBeer(id);
    }
}

