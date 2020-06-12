package myprogram;

import java.util.Vector;

// DONE
public class login extends verify
{
    private String name , password ;
    public login(Vector<playgroundOwner> owners , Vector<player> players , String name , String password)
    {
        if(check_login(owners, players , name , password))
        {
            this.name = name ; this.password = password ;
            System.out.println("login successfully ! congratulation!!");
            if(get_player()!= null) player_options(get_player(),players ,owners);
            else if(get_owner()!= null) owner_options(get_owner() , owners) ;
        }
        else
            System.out.println("***** YOUR NAME OR YOUR PASSWORD IS INCORRECT *****");
    }
    public void set_name(String name ) { this.name = name ;}
    public void set_password(String password ) { this.password = password ;}
    public String get_name () {  return name ;}
    public String get_password() { return password ;}
}
