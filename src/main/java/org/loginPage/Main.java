package org.loginPage;

import org.loginPage.Front.LoginPage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginPage user = new LoginPage();
        while(true){
            System.out.println("Banknig System of Beknur:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Chose option: ");
            int options = scanner.nextInt();
            if(options == 1){
                user.startLogin();
            }
            else if(options == 2){
                user.startReg();
            }
            else{
                System.exit(0);
            }
        }

    }
}
