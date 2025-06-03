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
public class SellerService implements ISellerService {

    @Override
    public List<Seller> getAllSellers() {
        List<Seller> sellerList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("sellers.txt"))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the header line
                }

                String[] sellerData = line.split(",");

                int id = Integer.parseInt(sellerData[0]);
                String name = sellerData[1];
                String email = sellerData[2];
                String address = sellerData[3];

                Seller seller = new Seller(id, name, email, address);
                sellerList.add(seller);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sellerList;
    }

}
