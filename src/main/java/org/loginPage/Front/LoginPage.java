package org.loginPage.Front;

import org.loginPage.Back.LogReg;
import org.loginPage.Back.User;


import java.util.Map;
import java.util.Scanner;

public class LoginPage{
    LogReg use = new LogReg();
    Scanner scan = new Scanner(System.in);

    public void startLogin(){
        System.out.print("Enter your phone humber: +7-");
        String number = scan.nextLine();
        number = number.replaceAll("\\s","");
        if(use.logged(number)){
            while (true){
                int choice;
                System.out.print("Please enter SMS-code: ");
                System.out.print("(" + use.showSMS() + ") ");
                int userSMS = scan.nextInt();
                if(use.check(userSMS)){
                    Map<String , User> name;
                    name = use.getUsers();
                    System.out.println("Hello " + name.get(number).getName() + ' ' + name.get(number).getSurname() + '\n');
                    while(true){
                        String  a = scan.nextLine();
                        if(a.equals("exit"))System.exit(0);
                    }
                }
                else{
                    System.out.println("The code that you have entered is incorrect please try again or exit the login page");
                    System.out.println("1.Try again");
                    System.out.println("2.Exit");
                    choice = scan.nextInt();
                }
                if(choice==2) break;
            }
        }
        else{
            System.out.println("The user with this number does not exist. Please check your number or press registration button");
        }
    }
    public void startReg(){
        System.out.print("Enter your phone humber: +7-");
        String number = scan.nextLine();
        number = number.replaceAll("\\s","");
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        System.out.print("Enter your surname: ");
        String surname = scan.nextLine();
        if(use.register(number, name, surname)) {
            System.out.println("You have successfully registered, please login");
        }
        else{
            System.out.println("User with this number already exists");
        }
    }
}
