package com.project.boardgamesrental.controller;

import com.project.boardgamesrental.model.Account;
import com.project.boardgamesrental.model.Rent;
import com.project.boardgamesrental.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @PostMapping("/add")
    public void add(@RequestBody Rent rent){
        rentService.newRent(rent, rent.getClientId());
    }

    @GetMapping("/getAll")
    public List<Rent> getAllRents(){
        return rentService.getAllRents();
    }

    @DeleteMapping("/delete")
    public String deleteRent(@RequestBody Rent rent){
        rentService.deleteRent(rent.getId());
        return "Rent deleted";
    }

    @PatchMapping("/updateRentReturnDate")
    public String updateRentReturnDate(@RequestBody Rent rent){
        Date newReturnDate = rent.getReturnDate();
        rentService.updateRentReturnDate(rent.getId(), newReturnDate);

        return "Rent's return date updated!";
    }
}
