package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import models.*;

public class ClientsApi extends Controller {
    public static void indexJson() {
        List<Client> clients = Client.find("order by id").fetch();

        renderJSON(clients);
    }

    public static void indexXml() {
        List<Client> clients = Client.find("order by id").fetch();

        render(clients);
    }
}
