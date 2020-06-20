package com.company;

import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Main {
    public Main() {
    }
    public static void main(String[] args) throws IOException,InterruptedException {
        ArrayList bitlist = new ArrayList<String>();
        while (true) {

                    Thread.sleep(100);
                    try (Socket bit = new Socket("localhost", 5353)) {
                        Thread.sleep(100);
                        try(Socket get = new Socket("localhost", 1900)) {
                                bitlist.add("1");
                                //System.out.println("добавил 1");
                        } catch (ConnectException e) {
                            bitlist.add("0");
                           // System.out.println("добавил 0");
                        }
                    }
                catch (ConnectException e)
                {
                    convertation(bitlist);
                    break;
                }
            }
        }
    public static void convertation(ArrayList<String> bits) throws IOException {
        //System.out.println("voshel");
        //System.out.println(bits.size());
        for(int i =0;i<bits.size();i=i+7)
        {
            ArrayList<String> bs=new ArrayList<>();
            int num=i;
            for(int i1=0;i1<7;i1++)
            {
                bs.add(bits.get(i+i1));
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i2 = 0; i2 < bs.size(); i2++) {
                stringBuilder.append(bs.get(i2));
            }

            FileWriter writer = new FileWriter("C:/Users/root/Desktop/Busygin/Peredatchik/321.txt", false);

                String utfcodebin = stringBuilder.toString();
                //System.out.println(utfcodebin+"block0");
                //System.out.println(utfcodebin);
                int UTF16Code = Integer.parseInt(utfcodebin, 2);
                System.out.println(UTF16Code + "  block");
                String toFile = Character.toString(UTF16Code);
                writer.write(toFile);
                // writer.write(" ");
                writer.flush();
        }
    }
}

