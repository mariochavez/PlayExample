package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import play.i18n.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void changeES() {
        Lang.change("es");

        flash.put("notice", Messages.get("language.change"));
        index();
    }

    public static void changeEN() {
        Lang.change("en");

        flash.put("notice", Messages.get("language.change"));
        index();
    }
}
