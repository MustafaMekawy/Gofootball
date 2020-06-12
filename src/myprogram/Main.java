package myprogram;
// done
import java.util.Scanner;
import java.util.Vector;

public class Main
{
    public static void main(String[] args)
    {
        Vector<playgroundOwner> owners = new Vector<>();
        Vector<player> players = new Vector<>() ;

        System.out.println("hello world this is me trying to code !");
        boolean check = true ;
        user my_users = new user() ;

        player player = new player("maryam","1010","maryam@gmail.com","egypt",20180274,112233);
        player player2 = new player("fatma","2020","fatma1@gmail.com","egypt",20180194,445566);
        player player3 = new player("mustafa","1516","mustafa@gmail.com","egypt",20180337,467123);

        player3.set_wallet(123456.5f);
        player2.set_wallet(1500);
        player.set_wallet(1000);

        playgroundOwner playgroundOwner = new playgroundOwner("mohammed","22","egypt",
                852852,"mohammed@gmail.com");
        playgroundOwner playgroundOwner2 = new playgroundOwner("ahmed","33","egypt",545545,
                "ahmed222@gmail.com");

        playgroundOwner.set_money(100);
        playgroundOwner2.set_money(200);

        players.add(player);
        owners.add(playgroundOwner);

        players.add(player2) ;
        owners.add(playgroundOwner2);
        players.add(player3) ;

        do
        {
            System.out.println("  Login -> 1 \n  Create new profile -> 2 \n   Exit -> 3 ");
            Scanner input = new Scanner(System.in);
            int choose = input.nextInt() ;
            if (choose==1)
            {
                System.out.println("enter your name & password");
                String name = input.next();
                String password = input.next();
                login person = new login(owners, players ,name,password);
            }
            else if (choose==2)
            {
                System.out.println(" You want to register as \n" + " 1- player \n" + " 2- playground owner" ) ;
                int choose2 = input.nextInt() ;
                if(choose2==1)
                {
                    player newPlayer = new player();
                    System.out.println("enter your name ");String name = input.next();
                    System.out.println("enter your email ");String email = input.next();
                    newPlayer.set_email(email);
                    System.out.println("enter your password ");String password = input.next();
                    System.out.println("enter your location area ");String location = input.next();
                    System.out.println("enter your id ");int id = input.nextInt();
                    System.out.println("enter your phone ");int phone = input.nextInt();

                    newPlayer = new player(name,password,email,location,id,phone);
                    players.add(newPlayer);
                    my_users.player_options(newPlayer , players , owners);
                }
                else if(choose2==2)
                {
                    playgroundOwner owner = new playgroundOwner() ;
                    System.out.println("enter your name ");String name = input.next();
                    System.out.println("enter your email ");String email = input.next();
                    owner.set_email(email);
                    System.out.println("enter your password ");String password = input.next();
                    System.out.println("enter your location area ");String location = input.next();
                    System.out.println("enter your phone ");int phone = input.nextInt();

                    owner = new playgroundOwner(name , password ,location , phone , email);
                    owners.add(owner);
                    my_users.owner_options(  owner , owners);
                }
                else System.out.println("********** WRONG **********");
            }
            else if (choose==3)
                check=false;
        }while (check);
    }
}
