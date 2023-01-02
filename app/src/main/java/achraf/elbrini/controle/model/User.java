package achraf.elbrini.controle.model;

import java.io.Serializable;

public class User implements Serializable {
    public int id;
    public String name,email,pass;
    public boolean isAuthentificated;

    public User(int id, String email, String pass) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        isAuthentificated=false;

    }
    public User( String email, String pass) {
        this.pass = pass;
        this.email = email;
        this.name="inconnu";
        isAuthentificated=false;

    }
}
