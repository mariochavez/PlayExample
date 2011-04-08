package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Client extends Model {
    public String name;
    public String address;
    public String classification;

    @OneToMany(mappedBy="client", cascade=CascadeType.ALL)
    public List<Product> products;

    public Client(String name, String address, String
            classification) {
        this.name = name;
        this.address = address;
        this.classification = classification;
        this.products = new ArrayList<Product>();
    }
    
    public Client addProduct(String name, String category) {
        Product product = new Product(name, category, this).save();
        this.products.add(product);
        this.save();
        return this;
    }
}
