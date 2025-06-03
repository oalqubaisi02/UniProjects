/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemarketplace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CustomerService implements ICustomerService {

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the header line
                }

                String[] customerData = line.split(",");

                int id = Integer.parseInt(customerData[0]);
                String name = customerData[1];
                String email = customerData[2];
                String address = customerData[3];

                Customer customer = new Customer(id, name, email, address, null);
                customerList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

}
