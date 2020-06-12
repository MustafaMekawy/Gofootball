package myprogram;
// DONE

public class booking extends playgroundOwner
{
    public booking(){ }
    public void checking(playground ground , int hours)
    {
        if((ground.get_slots()-ground.get_busy_slot())>0)
            ground.set_free_slot(hours);
        else System.out.println("********** WRONG **********");
    }
    public float calculating ( float booking_time )
    { return booking_time*30 ; }
    public boolean paying(player player,float amount_of_money )
    {
        if (player.get_wallet()-amount_of_money>=0)
        {
            player.set_wallet(player.get_wallet()-amount_of_money);
            System.out.println("OPERATION DONE ");
            return true ;
        }
        System.out.println("OPERATION FAILED");
        return false ;
    }
    public boolean return_paying(player player,float amount_of_money )
    {
        set_money(get_money()-amount_of_money);
        float last_wallet = player.get_wallet() ;
        int free = ground.get_slots() ;
        player.set_wallet(last_wallet+amount_of_money);
        ground.set_free_slot( free-player.num);
        return true ;
    }
}
