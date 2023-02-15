package presentation;

import eapli.base.app.agvmanager.console.aplication.AGVManagerController;

import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AGVManagerServer {


    public static void main(String[] args) throws IOException {

        //connection secured with backoffice
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


        try {
            serverSocket = ((SSLServerSocketFactory) SSLServerSocketFactory.getDefault()).createServerSocket(4997);
            socket = serverSocket.accept();
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);


            while (true) {
                // ------------------------------SERVER--------------------------------

                String msgFromClient = bufferedReader.readLine();

                System.out.println("Client Input: " + msgFromClient);


                if (msgFromClient.equalsIgnoreCase("0") || msgFromClient.equalsIgnoreCase("COMMTEST")) {
                    bufferedWriter.write(" 2(ACK)");
                } else if (msgFromClient.equalsIgnoreCase("1") || msgFromClient.equalsIgnoreCase("DISCONN")) {
                    bufferedWriter.write(" 2(ACK)");
                    System.out.println("Client Disconnected");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                } else {
                    bufferedWriter.write(" Code inserted not associated with SPOMSP Message Codes");
                }

                bufferedWriter.newLine();
                bufferedWriter.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();
        inputStreamReader.close();
        outputStreamWriter.close();
        bufferedReader.close();
        bufferedWriter.close();
        serverAGVManagerClient();
        serverAGVManagerDTC();
    }

    public static void serverAGVManagerClient() throws IOException {

        //connection with DigitalTwinServer
        System.setProperty("javax.net.ssl.keyStore", "SSL/twinServer.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "twinserver");
        System.setProperty("javax.net.ssl.trustStore", "SSL/twinServer.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "twinserver");


        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try{
            socket = ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket("localhost", 5000);

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
                    System.out.println("Digital Twin Server Response:" + bufferedReader.readLine());
                }else
                if(msgToSend.equals("1") || msgToSend.equalsIgnoreCase("DISCONN")) {
                    System.out.println("Digital Twin Server Response:"+bufferedReader.readLine());
                    break;
                }else{
                    System.out.println("Digital Twin Server Response:"+bufferedReader.readLine());
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
    public static void serverAGVManagerDTC() throws IOException {

        Socket socket2 = null;

        InputStreamReader inputStreamReader2 = null;
        OutputStreamWriter outputStreamWriter2 = null;
        BufferedReader bufferedReader2 = null;
        BufferedWriter bufferedWriter2 = null;
        ServerSocket serverSocket2 = null;

        //connection secured with twinclient
        /*System.setProperty("javax.net.ssl.keyStore", "SSL/twinclient.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "twinclient");
        System.setProperty("javax.net.ssl.trustStore", "SSL/twinclient.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "twinclient");*/
        try{
            serverSocket2 = ((SSLServerSocketFactory)SSLServerSocketFactory.getDefault()).createServerSocket(4995);
            socket2 = serverSocket2.accept();
            inputStreamReader2 = new InputStreamReader(socket2.getInputStream());
            outputStreamWriter2 = new OutputStreamWriter(socket2.getOutputStream());

            bufferedReader2 = new BufferedReader(inputStreamReader2);
            bufferedWriter2 = new BufferedWriter(outputStreamWriter2);


            while(true) {
                // ------------------------------SERVER--------------------------------

                String msgFromClient = bufferedReader2.readLine();

                System.out.println("Client Input: " + msgFromClient);


                if (msgFromClient.equalsIgnoreCase("0") || msgFromClient.equalsIgnoreCase("COMMTEST")){
                    bufferedWriter2.write(" 2(ACK)");
                }else
                if(msgFromClient.equalsIgnoreCase("1") || msgFromClient.equalsIgnoreCase("DISCONN")) {
                    bufferedWriter2.write(" 2(ACK)");
                    System.out.println("Client Disconnected");
                    bufferedWriter2.newLine();
                    bufferedWriter2.flush();
                    break;
                }else{
                    bufferedWriter2.write(" Code inserted not associated with SPOMSP Message Codes");
                }

                bufferedWriter2.newLine();
                bufferedWriter2.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        socket2.close();
        inputStreamReader2.close();
        outputStreamWriter2.close();
        bufferedReader2.close();
        bufferedWriter2.close();
    }
}
