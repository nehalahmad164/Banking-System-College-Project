import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank b1=new Bank();
        Display.clr();
        Bank.setpass();
        Display.pause();
        while(true){
        Display.clr();
        System.out.println("________________HOME________________");
        System.out.println("1. Admin Page\n2. User Page\n3. Exit");
        byte option;
            System.out.print("   Enter option: ==>");
        Scanner sc=new Scanner(System.in);
        option=sc.nextByte();
        if (option==1) {
            Display.clr();
            System.out.println("______Login to Admin Panel______");
                if (Bank.passMatch()==1){
                   byte choice=10;
                   while (choice!=1){
                       Display.clr();
                       System.out.println("________________ ADMIN WINDOW ________________");
                       choice=adminMenu();
                       switch (choice){
                         //case 1: exit using loop condition
                           case 2: b1.checkBal(); break;
                           case 3:
                               System.out.println("\n__________ Deposit __________");
                               b1.depositBal(); break;
                           case 4:
                               System.out.println("\n__________ Withdrawal __________");
                               b1.withdrawBal(); break;
                           case 5: b1.transfer(); break;
                           case 6: b1.txHistory(); break;
                           case 7: b1.createAccount(); break;
                           case 8: b1.close(); break;
                           case 9: b1.showAllAccout(); break;
                           case 10: b1.showALLDetail(); break;
                           case 11: b1.updateInformation(); break;
                           default:
                               if (choice!=1) System.out.println("\n   Wrong Option Try Again..");
                       }
                       if (choice!=1)
                       { Display.pause(); }
                   }
               }
                else {
                    System.out.println("\n   Password Not Match");
                    Display.pause(); Display.clr();
                }
        }
        else if (option==2){
            byte ch=10;
            while (ch!=1){
                Display.clr();
                System.out.println("________________ USER WINDOW ________________");
                userMenu();
                System.out.print("   Enter Option: ==>");
                 ch=sc.nextByte();
                switch (ch){
                  //case 1: for Exit through loop condition /////
                    case 2: b1.checkBal(); break;
                    case 3:
                        System.out.println("__________ Deposit __________");
                            b1.depositBal(); break;
                    case 4:
                        System.out.println("__________ Withdrawal __________");
                        b1.withdrawBal(); break;
                    case 5: b1.transfer(); break;
                    case 6: b1.txHistory(); break;
                    default:
                        if(ch!=1) System.out.println("\n   Wrong Option try again....");
                }
                if(ch!=1)
                { Display.pause(); }
            }
        }
        else if (option==3)
        {
            return;
        }
        else {
            System.out.println("\n   Wrong option");
            Display.pause();
        }
      }
    }
    public static byte adminMenu(){
        userMenu();
        System.out.println("7. OPEN NEW ACCOUNT");
        System.out.println("8. Close Account");
        System.out.println("9. Show All Account");
        System.out.println("10.Chek All Detail of Account");
        System.out.println("11.Update Account Details");
        byte option;
        Scanner sc=new Scanner(System.in);
        System.out.print("   Enter Choise: ==>");
        option=sc.nextByte();
        return option;
    }
    public static void userMenu(){
        //Display.clr();
        System.out.println("1. Back to Home");
        System.out.println("2. Check balance");
        System.out.println("3. Deposite Amount");
        System.out.println("4. Widthdrow Amount");
        System.out.println("5. Transfer Amount");
        System.out.println("6. Check Account History");
    }
 }