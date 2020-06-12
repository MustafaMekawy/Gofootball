package myprogram;
// DONE
import java.util.Vector;

public class playground extends administrator
{
    private String name, address ;
    private int id ;
    private final Vector<Boolean> slot = new Vector<>();
    public int evaluation = 0 ;
    private String feedback ;
    public void set_feedback(playgroundOwner owner, playground ground ,String feedback) {
        this.feedback = feedback ;
        set_evaluation();
        if(suspend_playground(ground)) activated_playground(ground.get_id());
        if(delete_playground(ground))
        {
            owner.grounds.remove(ground) ;
        }
    }
    public String get_feedback(){return feedback ;}
    public playground(String name , String address , int free_slot , int id ) {
        this.address = address ;
        this.id = id ;
        this.name = name ;
        set_slot(free_slot);
    }
    public void set_location(String location){this.address = location ; }
    public playground(){}
    public int get_slots(){return slot.size() ;}
    public void set_name(String name) {   this.name = name ;}
    public void set_id(int id ) {   this.id = id ;}
    public String get_name() {   return name ;}
    public String get_address() {   return address ;}
    public int get_id() {    return id ;}
    public int get_busy_slot()
    {
        int free=0 ;
        for (int j=0 ; j<slot.size(); j++)
            if (!slot.elementAt(j)) free++;
        return free;}
    public void set_free_slot(int free_slot)
    {
        int last_size = get_slots() , i;
        slot.clear();
        for (i=0 ; i<(last_size-free_slot); i++)
            slot.add(true);
        for (int j=i ; j<last_size ; j++)
            slot.add(false) ;
    }
    public void set_evaluation()
    {
        if (get_feedback().equalsIgnoreCase("bad"))
            this.evaluation ++ ;
        if (get_feedback().equalsIgnoreCase("CHEATING") || feedback.equalsIgnoreCase("TRICKED") )
            this.evaluation+=5 ;
    }
    public void set_slot(int number)
    {
        for (int i=0 ; i<number ; i++)
            slot.add(true);
    }
    public int get_evaluation(){return evaluation;}
}
