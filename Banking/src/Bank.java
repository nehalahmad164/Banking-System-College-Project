import java.util.Scanner;

public class Bank {
    //////////////////////// manage account   list
    Account head = null, tail = null;
    static String userId,password;

        public static void setpass(){
            Scanner sc=new Scanner(System.in);
            System.out.println("_______________CREATE USER-ID & PASSWORD FOR BANK MANAGEMENT_______________");
            System.out.print(" ENTER USER-ID:  =>: ");
            userId=sc.nextLine();
            System.out.print(" ENTER PASSWORD: =>: ");
            password=sc.nextLine();
            System.out.println("\n   [ ID & Password Created Sucess. \n \t Now You can Open Account for User]");
        }
    public static int passMatch(){
        String pas;
        Scanner sc=new Scanner(System.in);
        System.out.print("   Enter password =>: ");
        pas=sc.nextLine();
        return (pas.equals(password) ? 1 : 0);
    }
    ///////////////////////////// take account number from user ////////////////
    private long takeAccNo() {
        long acNo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account No: ");
        acNo = sc.nextLong();
        return acNo;
    }
    /////////////////////////// Search account number is exist or not /////////////////
    private Account search(long acno){
            Account temp=head;
            if(head==null){
            //System.out.println("No account");
            return temp;
        }
        while (temp!=null){
            if(temp.matchAcc(acno)==true)
            {
                break;
            }
            temp=temp.next;
        }
        return temp;
    }
    ///////////////////////////////////// print update message  /////////////////////
    private void updateMsg()
    { System.out.println("   Update Sucessfull"); }
/////////////////////********************* ADMIN Method ***************************/////////////////////////////////////////

    /////////////////////////// Account Create ///////////////////////////////////
    public void createAccount() {
        System.out.println("\n________ Account Opening Form __________");
        Account newAccount = new Account();
        newAccount.openAccount();
        System.out.print("Enter Account Opening Amount: ");
        float amount=newAccount.takeBalance();
        newAccount.history="Name: "+newAccount.name+",     Acc. No. :"+newAccount.accountNo+"\n";
        newAccount.history+="Account Opening Bal. : +";
        newAccount.deposit(amount);
        if (head == null) {
            head = newAccount;
            tail = newAccount;
        }
        else {
            tail.next = newAccount;
            newAccount.prev = tail;
            tail = newAccount;
        }
        Display.clr();
        System.out.println("______ Account Created Sucess please Save these Information For Future Use______\n");
        newAccount.showAccountINFO();
        System.out.println("-------------------------------------------------------------------------");
    }
    /////////////////////////           Close Account    //////////////////////
    public void close(){
        long accNo=takeAccNo();
        Account temp=search(accNo);
        Account closeAcc;
        if (temp!=null){
            if (temp.prev==null && temp.next==null){
                head=null;
            }
            else if (temp.prev==null){
                closeAcc=temp;
                head=temp.next;
                head.prev=null;  // head.prev=null; or  head.prev=temp.prev;
                temp.next=null;
                System.out.println("\n______ Account Closed ______");
                closeAcc.showAccountINFO();
                System.out.println("________________________________________");
            }
            else if(temp.next==null){
                closeAcc=temp;
                temp.prev.next=temp.next;
                tail=temp.prev;
                temp.prev=null;
                System.out.println("\n______ Account Closed ______");
                closeAcc.showAccountINFO();
                System.out.println("________________________________________");
            }
            else {
                closeAcc=temp;
                temp.prev.next = temp.next;
                temp.prev.next.prev=temp.prev;
                temp.prev = null;
                temp.next = null;
                System.out.println("\n______ Account Closed ______");
                closeAcc.showAccountINFO();
                System.out.println("________________________________________");
            }
            Account.count-=1;
        }
        else {
            System.out.println("\n Provided Account No. is not Found!!");
        }
    }
    ////////////////////// show all account in bank /////////////////////
    public void showAllAccout(){
        if (head==null){
            System.out.println("   Not Avalable  Account: "+Account.count);
        }
        else {
            System.out.println("\n   Total Acoount: "+Account.count);
            Account temp=head;
            System.out.println("______________________________________");
            while (temp!=null){
                temp.showAccountINFO();
                System.out.print("\n");
                temp=temp.next;
            }
        }
    }
    ///////////////////////// update details of account //////////////////////////////
    public void updateInformation(){
        System.out.println("\n____________ Update User Information ____________\n");
        long accNO=takeAccNo();
        Account temp=search(accNO);
        if(temp!=null){
            Scanner sc=new Scanner(System.in);
            System.out.println("\n_________Chose Update Option_________");
            System.out.print("1. Name Update\n2. Update DOB \n3. Address Update\n4. Mobile Number Update  :+=>");
            byte option=sc.nextByte();
            switch (option){
                case 1: temp.setName(); updateMsg(); break;
                case 2: temp.setDOB(); updateMsg(); break;
                case 3: temp.updateAddress(); updateMsg(); break;
                case 4: temp.setMobNo(); updateMsg(); break;
                default:
                    System.out.println("   \nSome thing went wrong\n\t  Try after some time...");
            }
        }
        else {
            System.out.println("     \nProvided Account Number does not exist");
        }
    }
    /////////////////// show all detail ////////////////////
    public void showALLDetail(){
        long accNo=takeAccNo();
        Account temp=search(accNo);
        if(temp!=null){
            temp.showALLDetailsOfAccountHolder();
        }
    }
////////////////////////////********************** User Methods *******************************///////////////////////

