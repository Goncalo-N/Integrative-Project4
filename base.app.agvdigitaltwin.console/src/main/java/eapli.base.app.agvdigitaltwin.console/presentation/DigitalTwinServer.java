package main.java.eapli.base.app.agvdigitaltwin.console.presentation;

import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DigitalTwinServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        //connection secured with DigitalTwinServer SSL
        System.setProperty("javax.net.ssl.keyStore", "SSL/twinServer.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "twinserver");
        System.setProperty("javax.net.ssl.trustStore", "SSL/twinServer.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "twinserver");
        Socket socket = null;

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;



        try{
            serverSocket = ((SSLServerSocketFactory) SSLServerSocketFactory.getDefault()).createServerSocket(5000);
            socket = serverSocket.accept();
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            while(true) {

                String msgFromClient = bufferedReader.readLine();

                System.out.println("AGV Manager Input: " + msgFromClient);


                if (msgFromClient.equalsIgnoreCase("0") || msgFromClient.equalsIgnoreCase("COMMTEST")){
                    bufferedWriter.write(" 2(ACK)");
                }else
                if(msgFromClient.equalsIgnoreCase("1") || msgFromClient.equalsIgnoreCase("DISCONN")) {
                    bufferedWriter.write(" 2(ACK)");
                    System.out.println("Client Disconnected");
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
