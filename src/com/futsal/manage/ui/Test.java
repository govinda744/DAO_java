package com.futsal.manage.ui;

import com.futsal.manage.entity.Futsal;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        EntriesUI entriesUI = new EntriesUI();
        FutsalUI futsalUI = new FutsalUI();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("On which you want to perform operation on: ");
            System.out.println(" 1. Futsal \n 2. Entries \n 3. exit");
            System.out.println("select One: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    futsalUI.startFutsalUI();
                    break;
                case 2:
                    entriesUI.startEntriesUI();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default :
                    System.out.println("Enter valid choice. ");
            }
        }
    }

}
