package myprogram;
// done
import java.util.Scanner;
import java.util.Vector;

public class playgroundOwner extends user
{
    private float money ;
    public playground ground = new playground();
    public Vector<playground> grounds = new Vector<>();
    public playgroundOwner(String name , String password , String address , int phone , String email )
    {
        set_name(name); set_location(address);
        set_email(email) ;
        set_phone(phone) ;
        set_password(password);
    }
    public playgroundOwner(){}
    /**
     * this function to add playground
     *
     */
    public void add_playground(playgroundOwner playgroundOwner)
    {
        System.out.println("please enter your playground name ");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println("please enter your playground address ");
        String address = input.next();
        System.out.println("please enter your playground id ");
        int id= input.nextInt();
        System.out.println("please enter your playground free slot ");
        int free_slot= input.nextInt();
        ground = new playground(name,address,free_slot,id);
        playgroundOwner.grounds.add(ground) ;
    }
    /**
     * this function to update playground
     *
     */
    public boolean update_playground_information(playgroundOwner playgroundOwner)
    {
        System.out.println("please enter your playground id");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        for (int i=0 ; i<playgroundOwner.grounds.size() ; i++)
        {
            if (playgroundOwner.grounds.elementAt(i).get_id()==id)
            {
                System.out.println("correct id \nplease enter your playground new name ");
                String name = input.next();
                System.out.println("please enter your playground new address ");
                String address = input.next();
                System.out.println("please enter your playground new free slot ");
                float free_slot= input.nextFloat();
                playgroundOwner.grounds.elementAt(i).set_name(name);
                playgroundOwner.grounds.elementAt(i).set_location(address);
                playgroundOwner.grounds.elementAt(i).set_free_slot((int)free_slot);
                return true ; }
        }
        return false ;
    }
    /**
     * this function set change hours
     *
     */
    public void set_change_hours(playgroundOwner playgroundOwner )
    {
        Scanner input = new Scanner(System.in);
        int i;
        boolean check = false;
        int id = input.nextInt();
        for (i=0 ; i< playgroundOwner.grounds.size() ; i++)
        {
            if(id == playgroundOwner.grounds.elementAt(i).get_id())
            {
                check = true ;
                System.out.println("correct id \n for this ground , reset your slots ");
                int hours = input.nextInt() ;
                playgroundOwner.grounds.elementAt(i).set_slot(hours);
                break;
            }
        }
        if(!check) System.out.println("you entered wrong id ");
    }
    /**
     * this function view his booking
     *
     */
    public void view_his_booking(playgroundOwner playgroundOwner )
    {
        for (int i=0 ; i<playgroundOwner.grounds.size() ; i++)
        {
            int free = playgroundOwner.grounds.elementAt(i).get_slots()-playgroundOwner.grounds.elementAt(i).get_busy_slot() ;
            System.out.println(" for ground "+playgroundOwner.grounds.elementAt(i).get_id()+ " number of slots is "
                    + playgroundOwner.grounds.elementAt(i).get_slots());
            System.out.println(" number of free slots is "+ free);
        }
        if (playgroundOwner.grounds.isEmpty())
            System.out.println("you don't have any ground to display ");
    }
    /**
     * this function to set money
     *
     */
    public void set_money(float money){this.money = money ;}
    /**
     * this function get money
     *
     */
    public float get_money(){return money ;}
}