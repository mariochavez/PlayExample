package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import play.data.validation.*;
import play.i18n.Messages;

public class Clients extends Controller {

    public static void index() {
        List<Client> clients = Client.find("order by id").fetch();

        render(clients);
    }

    public static void newClient() {
        Client client = new Client();
        render(client);
    }

    public static void create(@Valid Client client) {
        if(validation.hasErrors()) {
            flash.put("error", Messages.get("error.message"));
            render("Clients/newClient.html", client);
        }

        client.save();

        flash.put("notice", Messages.get("client.created", client.name));
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

    public static void update(Client client) {
        client.save();

        flash.put("notice", "El cliente " + client.name + " ha sido actualizado");
        show(client.id);
    }

    public static void destroy(Long id)
    {
        Client client = Client.findById(id);
        client.delete();

        index();
    }
}

