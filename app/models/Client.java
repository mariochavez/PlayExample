package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Client extends Model {
    public String name;
    public String address;
    public String classification;

    public Client(String name, String address, String
            classification) {
        this.name = name;
        this.address = address;
        this.classification = classification;
    }
}
