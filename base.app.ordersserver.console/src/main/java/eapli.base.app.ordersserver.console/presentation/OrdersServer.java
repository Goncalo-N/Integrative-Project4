package main.java.eapli.base.app.ordersserver.console.presentation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class OrdersServer {
    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(4998);

        try{
            socket = serverSocket.accept();
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            while(true) {

                String msgFromClient = bufferedReader.readLine();

                System.out.println("Client Input: " + msgFromClient);


                if (msgFromClient.equalsIgnoreCase("0") || msgFromClient.equalsIgnoreCase("COMMTEST")){
                    bufferedWriter.write(" 2(ACK)");
                }else
                if(msgFromClient.equalsIgnoreCase("1") || msgFromClient.equalsIgnoreCase("DISCONN")) {
                    bufferedWriter.write(" 2(ACK)");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                }else{
                    bufferedWriter.write(" Code inserted not associated with SPOMSP Message Codes");
                }

                bufferedWriter.newLine();
                bufferedWriter.flush();

            }

            socket.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
