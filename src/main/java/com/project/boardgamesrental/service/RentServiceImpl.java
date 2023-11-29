package com.project.boardgamesrental.service;

import com.project.boardgamesrental.model.Rent;
import com.project.boardgamesrental.repository.RentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentServiceImpl implements RentService{

    @Autowired
    private RentRepository rentRepository;

    @Override
    public Rent newRent(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    @Override
    public void updateRentReturnDate(Integer rentId, Date newDate) {
        Optional<Rent> currentRent = rentRepository.findById(rentId);

        if (currentRent.isPresent()) {
            Rent rent = currentRent.get();
            rent.setReturnDate(newDate);
            rentRepository.save(rent);
        }
        else {
            throw new EntityNotFoundException("Entity not found with id: " + rentId);
        }
    }

    @Override
    public void deleteRent(Integer rentId) {
        rentRepository.deleteById(rentId);
    }
}
