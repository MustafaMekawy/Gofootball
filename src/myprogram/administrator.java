package myprogram;
// DONE
import java.util.Vector;

public class administrator
{
    public Vector<playground> grounds = new Vector<>() ;
    public Vector<playground> suspended_grounds = new Vector<>() ;
    public boolean activated_playground(int id)
    {
        for(int i=0 ; i<suspended_grounds.size() ; i++)
        {
            if (suspended_grounds.elementAt(i).get_id()==id)
            {
                playground ground ;
                ground = suspended_grounds.elementAt(i) ;
                ground.evaluation = 0 ;
                grounds.add(ground);
                suspended_grounds.remove(i);
                System.out.println("THIS IS THE LAST CHANCE FOR THIS GROUND");
                return true ;
            }
        }
        return false;
    }
    public boolean suspend_playground(playground ground)
    {
        if (ground.get_evaluation()==1) {
            suspended_grounds.add(ground);
            ground.grounds.remove(ground);
            System.out.println("THIS GROUND is PAUSED");
            return true ;
        }
        return false ;
    }
    public boolean delete_playground(playground ground)
    {
        if (ground.get_evaluation()>=2) {
            grounds.remove(ground);
            System.out.println("SAY GOODBYE FOR THIS GROUND");
            return true;
        }
        return false ;
    }

}