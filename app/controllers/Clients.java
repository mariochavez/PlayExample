package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Clients extends Controller {

    public static void index() {
        List<Client> clients = Client.find("order by id").fetch();
        render(clients);
    }

    public static void newClient() {
        Client client = new Client();
        render(client);
    }

    public static void create(String name, String address, String classification) {
        Client client =  new Client(name, address, classification);
        client.save();

        show(client.id);
    }

    public static void show(Long id) {
        Client client = Client.findById(id);

        render(client);
    }

    public static void edit(Long id) {
        Client client = Client.findById(id);

        render(client);
    }

    public static void update(Long id, String name, String address, String classification) {
        Client client = Client.findById(id);
        client.name = name;
        client.address = address;
        client.classification = classification;
        client.save();

        show(client.id);
    }
}

