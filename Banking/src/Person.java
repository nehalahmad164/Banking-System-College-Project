import java.util.Scanner;

public class Person extends PersonDOB {
    String name,gender,dist,state;
    long adhar,mobNo,pincode;
    private String genderSet(){
        byte option;
        Scanner sc=new Scanner(System.in);
        System.out.println("_______Select Gender_____");
        System.out.print("   1. Male\n   2. Femail\n   3. Other\n   4. Not Say  :=");
        option=sc.nextByte();
        switch (option){
            case 1: return "Male";
            case 2: return "Femail";
            case 3: return "Other";
            default: return "Not Say";
        }
       /* if(option==1) { return "Male"; }
        else if (option==2) { return "Femail"; } ///  we can use this type also ///
        else if (option==3) { return "Other"; }
        else { return "Not Say"; }
       */
    }
    protected void setPersonDetails(){
        Scanner sc=new Scanner(System.in);
        this.setName();
        System.out.println("---Set Date of Birth---"); this.setDOB();
        System.out.print("Enter Adhar no: ");
        this.adhar=sc.nextLong();
        // System.out.print("Enter Gender: ");
        this.gender=genderSet();
        this.setAddress();
    }
    public void setAddress(){
         updateAddress();
         setMobNo();
    }
    protected void updateAddress(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Dist: ");
        this.dist=sc.nextLine().toUpperCase();
        System.out.print("Enter State: ");
        this.state=sc.nextLine().toUpperCase();
        System.out.print("Enter Pin Code: ");
        this.pincode=sc.nextLong();
    }
    public void showPersonDetails(){
        System.out.println("Name      : "+name);
        System.out.print("D.O.B     : "); getDOB();
        System.out.println("Gender    : "+gender);
        System.out.println("Adhar no  : "+adhar);
        System.out.println("Dist      : "+dist);
        System.out.println("State     : "+state);
        System.out.println("Pin Code  : "+pincode);
        System.out.println("Mobile no : "+mobNo);
    }
    protected void setName(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Name: ");
        this.name=sc.nextLine().toUpperCase();
    }
    protected void setMobNo(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Mob no: ");
        this.mobNo=sc.nextLong();
    }
}
