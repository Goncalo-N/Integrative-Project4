package main.java.eapli.base.app.customerapplication.console.presentation;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class CustomerApplicationClient {

    public static void main(String[] args){

        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try{
            socket = new Socket("localhost", 4998);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);
            while(true){

                String msgToSend = scanner.nextLine();

                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                if(msgToSend.equals("0") || msgToSend.equalsIgnoreCase("COMMTEST")) {
                    System.out.println("Order Server Response:" + bufferedReader.readLine());
                }else
                if(msgToSend.equals("1") || msgToSend.equalsIgnoreCase("DISCONN")) {
                    System.out.println("Order Server Response:"+bufferedReader.readLine());
                    break;
                }else{
                    System.out.println("Order Server Response:"+bufferedReader.readLine());
                }

            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (socket != null)
                    socket.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (outputStreamWriter != null)
                    outputStreamWriter.close();
                if (bufferedReader != null)
                    bufferedReader.close();
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
