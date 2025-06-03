/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemarketplace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ProductService implements IProductService {

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the header line
                }

                String[] productData = line.split(",");

                int id = Integer.parseInt(productData[0]);
                String name = productData[1];
                String description = productData[2];
                double price = Double.parseDouble(productData[3]);
                int quantity = Integer.parseInt(productData[4]);

                Product product = new Product(id, name, description, price, quantity);
                productList.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void writeProducts(List<Product> productList) {
        String filePath = "products.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            // Write the header line
            String header = "Id,Name,Description,Price,Quantity";
            writer.write(header);
            writer.newLine();
            // Clear the existing content in the file
            for (Product product : productList) {
                String line = product.getProductId() + "," + product.getName() + "," + product.getDescription() + ","
                        + product.getPrice() + "," + product.getQuantityAvailable();

                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> search(String productName, List<Product> products) {
        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }

}
