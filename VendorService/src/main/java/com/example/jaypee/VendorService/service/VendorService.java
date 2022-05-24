package com.example.jaypee.VendorService.service;

import com.example.jaypee.VendorService.domain.Vendor;
import com.example.jaypee.VendorService.exception.VendorAlreadyExistException;
import com.example.jaypee.VendorService.exception.VendorNotFoundException;

public interface VendorService {

    public Vendor saveVendorDetails(Vendor vendor) throws VendorAlreadyExistException;
    public Vendor editVendorDetails(Vendor vendor,String email) throws VendorNotFoundException;
    public Vendor getVendorByVendorEmail(String email);
}
