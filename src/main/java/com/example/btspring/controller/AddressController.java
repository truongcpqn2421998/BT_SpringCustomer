package com.example.btspring.controller;

import com.example.btspring.model.Address;
import com.example.btspring.model.Customer;
import com.example.btspring.service.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @GetMapping("/list")
    private ResponseEntity<Iterable<Address>> findAllAdress(){
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Address> showEdit(@PathVariable Long id){
        return new ResponseEntity<>(addressService.findById(id).get(),HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Customer> Edit(@RequestBody Address address){
        addressService.save(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        addressService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
