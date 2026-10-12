/*--------------------------------------------
Program 6: MPLS Dog Management System
	
    [REPLACE MY INFORMATION WITH YOURS]
    Course: COMP 170, Spring I 2023
    System: Visual Studio Code, Windows 10
    Author: C. Fulton
*/

import java.util.Scanner; //Importing Scanner Class
public class DogManagement {
    static class Dog {
        // our Product class
        // stores information on our product including the name 
        // and the prices 
        public String name;
        public int weight;
        public int age;
        public int ID;
        public void print(){

            System.out.printf("\tID : %d\n", this.ID);
            System.out.printf("\tname : %s\n", this.name);
            System.out.printf("\tweight : %d\n",this.weight);
            System.out.printf("\tage :%d\n",this.age);

        }
        public Dog (String name,  int weight,int age,int ID){
            this.name  = name ;
            this.weight = weight;
            this.age = age;
            this.ID = ID;
        }
    }
    /*
     * Global Declaration for parallel arrays and Scanner Object
     */
    //DECLARING PARALEL ARRAYS OUTSIDE OF MAIN METHOD TO HOLD DOG DATA use the static keyword



    //Welcome method that outputs introductory text explaining program
    public static void welcome(){
        System.out.println("Welcome, this program allows for a care attendant to be able to create, retrieve and update a dog record from the system.");
    }

    //Method to display prompt and return integer values
    public static int displayPrompt(){
        //Local Variables
        int menuOption;

        System.out.println("\nSelect a menu option:");
        System.out.println("\t1) Create a dog record");
        System.out.println("\t2) Display dog record");
        System.out.println("\t3) Update dog record");
        System.out.println("\t4) Exit Program");

        System.out.print("Enter selection here --> ");
        //INPUT
        menuOption = Integer.parseInt(scn.nextLine());

        return menuOption;
    }
    public static int getID(){
        Scanner dogID = new Scanner(System.in);
        System.out.println("Enter the ID");
        int ID = Integer.parseInt(dogID.nextLine());
        return ID;

    }
    public static Dog[] create(Dog[] dogdatabase){
        int ID = getID();


        // name 
        Scanner dog = new Scanner(System.in);
        System.out.println("Enter the dog name");
        String name = dog.nextLine();
        // age
        Scanner dogage = new Scanner(System.in);
        System.out.println("Enter the age");
        int age = Integer.parseInt(dogage.nextLine());
        // weight 
        Scanner dogweight = new Scanner(System.in);
        System.out.println("Enter the weight");
        int weight = Integer.parseInt(dogweight.nextLine());

        Dog dogdata = new Dog(name,weight,age,ID);

        dogdata.print();
        dogdatabase[ID] = dogdata;
        return dogdatabase;
    }

    public static void update(Dog[] dogdatabase){
        int ID = getID();
        if(dogdatabase[ID] == null) {
            System.err.println("Invalid dog ID");
            System.exit(0);
        }

        Dog dogupdate = dogdatabase[ID];

        // name
        Scanner dog = new Scanner(System.in);
        System.out.println("Enter the new/same dog name");
        String name = dog.nextLine();
        dogupdate.name = name;

        // age
        Scanner dogage = new Scanner(System.in);
        System.out.println("Enter the new/same age");
        int age = Integer.parseInt(dogage.nextLine());
        dogupdate.age = age;
        // weight
        Scanner dogweight = new Scanner(System.in);
        System.out.println("Enter the new/same weight");
        int weight = Integer.parseInt(dogweight.nextLine());
        dogupdate.weight = weight;

        dogupdate.print();
    }
    //DECLARING SCANNER OBJECT
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
       public static void main(String[] args) {
  
  //CSV = Comma-Separated Values 
  //   text file that uses a comma to separate values
  
    //CSV file name
    String fileName = "dogdatabase.csv";
    BufferedReader br = null;
    String line = "";
    
    Try {
        br = new BufferedReader(new FileReader(fileName));
        while ((line = br.readLine()) != null) {
            String[] dogdata = line.split(",");
            Dog dog = new Dog(dogdata[0], Integer.parseInt(dogdata[1]), Integer.parseInt(dogdata[2]), Integer.parseInt(dogdata[3]));
            dog.print();
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
        //Local Variables
        int menuOption;
        Dog[] dogdatabase = new Dog[100];

        //Welcome Method Call
        welcome();

        //Menu Loop
        do{
            menuOption = displayPrompt();
            switch(menuOption){
                case 1:
                    dogdatabase = create(dogdatabase);
                    break;
                case 2:
                    int ID = getID();
                    if(dogdatabase[ID] == null) {
                        System.err.println("Invalid dog ID");
                        System.exit(0);
                    }
                    dogdatabase[ID].print();
                    break;
                case 3:
                    update(dogdatabase);
                    break;
                case 4:
                    System.out.println("Exiting Program");
                    break;
                default:
                    System.err.println("Invalid menu option");
            }
        }while(menuOption != 4);
    }
        

      



    
