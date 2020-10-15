package com.codingda.application;

import com.codingda.commons.Message;
import com.codingda.commons.Status;
import com.codingda.pojo.Command;
import com.codingda.strategy.Context;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to Animal Management");
        while (true) {
            System.out.println("please input command:");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String[] params = input.split(" ");
            try {
                Command command = Enum.valueOf(Command.class, params[0]);
                System.out.println(Context.execute(command, Message.success().setParams(Status.INPUT, params)).getParams().get(Status.OUTPUT).toString());
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("your command is wrong please try again");
                continue;
            }
        }
    }
}
