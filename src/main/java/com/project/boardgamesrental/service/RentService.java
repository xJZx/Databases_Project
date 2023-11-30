package com.project.boardgamesrental.service;

import com.project.boardgamesrental.model.Rent;

import java.util.Date;
import java.util.List;

public interface RentService {
    public Rent newRent(Rent rent, Integer accountId);
    public List<Rent> getAllRents();
    public void updateRentReturnDate(Integer rentId, Date newDate);
    public void deleteRent(Integer rentId);
}
