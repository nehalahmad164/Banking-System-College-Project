import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;

public class Account extends Person {
    ////////// create account  [ node ]
    long accountNo=44220;
    static int accNo=0;
    float balance;
    String history;
    final String ifscCode="Mini-1234";
    static int count=0;
    Account next,prev;
    //////////////////////////////// Show Account Info /////////////////////////
    public void showAccountINFO(){
          System.out.println("Name        : "+this.name);
          System.out.println("Acc. no     : "+this.accountNo);
          System.out.println("IFSC-Code   : "+ifscCode);
          System.out.println("Adhar       : "+this.adhar);
          System.out.println("Mob. no     : "+this.mobNo);
          this.checkBalance();
    }
    public boolean matchAcc(long ac){
        if (this.accountNo==ac){
            return true;
        }
        else return false;
    }
    protected float takeBalance(){
        float amount;
        Scanner sc=new Scanner(System.in);
        amount=sc.nextFloat();
        return amount;
    }
    public void openAccount(){
        setPersonDetails();
        Account.count+=1;
        Account.accNo+=1;
        this.accountNo=accountNo+accNo;
        next=null;
        prev=null;
    }
    protected void addHistory(float amount){
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter myFormate=DateTimeFormatter.ofPattern("'Date:- [ 'dd-MM-yyyy' ]  Time:- [ 'HH:mm a' ]'");
        String actualDate=date.format(myFormate);
        this.history+=amount+"   "+" Avl Bal INR= "+this.balance+"-   "+actualDate+"\n";
    }
    public void deposit(float depositeAmount){
        if(depositeAmount > 0){
            this.balance += depositeAmount;
            this.addHistory(depositeAmount);
        }
        else
        {
            System.out.println("     Amount Not Acceptable");
            this.history+="Faild : ";
            this.addHistory(depositeAmount);
        }
    }
    public float withdraw() {
        float widthdrowAmount;
        System.out.println("\nEnter  Amount: ");
        widthdrowAmount = takeBalance();
        if (widthdrowAmount > 0 && widthdrowAmount < this.balance) {
            this.balance -= widthdrowAmount;
            this.addHistory(widthdrowAmount);
        }
        else {
            System.out.println("Invalid amount  ::transaction faild !!!");
            history+="Faild : ";
            addHistory(widthdrowAmount);
        }
        return widthdrowAmount;
    }
    public void checkBalance(){
        System.out.println("Aval Balance: "+this.balance+"");
    }
    public void showALLDetailsOfAccountHolder(){
        System.out.println("\n______________ All Details ______________");
        System.out.println("Acc no    : "+this.accountNo);
        this.showPersonDetails();
    }
}