package myprogram;

import java.util.Scanner;
import java.util.Vector;

public class user
{
    private String name , password , email , location ;
    private int id , phone ;
    public user() { }
    public void player_options( player newPlayer , Vector<player> players , Vector <playgroundOwner> owners)
    {
        int choose2;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Choose Your Option \n create booking -> 1 \n cancel booking -> 2 \n edit profile information -> 3");
            System.out.println(" add money to your eWallet -> 4 \n write your feed back -> 5");
            System.out.println(" check money -> 6 \n set your favorite team -> 7 \n modify your team -> 8 \n" +
            " check invitations -> 9 \n Exit -> 10 ");
            choose2 = input.nextInt();
            if (choose2 == 1) {
                System.out.println("existed grounds ");
                for (int i = 0; i < owners.size(); i++)
                {
                    for (int j=0 ; j<owners.elementAt(i).grounds.size() ; j++)
                    {
                        System.out.println("i = "+i+"ground number "+j+
                                " ground id "+ owners.elementAt(i).grounds.elementAt(j).get_id()
                                + " ground location " + owners.elementAt(i).grounds.elementAt(j).get_address());
                    }
                }
                if (newPlayer.create_booking(newPlayer , owners)) System.out.println("YOUR OPERATION IS DONE WITHOUT ANY WRONG");
            }
            else if (choose2 == 2) newPlayer.cancel_booking(newPlayer);
            else if (choose2 == 3) newPlayer.edit_profile_information();
            else if (choose2 == 4) {
                System.out.println("HOW MANY POUNDS DO YOU WANT TO ADD");
                float new_money = input.nextFloat();
                newPlayer.set_wallet(newPlayer.get_wallet() + new_money);
            }
            else if (choose2 == 5) {
                boolean check = false ;
                System.out.println("enter playground id you want to talk about ");
                int id = input.nextInt();
                for (int i = 0; i < owners.size(); i++)
                {
                    for (int j = 0; j < owners.elementAt(i).grounds.size(); j++)
                        if (owners.elementAt(i).grounds.elementAt(j).get_id() == id) {
                            System.out.println("enter your feed back \n     write GOOD , BAD , TRICKED or CHEATING ");
                            String feedBack = input.next();
                            owners.elementAt(i).grounds.elementAt(i).set_feedback( owners.elementAt(i),
                                    owners.elementAt(i).grounds.elementAt(j), feedBack);
                            System.out.println("OPERATION DONE ");
                            check = true ;
                            break;
                        }
                    if(check) break;
                }
            }
            else if (choose2 == 6) System.out.println(newPlayer.get_wallet());
            else if (choose2 == 7) {
                System.out.println("your team has "+newPlayer.my_team.size()+" persons");
                newPlayer.set_team(newPlayer,players);
            }
            else if (choose2 == 8) newPlayer.modify_team(newPlayer, players);
            else if (choose2 == 9) {
                System.out.println( newPlayer.get_Email_content() );
                System.out.println(" to accept this invitation press 1");
                int accept = input.nextInt();
                newPlayer.accepted(accept) ;
            }
            else if (choose2!=10) System.out.println("********** WRONG **********");
        }while (choose2!=10);
    }
    public void owner_options(playgroundOwner owner , Vector <playgroundOwner> owners)
    {
        Scanner input = new Scanner(System.in);
        int choose2 ;
        owners.add(owner);
        do {
            System.out.println("Choose Your Option \n add playground -> 1 \n update playground information -> 2 ");
            System.out.println(" set and change hours -> 3 \n view your bookings -> 4 ");
            System.out.println(" add money to your eWallet -> 5 \n check money -> 6 \n Exit -> 7");
            choose2 = input.nextInt();
            if (choose2 == 1) owner.add_playground(owner);
            else if (choose2 == 2) owner.update_playground_information(owner);
            else if (choose2 == 3) {
                System.out.println("enter playground id");
                owner.set_change_hours(owner);
            }
            else if (choose2 == 4) owner.view_his_booking(owner);
            else if (choose2 == 5) {
                System.out.println("HOW MANY POUNDS DO YOU WANT TO ADD");
                float new_money = input.nextFloat();
                owner.set_money(owner.get_money() + new_money);
            }
            else if (choose2 == 6) System.out.println(owner.get_money());
            else if (choose2!=7)System.out.println("********** WRONG **********");
        }while (choose2!=7);
    }
    public void set_name (String name ) { this.name = name ; }
    public String get_name () { return  name ;}
    public void set_password (String password ) { this.password = password;}
    public String get_password () { return  password ;}
    public void set_email (String email ) {
        this.email = email;
        String my_email = get_email();
        if (my_email.contains("."))
            if (my_email.contains("@")) {
                System.out.println("your email syntax is correct");
            } else {
                Scanner input = new Scanner(System.in);
                System.out.println("your email syntax is incorrect \n please try again ");
                String new_email = input.nextLine();
                set_email(new_email);
            }
    }
    public String get_email() {return email ;}
    public void set_location (String location ) { this.location = location ;}
    public String get_location () { return location ;}
    public void set_id (int id ) { this.id = id ; }
    public int get_id () { return id ;}
    public void set_phone (int phone ) { this.phone = phone  ; }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
