package com.duung.model;


import java.util.ArrayList;

public class ListCustomer {
    private ArrayList<Customer> customer;

    public ListCustomer() {
        customer=new ArrayList<>();
    }
    public void addCustomer(Customer c)
    {
        customer.add(c);
    }

    public ArrayList<Customer> getCustomers() {
        return customer;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customer = customers;
    }
    public void generate_sample_dataset()
    {
        addCustomer(new Customer(1,"Quan","quan@gmail.com","0703875114","quan","123"));
        addCustomer((new Customer(2, "Ty","ty@gmail.com","0703875115","ty","123")));
        addCustomer((new Customer(3, "Ti","ti@gmail.com","0703875116","ti","123")));
        addCustomer((new Customer(4, "Teo","teo@gmail.com","0703875117","teo","123")));
        addCustomer((new Customer(5, "Thai","thai@gmail.com","0703875118","thai","123")));
        addCustomer((new Customer(6, "Thi","thi@gmail.com","0703875119","thi","123")));
        addCustomer((new Customer(7, "Dung","Dung@gmail.com","0703875117","dung","123")));
        addCustomer((new Customer(8, "hoa","hoa@gmail.com","0703875111","hoa","123")));
        addCustomer((new Customer(9, "lan","lan@gmail.com","0703875121","lan","123")));
        addCustomer((new Customer(10, "Mai","mai@gmail.com","0703875122","Mai","123")));
    }
}
