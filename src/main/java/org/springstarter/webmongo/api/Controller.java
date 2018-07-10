package org.springstarter.webmongo.api;

import com.google.gson.Gson;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springstarter.webmongo.model.Animal;
import org.springstarter.webmongo.service.AnimalService;

import java.util.List;

@RestController
@RequestMapping
public class Controller {
    private static Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private AnimalService animalService;


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Animal.class),
            @ApiResponse(code = 500, message = "Failure - Unexpected exception")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "The name of the animal", required = true, dataType = "string", paramType = "path")
    })

    @GetMapping(value = "/animal/{name}", produces = "application/json")
    public ResponseEntity<String> getAnimal(@PathVariable String name) {
        try {
            String result = new Gson().toJson(animalService.findByName(name));
            return ResponseEntity.ok(result);
        } catch (Exception exception) {
            LOGGER.error("There was an error calling /animal/{name} " + name, exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{}");
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Animal.class, responseContainer  = "List"),
            @ApiResponse(code = 500, message = "Failure - Unexpected exception")})

    @GetMapping(value = "/animals", produces = "application/json")
    public ResponseEntity<String> getAllAnimals() {
        try {
            String result = new Gson().toJson(animalService.findAllAnimals());
            return ResponseEntity.ok(result);
        } catch (Exception exception) {
            LOGGER.error("There was an error calling /animals", exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{}");
        }
    }
}
