package com.toytanik.ims.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {


    public static String checkUserName(String userName) {
        if(userName != null && !userName.isEmpty()) {
            return userName;
        } else {
            throw new IllegalArgumentException(userName + " User name can not be empty :) ");
        }

    }

    public static String checkUserSurname(String userSurname){
        if(userSurname != null  && !userSurname.isEmpty()) {
            return userSurname;
        } else  {
            throw  new IllegalArgumentException(userSurname + " User Surname can not be empty :)");
        }

    }

    public static String checkUserEmail(String userEmail) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if(userEmail != null && !userEmail.isEmpty()) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(userEmail);
            if(matcher.matches()) {
                return userEmail;
            } else {
                throw new IllegalArgumentException(userEmail + " Your Email is unvalid ");
            }

        } else {
            throw new IllegalArgumentException(userEmail + " User email con not be empty :)");
        }


    }
}
