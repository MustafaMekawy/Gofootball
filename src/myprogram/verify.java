package myprogram;

import java.util.Vector;

public class verify extends user
{
    public player player ;
    public playgroundOwner playgroundOwner ;
    public boolean check_login (Vector<playgroundOwner> owners , Vector<player> players , String name , String password)
    {
        for(int i=0 ; i<owners.size() ; i++)
        {
            String my_name = owners.elementAt(i).get_name() , my_pass = owners.elementAt(i).get_password();
            if (my_name.equalsIgnoreCase(name))
                if (my_pass.equals(password)) {
                    playgroundOwner=(owners.elementAt(i));
                    return true ;
                }
        }
        for(int i=0 ; i<players.size() ; i++)
        {
            if(players.elementAt(i).get_name().equals(name) )
                if(players.elementAt(i).get_password().equals(password))
                {
                    player = (players.elementAt(i));
                    return true ;
                }
        }
        return false ;
    }
    public playgroundOwner get_owner(){
        return playgroundOwner ;
    }
    public player get_player(){
        return player;
    }

}
