package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import notifiers.*;

import play.data.validation.*;
import play.i18n.Messages;

@Check("admin")
@With(Secure.class)
public class Clients extends Controller {

    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            renderArgs.put("user", "mario@mail.com");
        }
    }

    public static void index() {
        List<Client> clients = Client.find("order by id").fetch();
        Logger.info("Cargando clientes: %d", clients.size());

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

        ClientNotifier.welcome(client);
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

