import java.util.Scanner;

public class PersonDOB {
    private int date,month,year;
    public void setDOB() {
        Scanner sc = new Scanner(System.in);
        System.out.print("  Enter Date:-");
        date=sc.nextInt();
        System.out.print("  Enter Month:-");
        month=sc.nextInt();
        System.out.print("  Enter Year:-");
        year=sc.nextInt();
    }
    public void getDOB(){
        System.out.println(date+"-"+month+"-"+year);
    }
}
