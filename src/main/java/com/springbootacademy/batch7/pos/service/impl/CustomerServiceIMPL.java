package com.springbootacademy.batch7.pos.service.impl;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch7.pos.entity.Customer;
import com.springbootacademy.batch7.pos.repo.CustomerRepo;
import com.springbootacademy.batch7.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(

//DTO ekn apu tika cutomer entity ekkt da gatta


                customerDTO.getCustomerId(),
                customerDTO.isActive(),
                customerDTO.getNic(),
                customerDTO.getContactNumber(),
                customerDTO.getCustomerSalary(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerName()

        );

        //Customer customer = new Customer();//

        customerRepo.save(customer);
        return customerDTO.getCustomerName();

        /*System.out.println(customerDTO.getCustomerAddress()); //colombo print in console in frontend postman print saved
        return customerDTO.getCustomerName();*/
    }


    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {

        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())){

            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());


            customerRepo.save(customer);


        }else {
            throw new RuntimeException("NO DATA FOUND");
        }

return "";
     }



    @Override
    public CustomerDTO getCustomerById(int customerId) {

        if (customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(


                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.getCustomerSalary(),
                    customer.isActive()
            );
            return customerDTO;

        }else {

            throw new RuntimeException("NO DATA FOUND");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> getAllCustomers = customerRepo.findAll();

        if (getAllCustomers.size()>0) {

            List<CustomerDTO> customerDTOList = new ArrayList<>();

            for (Customer customer : getAllCustomers) {
                CustomerDTO customerDTO = new CustomerDTO(

                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getContactNumber(),
                        customer.getNic(),
                        customer.getCustomerSalary(),
                        customer.isActive()
                );
                customerDTOList.add(customerDTO);
            }

            return customerDTOList;
        }else {
            throw new RuntimeException("NO CUSTOMER FOUND");
        }

    }

    @Override
    public String deleteCustomer(int customerId) {

        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);

            return "deleted vsucces" + customerId;
        }else {
            throw new RuntimeException("NO DATA FOUND");

        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {

        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(

                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.getCustomerSalary(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }

        return customerDTOList;

    }
}
