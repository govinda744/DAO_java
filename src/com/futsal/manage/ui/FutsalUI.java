package com.futsal.manage.ui;

import com.futsal.manage.DAO.FutsalDAO;
import com.futsal.manage.DAO.FutsalDAOImplement;
import com.futsal.manage.entity.Futsal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class FutsalUI {

    public void startFutsalUI() throws ClassNotFoundException, SQLException {

        FutsalDAO futsalDAO = new FutsalDAOImplement();

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {

            System.out.println("----------MENU----------");
            System.out.println(" 1. Add \n 2. display \n 3. delete \n 4. exit");

            System.out.println("Enter you choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    Futsal futsal = new Futsal();

                    System.out.print("Enter futsal name: ");
                    futsal.setName(scanner.next());
                    System.out.print("Enter futsal location: ");
                    futsal.setLocation(scanner.next());
                    System.out.print("Enter contact No.: ");
                    futsal.setContact(scanner.next());
                    System.out.print("Enter opening hour: ");
                    futsal.setOpeningHour(scanner.nextInt());
                    System.out.print("Enter closing hour: ");
                    futsal.setClosingHour(scanner.nextInt());

                    if (futsalDAO.add(futsal) != null) {
                        System.out.println("Inserted into table successfully.");
                    } else {
                        System.out.println("Entry cannot be added.");
                    }
                    break;
                case 2:

                    List<Futsal> futsals = futsalDAO.getAll();

                    if (!futsals.isEmpty()) {
                        for (Futsal i : futsals) {
                            System.out.println("Id:           " + i.getId());
                            System.out.println("Name:         " + i.getName());
                            System.out.println("Location:     " + i.getLocation());
                            System.out.println("Contact:      " + i.getContact());
                            System.out.println("Opening Hour: " + i.getOpeningHour());
                            System.out.println("Closing Hour: " + i.getClosingHour());
                            System.out.println("-------------------------------------");
                        }
                    } else {
                        System.out.println("No entry in table.");
                    }
                    break;

                case 3:

                    System.out.print("Enter the id of futsal: ");
                    int id = scanner.nextInt();

                    if (futsalDAO.delete(id)) {
                        System.out.println("Successfully deleted.");
                    } else {
                        System.out.println("Deletion unsuccessful");
                    }
                    break;

                case 4:
                    break;
                default:
                    System.out.println("Enter valid choice. ");
                    break;
            }
            if (choice == 4) {
                break;
            }
        }
    }

}
