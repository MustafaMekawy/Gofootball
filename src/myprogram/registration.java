package myprogram;
// DONE
import java.util.Vector;

public class registration extends player
{
    private String name , password , email , location ;
    private int id , phone ;
    public void set_name (String name ) { this.name = name ; }
    public String get_name () { return  name ;}
    public void set_password (String password ) { this.password = password; }
    public String get_password () { return  password ;}
    public void set_email (String email ) { this.email = email ; }
    public String get_email() {return email ;}
    public void set_location (String location ) { this.location = location ;}
    public String get_location () { return location ;}
    public void set_id (int id ) { this.id = id ; }
    public int get_id () { return id ;}
    public void set_phone (int phone ) { this.phone = phone  ; }
    public int get_phone () {return phone ;}
}
