package notifiers;

import models.*;
import play.*;
import play.mvc.*;
import java.util.*;

public class ClientNotifier extends Mailer {
    public static void welcome(Client client) {
        setSubject("Bienvendo %s", client.name);
        addRecipient("test@mail.com");
        setFrom("Yo <yo@mail.com>");
        send(client);
    }
}
