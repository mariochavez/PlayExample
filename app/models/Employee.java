package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Employee extends Model {
    public String name;
    public String address;

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
