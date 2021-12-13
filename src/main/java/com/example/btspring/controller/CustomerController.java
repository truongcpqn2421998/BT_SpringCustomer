package com.example.btspring.controller;

import com.example.btspring.model.Address;
import com.example.btspring.model.Customer;
import com.example.btspring.service.address.IAddressService;
import com.example.btspring.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IAddressService addressService;

    @ModelAttribute("addressList")
    public Iterable<Address>addresses(){
        return addressService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("customerhome");
        Iterable<Customer> customers=customerService.findAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }


    @PostMapping("/create")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Customer>>list(){
        return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> showEdit(@PathVariable Long id){
        return new ResponseEntity<>(customerService.findById(id).get(),HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Customer> Edit(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
