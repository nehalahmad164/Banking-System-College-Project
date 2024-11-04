import java.util.Scanner;

public class Display {
    public static void clr(){
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    ///////////////////////////// Press Enter to Continue //////////////////////////////////////
    public static void pause(){
        System.out.print("\n                             Press [ ENTER KEY ] to Continue.....");
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
    }
}
