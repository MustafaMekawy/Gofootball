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
    /**
     * this function to set feedback to playground
     *
     */
    public void set_feedback(playgroundOwner owner, playground ground ,String feedback) {
        this.feedback = feedback ;
        set_evaluation();
        if(suspend_playground(ground)) activated_playground(ground.get_id());
        if(delete_playground(ground))
        {
            owner.grounds.remove(ground) ;
        }
    }
    /**
     * this function to get feedback
     *
     */
    public String get_feedback(){return feedback ;}
    public playground(String name , String address , int free_slot , int id ) {
        this.address = address ;
        this.id = id ;
        this.name = name ;
        set_slot(free_slot);
    }
    /**
     * this function to set location
     *
     */
    public void set_location(String location){this.address = location ; }
    public playground(){}
    /**
     * this function to get slots
     *
     */
    public int get_slots(){return slot.size() ;}
    /**
     * this function to set name
     *
     */
    public void set_name(String name) {   this.name = name ;}
    /**
     * this function to set id
     *
     */
    public void set_id(int id ) {   this.id = id ;}
    /**
     * this function to get name
     *
     */
    public String get_name() {   return name ;}
    /**
     * this function to get address
     *
     */
    public String get_address() {   return address ;}
    /**
     * this function to get id
     *
     */
    public int get_id() {    return id ;}
    /**
     * this function get busy slot
     *
     */
    public int get_busy_slot()
    {
        int free=0 ;
        for (int j=0 ; j<slot.size(); j++)
            if (!slot.elementAt(j)) free++;
        return free;}
    /**
     * this function to set free slots
     *
     */
    public void set_free_slot(int free_slot)
    {
        int last_size = get_slots() , i;
        slot.clear();
        for (i=0 ; i<(last_size-free_slot); i++)
            slot.add(true);
        for (int j=i ; j<last_size ; j++)
            slot.add(false) ;
    }
    /**
     * this function to set evaluation
     *
     */
    public void set_evaluation()
    {
        if (get_feedback().equalsIgnoreCase("bad"))
            this.evaluation ++ ;
        if (get_feedback().equalsIgnoreCase("CHEATING") || feedback.equalsIgnoreCase("TRICKED") )
            this.evaluation+=5 ;
    }
    /**
     * this function to set slot
     *
     */
    public void set_slot(int number)
    {
        for (int i=0 ; i<number ; i++)
            slot.add(true);
    }
    /**
     * this function get evaluation
     *
     */
    public int get_evaluation(){return evaluation;}
}
