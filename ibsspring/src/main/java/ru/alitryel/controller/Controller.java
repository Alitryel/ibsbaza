package ru.alitryel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel=PetModel.getInstance();
    private static  final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json", produces ="/application/json" )
    public void createPet(@RequestBody Pet pet){
        petModel.add(pet, newId.getAndIncrement());
    }
    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll(){
        return petModel.getAll();
    }
    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
 public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.getFrontList(id.get("id"));
    }
    @DeleteMapping(value = "/deletePet",consumes = "application/json",produces ="application/json")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        return ResponseEntity.ok().build(); }

    @PutMapping(value="/putPet",consumes = "application/json",produces ="application/json")
    public ResponseEntity<Void> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return ResponseEntity.ok().build(); }
}
