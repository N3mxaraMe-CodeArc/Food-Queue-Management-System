package com.example.w198756920223294;

import javafx.application.Application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {

    static FoodQueue Queue1 = new FoodQueue(2);
    static FoodQueue Queue2 = new FoodQueue(3);
    static FoodQueue Queue3 = new FoodQueue(5);
    ArrayList<Customer> waiting = new ArrayList<>();

//    static String[] Queue1 = new String[2];
//    static String[] Queue2 = new String[3];
//    static String[] Queue3 = new String[5];
    String customerName = "";

    static int cashierCustomers1 = 0;
    static int cashierCustomers2 = 0;
    static int cashierCustomers3 = 0;
    static int totalCustomers = 0;

    static int maxBurgers = 50;
    static int SoldBurgers = 0;
//    static final int MaxCashierCustomers1 = 2;
//    static final int MaxCashierCustomers2 = 3;
//    static final int MaxCashierCustomers3 = 5;
//    static final int maxCustomers = 10;

    public static void main(String[] args) {

        System.out.println(System.lineSeparator() + "Methods Of the food fav ");
        System.out.println("===========*****============" + System.lineSeparator());

        //calling to menu method from main method
        Main mainprogram = new Main();
        mainprogram.foodoptions();


        while (true) {
            //Calling an input to continue
            Scanner route = new Scanner(System.in);
            System.out.print("Input the method number to continue : ");
            String inputMenu = route.nextLine().toUpperCase();


            switch (inputMenu) {
                case "100", "VFQ" -> mainprogram.viewAllQueues();
                case "101", "VEQ" -> mainprogram.viewEmptyQueues();
                case "102", "ACQ" -> mainprogram.addCustomerToQueues();
                case "103", "RCQ" -> mainprogram.RemCustomerToQueues();
                case "104", "PCQ" -> mainprogram.RemServeCustomer();
                case "105", "VCS" -> mainprogram.sortedCustomer();
                case "106", "SPD" -> mainprogram.storeProgrameDataF();
                case "107", "LPD" -> mainprogram.loadProgrameDataF();
                case "108", "STK" -> mainprogram.viewRemainBurgers();
                case "109", "AFS" -> mainprogram.addBurgerToStock();
                case "110", "IFQ" -> mainprogram.ViewIncome();
                case "112", "GUI" -> mainprogram.openfx();
                case "999", "EXT" -> mainprogram.Exit();
                default -> System.out.println("Please enter the Valid Method");
            }
        }
    }

    private void openfx() {
        Application.launch(HelloApplication.class);
    }

    private void viewAllQueues() {

        Main mainProgram = new Main();


        System.out.println("***************************************************");
        System.out.print("Cashier No.1 :");
        for (int i=0; i<Queue1.getCashier().size(); i++) {
            System.out.print(Queue1.getCashier().get(i).getFirstName() + " " + Queue1.getCashier().get(i).getLastName() + " , ");
        }

        System.out.println();

        System.out.print("Cashier No.2 : ");
        for (int i=0; i<Queue2.getCashier().size(); i++) {
            System.out.print(Queue2.getCashier().get(i).getFirstName() + " " + Queue2.getCashier().get(i).getLastName() + " , ");
        }

        System.out.println();

        System.out.print("Cashier No.3 : ");
        for (int i=0; i<Queue3.getCashier().size(); i++) {
            System.out.print(Queue3.getCashier().get(i).getFirstName() + " " + Queue3.getCashier().get(i).getLastName() + " , ");
        }

        System.out.println();


        System.out.println("""
                ***************************************************
                *                                                 *
                *          *************************              *
                *          *  ---> Food Fav <---  *               *
                *          *************************              *
                """);
        mainProgram.FlowDiagram();

        System.out.println("Remaining burgers : " + maxBurgers);
        System.out.println("Total Number of customers : " + totalCustomers);
        System.out.println("Total Number of customers in this moment : " + (cashierCustomers1+cashierCustomers2+cashierCustomers3));
        System.out.println("Customers In Cashier 1 : " + cashierCustomers1);
        System.out.println("Customers In Cashier 2 : " + cashierCustomers2);
        System.out.println("Customers In Cashier 3 : " + cashierCustomers3);
        System.out.println("there are " + waiting.size() + " customers in the waiting queue!!!");

        //Display cashier counters

    }

    private void viewEmptyQueues() {

        System.out.println("""
                ============================================================================
                ============================ * Empty Queues * ==============================
                ============================================================================
                """);
//
//        for (int i = 0; i < Queue1.getSize(); i++) {
//            if (!Queue1.isFull()) {
//                System.out.println("Cashier 1 position " + (i + 1) + " is empty");
//            }
//        }
        if (!Queue1.isFull()) {
            int remainingPositions = Queue1.getSize() - Queue1.getCashier().size();
                System.out.println("Cashier 1 : " + (remainingPositions) + " remaining positions are available");
        }
        if (!Queue2.isFull()) {
            int remainingPositions = Queue2.getSize() - Queue2.getCashier().size();
            System.out.println("Cashier 2 : " + (remainingPositions) + " remaining positions are available");
        }
        if (!Queue3.isFull()) {
            int remainingPositions = Queue3.getSize() - Queue3.getCashier().size();
            System.out.println("Cashier 3 : " + (remainingPositions) + " remaining positions are available");
        }


        System.out.println("""
                ============================================================================
                ============================================================================
                """);
    }

    private void addCustomerToQueues() {
        Scanner route = new Scanner(System.in);
        String firstName = nameValid("First Name");
        String lastName = nameValid("Last Name");


        int burgerCount;

        while (true) {
            try {
                System.out.print("Enter the Burger Count : ");
                int TempburgerCount = route.nextInt();
                if (maxBurgers >=TempburgerCount){
                    burgerCount = TempburgerCount;
                    break;
                } else if (maxBurgers >1) {
                    System.out.println("Only "+ maxBurgers +" Burgers are Remaining !!! \nPlease enter No of Burgers Below "+ maxBurgers);
                }
                else {
                    System.out.println("Burgers are out of stock");
                }


            } catch (Exception error) {
                System.out.println("enter valid input");
                route.next();
            }
        }

        Customer obj = new Customer(firstName, lastName, burgerCount);

        if (cashierCustomers1 <= cashierCustomers2 && cashierCustomers1 <= cashierCustomers3 && cashierCustomers1 < 2) {
            Queue1.getCashier().add(obj);
            cashierCustomers1++;
            totalCustomers++;
            System.out.println("=================================\n"+firstName+" "+lastName+ " Added to the Queue 1"+"\n=================================");
        } else if (cashierCustomers2 <= cashierCustomers3 && cashierCustomers2 < 3) {
            Queue2.getCashier().add(obj);
            cashierCustomers2++;
            totalCustomers++;
            System.out.println("=================================\n"+firstName+" "+lastName+ " Added to the Queue 2"+"\n=================================");
        } else {
            if (cashierCustomers3 < 5) {
                Queue3.getCashier().add(obj);
                cashierCustomers3++;
                totalCustomers++;
                System.out.println("=================================\n"+firstName+" "+lastName+ " Added to the Queue 3"+"\n=================================");
            } else {
                waiting.add(obj);
                totalCustomers++;
                System.out.println("=================================\n"+firstName+" "+lastName+ " Added to the Waiting Queue !!!"+"\n=================================");
            }
        }
    }

    //================================================================================================
    private void RemCustomerToQueues() {
        Scanner route = new Scanner(System.in);
        System.out.print("Enter the Cashier No : ");
        int CashierNum = route.nextInt();
        System.out.print("Enter the Customer No : ");
        int CustomerNum = route.nextInt();

        switch (CashierNum) {
            case 1:
                System.out.println("============================================\n"+Queue1.getCashier().get(CustomerNum-1).getFirstName()+" Removed form Queue 1"+"\n============================================");
                Queue1.getCashier().remove(CustomerNum-1);
                cashierCustomers1--;
                break;
            case 2:
                System.out.println("============================================\n"+Queue2.getCashier().get(CustomerNum-1).getFirstName()+"Removed form Queue 2"+"\n============================================");
                Queue2.getCashier().remove(CustomerNum-1);
                cashierCustomers2--;
                break;
            case 3:
                System.out.println("============================================\n"+Queue3.getCashier().get(CustomerNum-1).getFirstName()+"Removed form Queue 3"+"\n============================================");
                Queue3.getCashier().remove(CustomerNum-1);
                cashierCustomers3--;
                break;
            default:
                System.out.println("enter the valid number!!!");
        }
    }

//    private void shiftElements(String[] queue, int startIndex) {
//        for (int i = startIndex; i < queue.length - 1; i++) {
//            queue[i] = queue[i + 1];
//        }
//        queue[queue.length - 1] = null;
//    }

    //=================================================================================================


    private void RemServeCustomer() {
        Scanner route = new Scanner(System.in);
        System.out.print("Enter the Cashier Number : ");
        int CashierNum = route.nextInt();

        switch (CashierNum){
            case 1 :
                if (Queue1.getCashier().get(0) != null){
                    if (CashierNum > 0 && CashierNum <= 3) {
                        System.out.println("====================================\n"+Queue1.getCashier().get(0).getFirstName()+" Buys "+Queue1.getCashier().get(0).getBurgers()+ " burgers From the burger Queue");
                        maxBurgers = maxBurgers - Queue1.getCashier().get(0).getBurgers();
                        SoldBurgers = SoldBurgers + Queue1.getCashier().get(0).getBurgers();
                        Queue1.getCashier().remove(0);
//                        shiftElements(Queue1, 0);
                        cashierCustomers1--;
                        System.out.println("1 Cashier Served Customer is Removed");
                        break;
                    }else {
                        System.out.println("Enter the valid Cashier Number");
                    }
                    break;
                }else {
                    System.out.println("Already Empty");
                }break;
            case 2:
                if (Queue2.getCashier().get(0) != null) {
                    if (CashierNum > 0 && CashierNum <= 3) {
                        System.out.println("====================================\n"+Queue2.getCashier().get(0).getFirstName()+" Buys "+Queue2.getCashier().get(0).getBurgers()+ " burgers From the burger Queue");
                        maxBurgers = maxBurgers - Queue2.getCashier().get(0).getBurgers();
                        SoldBurgers = SoldBurgers + Queue2.getCashier().get(0).getBurgers();
                        Queue2.getCashier().remove(0);
//                        shiftElements(Queue2, 0);
                        cashierCustomers2--;
//                        burgerCount = (burgerCount - 5);
                        System.out.println("2 Cashier Served Customer is Removed");
                        break;
                    } else {
                        System.out.println("Enter the valid Cashier Number");
                    }break;
                }else {
                    System.out.println("Already Empty");
                }break;
            case 3:
                if (Queue3.getCashier().get(0) != null) {
                    if (CashierNum > 0 && CashierNum <= 3) {
                        System.out.println("====================================\n"+Queue3.getCashier().get(0).getFirstName()+" Buys "+Queue3.getCashier().get(0).getBurgers()+ " burgers From the burger Queue");
                        maxBurgers = maxBurgers - Queue3.getCashier().get(0).getBurgers();
                        SoldBurgers = SoldBurgers + Queue3.getCashier().get(0).getBurgers();
                        Queue3.getCashier().remove(0);
//                        shiftElements(Queue3, 0);
                        cashierCustomers3--;
//                        burgerCount = (burgerCount - 5);

                        System.out.println("3 Cashier Served Customer is Removed");
                        break;
                    } else {
                        System.out.println("Enter the valid Cashier Number");
                    }break;
                }else {
                    System.out.println("Already Empty");
                }break;
            default:
                System.out.println("Enter the valid Cashier Number ");
        }
        if (maxBurgers <= 10 && maxBurgers >= 1) {
            System.out.println("======================================================================\n" +
                    "========== * Alert : There are " + maxBurgers + " Burgers are remaining * ==========");
        } else if (maxBurgers == 0) {
            System.out.println("Burgers are out of stock");
        }
        System.out.println("======================================================================");
    }

    private void sortedCustomer() {

        String[] sort1 = new String[2];
        String[] sort2 = new String[3];
        String[] sort3 = new String[5];

        for (int i=0;i<Queue1.getCashier().size() ; i++){
            sort1[i] = Queue1.getCashier().get(i).getFirstName();
        }
        for (int i=0;i<Queue2.getCashier().size() ; i++){
            sort2[i] = Queue2.getCashier().get(i).getFirstName();
        }
        for (int i=0;i<Queue3.getCashier().size() ; i++){
            sort3[i] = Queue3.getCashier().get(i).getFirstName();
        }

        String[] mergedQueue = new String[cashierCustomers1 + cashierCustomers2 + cashierCustomers3];
        System.arraycopy(sort1, 0, mergedQueue, 0, cashierCustomers1);
        System.arraycopy(sort2, 0, mergedQueue, cashierCustomers1, cashierCustomers2);
        System.arraycopy(sort3, 0, mergedQueue, cashierCustomers1 + cashierCustomers2, cashierCustomers3);

        bubbleSort(mergedQueue);

        System.out.print("Sorted Customers : ");
        for (int i = 0; i < mergedQueue.length; i++) {
            System.out.print(mergedQueue[i]+" , ");
//            System.out.println();
        }
        System.out.println();
    }

    private void bubbleSort(String[] array) {
        int n = array.length ;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1]  = temp;
                }
            }
        }
    }

    private void storeProgrameDataF() {

        try {
            FileWriter fileWriter = new FileWriter("ProgramData.txt");
            fileWriter.write("Burger count : "+ maxBurgers + ";" + System.lineSeparator());

            fileWriter.write(System.lineSeparator()+"Cashier 1 Customers And their Burger Count: ");
            for (int i = 0; i < Queue1.getCashier().size(); i++) {
                fileWriter.write(Queue1.getCashier().get(i).getFirstName() + " " + Queue1.getCashier().get(i).getLastName() + " = " + Queue1.getCashier().get(i).getBurgers() + " , ");
            }

            fileWriter.write(System.lineSeparator()+"Cashier 2 Customers And their Burger Count: ");
            for (int i = 0; i < Queue2.getCashier().size(); i++) {
                fileWriter.write(Queue2.getCashier().get(i).getFirstName() + " " + Queue2.getCashier().get(i).getLastName() + " = " + Queue2.getCashier().get(i).getBurgers() + " , ");
            }

            fileWriter.write(System.lineSeparator()+"Cashier 3 Customers And their Burger Count: ");
            for (int i = 0; i < Queue3.getCashier().size(); i++) {
                fileWriter.write(Queue3.getCashier().get(i).getFirstName() + " " + Queue3.getCashier().get(i).getLastName() + " = " + Queue3.getCashier().get(i).getBurgers() +  " , ");
            }
            fileWriter.close();
            System.out.println("Program data stored successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }


    private void loadProgrameDataF() {
        try {
            File file = new File("ProgramData.txt");
            Scanner scanner = new Scanner(file);

//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                if (line.startsWith("Burger count")) {
//                    String[] parts = line.split(": ");
//                    burgerCount = Integer.parseInt(parts[1].split(";")[0]);
//                } else if (line.startsWith("Cashier 1 Customers")) {
//                    String[] parts = line.split(": ");
//                    Queue1 = parts[1].split(", ");
//                } else if (line.startsWith("Cashier 2 Customers")) {
//                    String[] parts = line.split(": ");
//                    Queue2 = parts[1].split(", ");
//                } else if (line.startsWith("Cashier 3 Customers")) {
//                    String[] parts = line.split(": ");
//                    Queue3 = parts[1].split(", ");
//                }
//            }

//            scanner.close();
//            System.out.print("Burger Count :");
//            System.out.println(burgerCount);
//            System.out.print("First Cashier :");
//            System.out.println(Arrays.toString(Queue1));
//            System.out.print("Second Cashier :");
//            System.out.println(Arrays.toString(Queue2));
//            System.out.print("Third Cashier :");
//            System.out.println(Arrays.toString(Queue3));
//            System.out.println("Program data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Program data file not found.");
        }
    }



    private void viewRemainBurgers() {
        System.out.println("Remaining Burgers : " + maxBurgers);
    }

    private void addBurgerToStock() {
        Scanner route = new Scanner(System.in);
        while (true){
            try {
                System.out.print("No of burgers do you added : ");
                int addedBurgers = route.nextInt();

                maxBurgers = (maxBurgers + addedBurgers);
                System.out.println(addedBurgers + " Burgers added to queue");
                System.out.println("Now there are " + maxBurgers + " burgers in burger stock");
                break;

            }catch (Exception e){
                System.out.println("! Enter the Valid Number");
                route.nextLine();
            }
            break;
        }
    }

    private void Exit() {
        System.out.println("Exiting the program...");
        System.exit(0);
    }

    private void ViewIncome() {
//        SoldBurgers = (50 - maxBurgers);
        System.out.println("Total Income : Rs." + (SoldBurgers * 650) + ".00");
    }
    private void FlowDiagram() {
        String[] flowQueue1 = new String[Queue1.getSize()];
        String[] flowQueue2 = new String[Queue2.getSize()];
        String[] flowQueue3 = new String[Queue3.getSize()];

        for (int i = 0; i < flowQueue1.length; i++) {
            if (i < Queue1.getCashier().size()) {
                flowQueue1[i] = " O ";
            } else {
                flowQueue1[i] = " X ";
            }
        }

        for (int i = 0; i < flowQueue2.length; i++) {
            if (i < Queue2.getCashier().size()) {
                flowQueue2[i] = " O ";
            } else {
                flowQueue2[i] = " X ";
            }
        }
        for (int i = 0; i < flowQueue3.length; i++) {
            if (i < Queue3.getCashier().size()) {
                flowQueue3[i] = " O ";
            } else {
                flowQueue3[i] = " X ";
            }
        }

        System.out.println("""
        Cashier 1           cashier 2            Cashier3
        """);

        System.out.println(" " + flowQueue1[0] + "                  " + flowQueue2[0] + "                  " + flowQueue3[0]);
        System.out.println(" " + flowQueue1[1] + "                  " + flowQueue2[1] + "                  " + flowQueue3[1]);
        System.out.println("                      " + flowQueue2[2] + "                  " + flowQueue3[2]);
        System.out.println("                                           " + flowQueue3[3]);
        System.out.println("                                           " + flowQueue3[4]);

        System.out.println("""
        
        ***************************************************
                X – Not Occupied / O – Occupied
        ***************************************************
        """);
    }

    //----------------------  Name / burger Validation Part  -------------------------

    public String nameValid(String nameType) {
        while (true) {
            Scanner route = new Scanner(System.in);
            System.out.print("Enter Your " + nameType + ": ");
            String name = route .nextLine();
            if (!name.isEmpty()  &&  !name .trim() .isEmpty() && !name.matches(".*[0-9!@#$%^&*(),.?/\":{}|<>]+.*")) {
                try {
                    Integer.parseInt(name);
                    System.out.println("Enter a valid name");
                } catch (NumberFormatException error) {
                    customerName = name.toUpperCase();

                    break;
                }
            } else {
                System.out.println("Enter a valid name");
            }
        }
        return customerName;
    }
    //-------------------------- Food Option Part ------------------------------------------

    public void foodoptions() {
        String menu = """
                100 or VFQ: View all Queues.
                101 or VEQ: View all Empty Queues.
                102 or ACQ: Add customer to a Queue.
                103 or RCQ: Remove a customer from a Queue. (From a specific location).
                104 or PCQ: Remove a served customer.
                105 or VCS: View Customers Sorted in alphabetical order.
                106 or SPD: Store Program Data into file.
                107 or LPD: Load Program Data from file.
                108 or STK: View Remaining burgers Stock.
                109 or AFS: Add burgers to Stock.
                110 or ACQ: View income of each Queue.
                112 : Open JavaFx Project
                999 or EXT: Exit the Program.
                ============================================================================================""";

        System.out.println(menu);
        return;
    }
}

