package com.example.btspring.formatter;

import com.example.btspring.model.Address;
import com.example.btspring.service.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class AddressFormatter implements Formatter<Address> {
    private IAddressService addressService;
    @Autowired
    public AddressFormatter(IAddressService addressService) {
        this.addressService = addressService;
    }
    @Override
    public Address parse(String text, Locale locale) throws ParseException {
        Optional<Address> address = addressService.findById(Long.parseLong(text));
        return address.orElse(null);
    }

    @Override
    public String print(Address object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
