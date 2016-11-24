package com.andersenlab.traniee.someIOProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SomeIOProject {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        Scanner in = null;

        try {
            in = new Scanner(new File("D:\\Java\\idea_ws\\ioproject\\data\\input1.txt"));
            while (in.hasNextLine()) {
                list1.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            if (in != null) {
                in.close();
            }
        }

        try {
            in = new Scanner(new File("D:\\Java\\idea_ws\\ioproject\\data\\input2.txt"));
            while (in.hasNextLine()) {
                list2.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            if (in != null) {
                in.close();
            }
        }

        // int st = list1.size() > list2.size() ? list1.size() : list2.size();
        Iterator<String> i1 = list1.iterator();
        Iterator<String> i2 = list2.iterator();

        try (FileWriter writer = new FileWriter("D:\\Java\\idea_ws\\ioproject\\data\\output.txt", false)) {

            while (i1.hasNext() || i2.hasNext()) {

                if (i1.hasNext()) {
                    writer.write(i1.next() + "\r\n");
                }
                if (i2.hasNext()) {
                    writer.write(i2.next() + "\r\n");
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
