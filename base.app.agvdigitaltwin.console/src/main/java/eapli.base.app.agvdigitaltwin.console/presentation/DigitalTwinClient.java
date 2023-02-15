package main.java.eapli.base.app.agvdigitaltwin.console.presentation;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class DigitalTwinClient{

    public static void main(String[] args) throws IOException {

        /*System.setProperty("javax.net.ssl.keyStore", "SSL/twinclient.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "twinclient");
        System.setProperty("javax.net.ssl.trustStore", "SSL/twinclient.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "twinclient");
*/
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
            socket = ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket("localhost", 4995);

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
}
