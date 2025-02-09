package com.springbootacademy.batch7.pos.controller;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch7.pos.service.CustomerService;
import com.springbootacademy.batch7.pos.service.impl.CustomerServiceIMPL;
import com.springbootacademy.batch7.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 

public class CustomerController {


    @Autowired
    private CustomerService customerService;   //property injection


    @PostMapping("/save ")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {

        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {

        customerService.updateCustomer(customerUpdateDTO);
        return "updated";

       /* String msg =   customerService.updateCustomer(customerUpdateDTO);
        return msg;*/
    }

     @GetMapping(
             path = "/get-by-id",
             params = "id"
     )

    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){

        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return  customerDTO;

        /* System.out.println("Print Value" + customerId);
         return null;*/
     }

    /* @GetMapping(
             path = "/get-all-customers"
     )
    public List<CustomerDTO> getAllCustomers() {

        List <CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
     }*/

    @GetMapping(
            path = "/get-all-customers"
    )
    public ResponseEntity<StandardResponse> getAllCustomers() {

        List <CustomerDTO> allCustomers = customerService.getAllCustomers();
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(201 , "Success", allCustomers), HttpStatus.OK
        );
    }


     @DeleteMapping(
             path = "delete-customer/{id}"
     )

    public String deleteCustomer(@PathVariable (value = "id") int customerId) {

        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
     }

    @GetMapping(
            path = "/get-all-customers-by-active-state/{status}"
    )
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState) {
        List <CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }






















        /*String message = customerDTO.getCustomerName();
        System.out.println("COME" + message);

        CustomerServiceIMPL customerServiceIMPL = new CustomerServiceIMPL();
        ustomerServiceIMPL.saveCustomer(customerDTO);*/





















   /* @PostMapping("/save-2") //link eke unique kara
    public String saveCustomerx(){

        String message = "Savedd";
        return message;
    }*/
}
