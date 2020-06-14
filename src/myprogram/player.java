package myprogram;
// DONE
import java.util.Scanner;
import java.util.Vector;

public class player extends user
{
    public booking my_booking = new booking();
    private int hours=10 ;
    public Vector <myprogram.booking> booking = new Vector<>();
    public int  num;
    public team team = new team();
    private float money ;
    private String email_content ;
    public Vector<player> my_team = new Vector<>() ;
    public player(){}
    public player(String name , String password , String email , String location , int id , int phone)
    {
        set_name(name);
        set_password(password);
        set_email(email);
        set_id(id);
        set_location(location);
        set_phone(phone);
    }
    /**
     * this function to create a booking
     *
     */
    public boolean create_booking(player newPlayer ,Vector<playgroundOwner> owners)
    {
        if(hours>0)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("enter ground id ");
            int id = input.nextInt();
            for (int i = 0; i < owners.size(); i++)
            {
                for (int j=0 ; j<owners.elementAt(i).grounds.size() ; j++)
                    if(owners.elementAt(i).grounds.elementAt(j).get_id()==id)
                    {
                        System.out.println("enter number of hours you want to book ");
                        num = input.nextInt();
                        if ((hours - num ) > 0 || (hours - num )== 0)
                        {
                            newPlayer.my_booking.checking(owners.elementAt(i).grounds.elementAt(j), num) ;
                            float cal = newPlayer.my_booking.calculating(num);
                            System.out.print("this will cost you "+ cal);
                            System.out.println("$ . do you want to continue ? \n press 1 for yes ");
                            int choose = input.nextInt();
                            if (choose == 1)
                            {
                                if(newPlayer.my_booking.paying(newPlayer, cal))
                                {
                                    owners.elementAt(i).grounds.elementAt(j).set_free_slot(num);
                                    owners.elementAt(i).set_money(owners.elementAt(i).get_money() + cal);
                                    my_booking.ground = owners.elementAt(i).grounds.elementAt(j);
                                    hours = hours - num;
                                    booking.add(newPlayer.my_booking);
                                    return true;
                                }
                            }
                        }
                    }
            }return false;
        }
        else System.out.println("your number of booking is the maximum number"); return false ;
    }
    /**
     * this function to cancel booking
     *
     */
    public void cancel_booking(player newPlayer)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter playground id ");
        int ground_id = input.nextInt();
        for (int i=0 ; i<booking.size() ; i++)
        {
            if(newPlayer.booking.elementAt(i).ground.get_id()== ground_id)
            {
                System.out.println("correct id \n OPERATION IS BEING DONE ...");
                float new_money = newPlayer.booking.elementAt(i).calculating(newPlayer.num);
                newPlayer.booking.elementAt(i).return_paying(newPlayer,new_money) ;
                newPlayer.booking.remove(i);
                newPlayer.hours++;
                System.out.println(" OPERATION DONE ");
                return;
            }
        }
        System.out.println(" OPERATION FAILED ");
    }
    /**
     * this function to edit profile information
     *
     */
    public void edit_profile_information()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name ");
        String name = input.next();
        set_name(name);
        System.out.println("Enter your address ");
        String address = input.next();
        set_location(address);
        System.out.println("Enter your phone ");
        int phone = input.nextInt();
        set_phone(phone);
        System.out.println("Enter your email ");
        String email = input.next();
        set_email(email);
        System.out.println("Enter your password ");
        String password = input.next();
        set_password(password);
    }
    /**
     * this function to set team
     *
     */
    public void set_team(player player , Vector<player> players)
    {
        System.out.println(players.elementAt(0).get_name()+players.elementAt(1).
                get_name()+players.elementAt(2).get_name());
        player.team.set_favourite_team(player,players) ;
    }
    /**
     * this function to modify team
     *
     */
    public boolean modify_team(player player , Vector <player> players)
    {
        if(player.team.modify_team(player , players)){
            System.out.println("OPERATION DONE ");
            return true ;}

        else System.out.println("OPERATION FAILED ");
        return false ;
    }
    /**
     * this function to accepted
     *
     */
    public boolean accepted(int accept) { return accept == 1; }
    /**
     * this function to set wallet
     *
     */
    public void set_wallet(float money){ this.money = money ;}
    /**
     * this function to get wallet
     *
     */
    public float get_wallet(){ return money ;}
    /**
     * this function to set email content
     *
     */
    public void set_email_content(String email_content){this.email_content = email_content ;}
    /**
     * this function to get email content
     *
     */
    public String get_Email_content(){return email_content ;}
}