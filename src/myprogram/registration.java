package myprogram;
// DONE
import java.util.Vector;

public class registration extends player
{
    private String name , password , email , location ;
    private int id , phone ;
    /**
     * this function set name
     *
     */
    public void set_name (String name ) { this.name = name ; }
    /**
     * this function to get name
     *
     */
    public String get_name () { return  name ;}
    /**
     * this function to set password
     *
     */
    public void set_password (String password ) { this.password = password; }
    /**
     * this function to get password
     *
     */
    public String get_password () { return  password ;}
    /**
     * this function to set email
     *
     */
    public void set_email (String email ) { this.email = email ; }
    /**
     * this function to get email
     *
     */
    public String get_email() {return email ;}
    /**
     * this function to set location
     *
     */
    public void set_location (String location ) { this.location = location ;}
    /**
     * this function to get location
     *
     */
    public String get_location () { return location ;}
    /**
     * this function to set id
     *
     */
    public void set_id (int id ) { this.id = id ; }
    /**
     * this function to get id
     *
     */
    public int get_id () { return id ;}
    /**
     * this function to set phone
     *
     */
    public void set_phone (int phone ) { this.phone = phone  ; }
    /**
     * this function to get phone
     *
     */
    public int get_phone () {return phone ;}
}