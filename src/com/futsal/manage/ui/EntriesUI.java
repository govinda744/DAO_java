package com.futsal.manage.ui;

import com.futsal.manage.DAO.*;
import com.futsal.manage.DAOImplement.*;
import com.futsal.manage.entity.Entries;
import com.futsal.manage.entity.Futsal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EntriesUI {

    public void startEntriesUI() throws ClassNotFoundException, SQLException {

        EntriesDAO entriesDAO = new EntriesDAOImplementation();
        FutsalDAO futsalDAO = new FutsalDAOImplement();

        List<Futsal> futsalList;
        List<Entries> entriesList;

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {

            System.out.println("----------MENU----------");
            System.out.println(" 1. Add entry \n 2. display futsal entry \n 3. display all entries \n 4. delete entry \n 5. exit");

            System.out.println("Enter you choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    Entries entries = new Entries();

                    System.out.print("Enter team name: ");
                    entries.setTeamName(scanner.next());
                    System.out.print("Enter start time: ");
                    entries.setStartTime(scanner.nextInt());
                    System.out.print("Enter end time: ");
                    entries.setEndTime(scanner.nextInt());
                    System.out.print("Enter contact of team: ");
                    entries.setContact(scanner.next());

                    System.out.println("select futsal to play in: ");
                    futsalList = futsalDAO.getAll();

                    if (!futsalList.isEmpty()) {
                        for (Futsal i : futsalList) {
                            System.out.println("--------------------------");
                            System.out.println("        Id:  " + i.getId());
                            System.out.println("        Name:" + i.getName());
                            System.out.println("-----------------------------");
                            System.out.println("Play in this futsal?(Y for yes): ");
                            if (scanner.next().toUpperCase().equals("Y")) {
                                entries.setFutsalId(i.getId());
                                break;
                            }
                        }
                        System.out.println("No futsal selected.");
                    }
                    if (entries.getFutsalId() != 0) {
                        if (entriesDAO.add(entries) != null) {
                            System.out.println("Inserted into table successfully.");
                        } else {
                            System.out.println("Entry cannot be added.");
                        }
                    }
                    break;
                case 2:

                    futsalList = futsalDAO.getAll();

                    System.out.println("select futsal entry you want to view: ");

                    if (!futsalList.isEmpty()) {
                        for (Futsal i : futsalList) {
                            System.out.println("----------------------");
                            System.out.println("Id:  " + i.getId());
                            System.out.println("Name:" + i.getName());
                            System.out.println("----------------------");
                            System.out.println("Select this futsal:(Y for yes) ");

                            if (scanner.next().toUpperCase().equals("Y")) {
                                entriesList = entriesDAO.getFutsalEntries(i.getId());
                                for (Entries i1 : entriesList) {
                                    System.out.println("-------------------------------------");
                                    System.out.println("    Id:          " + i1.getId());
                                    System.out.println("    Name:        " + i1.getTeamName());
                                    System.out.println("    Contact:     " + i1.getContact());
                                    System.out.println("    Start TIme:  " + i1.getStartTime());
                                    System.out.println("    End TIme:    " + i1.getEndTime());
                                    System.out.println("------------------------------------");
                                }
                            }
                        }
                    }
                    break;
                case 3:

                    entriesList = entriesDAO.getAll();

                    if (!entriesList.isEmpty()) {
                        for (Entries i2 : entriesList) {
                            System.out.println("-------------------------------------");
                            System.out.println("    Id:          " + i2.getId());
                            System.out.println("    Name:        " + i2.getTeamName());
                            System.out.println("    Contact:     " + i2.getContact());
                            System.out.println("    Start TIme:  " + i2.getStartTime());
                            System.out.println("    End TIme:    " + i2.getEndTime());
                            System.out.println("------------------------------------");
                        }
                    }

                    break;

                case 4:

                    System.out.println("Enter the entries id: ");
                    if (entriesDAO.delete(scanner.nextInt())) {
                        System.out.println("Deleted Sucessfully");
                    } else {
                        System.out.println("Deletion unsucessfull.");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Enter valid choice. ");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }
}

