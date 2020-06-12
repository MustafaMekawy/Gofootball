package myprogram;

import java.util.Scanner;
import java.util.Vector;

public class team
{
    public void set_favourite_team(player player , Vector <player> players )
    {
        System.out.println("enter player id you want to add to your team ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        if (player.get_id() != id) {
            for (int i = 0; i < players.size(); i++) {
                if (players.elementAt(i).get_id() == (id)) {
                    player.my_team.add(players.elementAt(i));
                    send_invitation(player, players.elementAt(i));
                    System.out.println("OPERATION DONE ");
                    return;
                }
            }
        }
        System.out.println("id is incorrect \n OPERATION FAILED ");
    }
    public void send_invitation(player player , player player2)
    {
        player2.set_email_content("player "+player.get_id()+" is sending this mail for you \n" +
                " please accept my invitation to pe in my team ");
    }
    public boolean modify_team (player player , Vector<player> players)
    {
        if(player.my_team.isEmpty())
        {
            System.out.println("You do not have any team yet");
            return false;
        }
        else
        {
            System.out.println("enter player id you want to remove");
            Scanner input = new Scanner(System.in);
            int id = input.nextInt() ;
            for (int i = 0; i < players.size(); i++)
            {
                if (players.elementAt(i).get_id()==(id))
                {
                    player.my_team.remove(players.elementAt(i));
                    System.out.println("OPERATION DONE ");
                    return true ;
                }
            }
            System.out.println("name is incorrect \n OPERATION FAILED ");
        }
        return false ;
    }
}