    //////////////////////  payment deposite    ////////////////////
    public void depositBal() {
        long acNo = takeAccNo();
        Account temp = search(acNo);
        if (temp != null) {
            System.out.println("\nEnter Amount: ");
            float amount=temp.takeBalance();
            temp.history+="Deposit           : +";
            temp.deposit(amount);
            System.out.println("\nDeposit Sucess:"+amount );
        } else {
            System.out.println("   Incorrect Account number");
        }
    }
    //////////////////////   payment widthdrow    ///////////////////
    public void withdrawBal() {
        long accNo = takeAccNo();
        Account temp = search(accNo);
        if (temp != null) {
            temp.history+="withdraw          : -";
            float widthdrowAmount=temp.withdraw();
            System.out.println("\nCash Withdraw Sucess:" + widthdrowAmount);
            temp.checkBalance();
        } else {
            System.out.println("   Incorrect Account number");
        }
    }
    ////////////////////    Check Balance    ///////////////////
    public void checkBal() {
        System.out.println("\n__________ Balance Check __________");
        long accno = takeAccNo();
        Account temp = search(accno);
        if (temp != null) {
            temp.checkBalance();
        } else {
            System.out.println("\n   Account number Not found");
        }
    }
    ///////////////////    payment transfer    ///////////////////
    public void transfer() {
        System.out.println("\n_______________ Payment Transfer Form _______________");
        System.out.println("\n_____Sender Detail_____");
        long accNoSender = takeAccNo();
        Account tempSender=search(accNoSender);
         if (tempSender!=null){
             System.out.println("\n_____Receiver Detail_____");
             long accNoReceiver=takeAccNo();
             Account tempReceiver=search(accNoReceiver);
             if (tempReceiver!=null && tempReceiver != tempSender){
                 tempSender.history+="transfer to  "+tempReceiver.name+"   : -";
                 float amt=tempSender.withdraw();
                 if (tempSender.balance < amt){
                     tempReceiver.history+="Receved by   "+tempSender.name+"   : +";
                     tempReceiver.addHistory(amt);

                 }
                 else {
                     tempReceiver.history += "Receved by   " + tempSender.name + "   : +";
                     tempReceiver.history+="Faild : ";
                     tempReceiver.deposit(amt);
                 }
                 if(amt > 0 && tempSender.balance > amt) { System.out.println("\n   Transaction Successful"); }
             }
             else {
                 if (tempReceiver==tempSender){
                     System.out.println("\n   Sender and Receiver Account Number same Transaction faild");
                 }
                 else {
                     System.out.println("\n   Receiver Account Not Found!");
                 }
             }
         }
         else { System.out.println("\n   Sender Account Not Found!"); }
    }
    ///////////////     Show All Tranxaction History     //////////////////////
    public void txHistory(){
        System.out.println("__________ Check ALL Transaction History__________");
        long accNo=takeAccNo();
        Account temp=search(accNo);
        if (temp!=null) {
            System.out.println("______________________ Transaction History ______________________");
            System.out.println(temp.history);
            System.out.println("------------------------------------------------------------------");
        }
        else System.out.println("   Invalid Account Number");
    }
}