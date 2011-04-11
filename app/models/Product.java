package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class Product extends Model {
    @Required
    public String name;
    public String category;

    @ManyToOne
    public Client client;

    public Product(String name, String category, Client client) {
        this.name = name;
        this.category = category;
        this.client = client;
    }
}

