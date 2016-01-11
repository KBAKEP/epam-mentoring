package com.epam.montoring.module5.task3;

import java.util.Scanner;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import com.epam.montoring.module5.jaas.SimpleCallbackHandler;

public class JaasRunner {

    public static void main(String[] args) {

        String name;
        String password;

        boolean logged = false;

        Scanner scanIn = new Scanner(System.in);

        do {
            System.out.println("Enter user here : ");
            name = scanIn.nextLine();

            System.out.println("Enter password here : ");
            password = scanIn.nextLine();

            

            try {
                LoginContext lc = new LoginContext("JaasLoginContext",
                        new SimpleCallbackHandler(name, password));
                lc.login();
                logged = true;
            } catch (LoginException e) {
//                e.printStackTrace();
            }

        } while (logged != true);
        
        scanIn.close();
        
        System.out.println("SUCCESS");
        
    }

}
