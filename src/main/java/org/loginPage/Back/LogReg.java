package org.loginPage.Back;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class SendSMS{
    Random rand = new Random();
    private int SMS;
    /*
    * HERE I WILL SEND CODE TO PHONE NUMBER BUT I DO NOT KNOW HOW TO DO IT
    */
}
@Data
@AllArgsConstructor
@Builder
public class LogReg {
    Random rand = new Random();
    SendSMS sendSMS = new SendSMS();

    private Map<String, User> users;
    public LogReg() {
        this.users = new HashMap<>();
        users.put("admin", new User("admin","admin","admin"));
    }
    public boolean logged(String number){
        return users.containsKey(number);
    }
    public boolean check(int userSMS){
        return userSMS == sendSMS.getSMS();
    }
    public int showSMS(){
        sendSMS.setSMS(rand.nextInt(1000,9999));
        return sendSMS.getSMS();
    }
    public boolean register(String number, String name, String surname){
        User curretUser = new User(number, name, surname);
        if(!users.containsKey(number)){
             users.put(number, curretUser);
             return true;
        }
        else return false;
    }
}