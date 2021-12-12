package com.example.btspring.controller.api;

import com.example.btspring.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;



}
