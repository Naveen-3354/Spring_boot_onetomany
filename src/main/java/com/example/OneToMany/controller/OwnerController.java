package com.example.OneToMany.controller;

import com.example.OneToMany.model.Cars;
import com.example.OneToMany.model.Owner;
import com.example.OneToMany.repository.CarsRepository;
import com.example.OneToMany.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CarsRepository carsRepository;

    @PostMapping("/saveOwner")
    public Owner saveOwner(@RequestBody Owner owner) {
        System.out.println("Owner save called...");

        Owner ownerIn = new Owner();
        ownerIn.setEmail(owner.getEmail());
        ownerIn.setName(owner.getName());

        List<Cars> cars = new ArrayList<>();
        for (Cars x : owner.getCarsList()) {
            Cars car = new Cars();
            car.setBrand(x.getBrand());
            car.setVersion(x.getVersion());
            car.setColor(x.getColor());
            car.setOwner(ownerIn);

            cars.add(car);
        }
        ownerIn.setCarsList(cars);
        return ownerRepository.save(ownerIn);
    }

    @PostMapping("/saveCars")
    public String saveBlog(@RequestParam(name = "id") int id, @RequestBody Cars... carsIn) {

        Owner ownerTemp = ownerRepository.findById(id).get();

        List<Cars> cars = new ArrayList<>();
        for (Cars x : carsIn) {
            Cars car = new Cars();
            car.setBrand(x.getBrand());
            car.setVersion(x.getVersion());
            car.setColor(x.getColor());
            car.setOwner(ownerTemp);
            cars.add(car);
        }
        ownerTemp.setCarsList(cars);
        ownerRepository.save(ownerTemp);
        return "Blog saved!!!";
    }

    @GetMapping("/getOwner/{id}")
    public Owner getOwner(@PathVariable(name = "id") int id) {
        Owner ownerOut = ownerRepository.findById(id).get();
        return ownerOut;
    }

    @GetMapping("/getBlog/{id}")
    public Cars getBlog(@PathVariable(name = "id") int id) {
        return carsRepository.findById(id).get();
    }
}
