package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;
    private static int size = 1;
    static {
        products = new HashMap<>();
        products.put(size++, new Product(1, "Iphone7", "4.7in", "iphone", 1));
        products.put(size++, new Product(2, "Iphone8", "5.5in", "iphone", 1));
        products.put(size++, new Product(3, "IphoneX", "4.7in", "iphone", 1));
        products.put(size++, new Product(4, "Iphone11", "4.7in", "iphone", 1));
        products.put(size++, new Product(5, "Iphone11 max", "6.3in", "iphone", 1));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void add(Product product) {
        products.put(size++, product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public ArrayList<Product> findByName(String name) {
        ArrayList<Product> list=new ArrayList<>(products.values());
        ArrayList<Product> productArrayList=new ArrayList<>();
        for (Product product : list){
            if (product.getName().equals(name)){
                productArrayList.add(product);
            }
        }
        return productArrayList;
    }
}

