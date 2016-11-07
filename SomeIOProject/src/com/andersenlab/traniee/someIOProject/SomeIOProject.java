package com.andersenlab.traniee.someIOProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomeIOProject {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        Scanner in = null;

        try {
            in = new Scanner(new File("D:\\Java\\idea_ws\\ioproject\\data\\input1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        while (in.hasNextLine())
            list1.add(in.nextLine());
        in.close();

        try {
            in = new Scanner(new File("D:\\Java\\idea_ws\\ioproject\\data\\input2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        while (in.hasNextLine())
            list2.add(in.nextLine());
        in.close();

        int st = list1.size() > list1.size() ? list1.size() : list1.size();

        try (FileWriter writer = new FileWriter("D:\\Java\\idea_ws\\ioproject\\data\\output.txt", false)) {

            for (int i = 0; i < st; i++) {

                try {
                    writer.write(list1.get(i) + "\r\n");
                } catch (IndexOutOfBoundsException e) {
                }
                try {
                    writer.write(list2.get(i) + "\r\n");
                } catch (IndexOutOfBoundsException e) {
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
