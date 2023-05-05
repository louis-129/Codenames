package javanetworking;
import java.awt.*;
import java.net.*;
import java.io.*;

public class ServerHandler
{
    public static boolean connected = false;
    private static        ServerSocket MyServer;
    private static        Socket clientSocket;
    private static        OutputStream os;
    private static        PrintWriter pw;
    private static        BufferedReader br;
   
//    private static Socket client = null;
//    private static PrintWriter serverOut = null;
//    private static BufferedReader serverIn = null;

    public static void receiveConnect(int port) throws UnknownHostException, IOException, SocketTimeoutException
    {
//        ServerSocket server = new ServerSocket(port);
//        server.setSoTimeout(8000);
//        client = server.accept();
//        serverOut = new PrintWriter(client.getOutputStream(), true);
//        serverIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
        MyServer = new ServerSocket(port);
        clientSocket = MyServer.accept();
        os = clientSocket.getOutputStream();
        pw = new PrintWriter(os, true);
        br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        connected = true;
        receivePieceMove();
    }

    public static void disconnect()
    {
        try
        {
            if (clientSocket != null)
                clientSocket.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        clientSocket = null;
        pw = null;
        br = null;
        connected = false;
        JavaNetworking.gameStarted = false;
        JavaNetworking.reset();
    }
    
    
//jy added for multiple variables.     
    public static void sendPieceMove(int val1,int val2)
    {
        if (connected)
        {
//jy added for multiple variables.                   
            System.out.println("sendPieceMove");
            pw.println(val1 + ":" + val2);
            pw.flush(); 
            JavaNetworking.myTurn = false;
        }            
    }


    public static void sendDisconnect()
    {
        if (connected)
            pw.println("esc");
    }

    private static void receivePieceMove()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                String inputLine;

                try
                {
                    while ((inputLine = br.readLine()) != null)
                    {
                        try
                        {
                            if (inputLine.equals("esc"))
                            {
                                disconnect();
                                return;
                            }
                            // row:col
//jy added for multiple variables.                 
                            int post1 = Integer.parseInt(inputLine.split(":")[0]);
                            int post2 = Integer.parseInt(inputLine.split(":")[1]);    
                            int post3 = Integer.parseInt(inputLine.split(":")[2]);   
                            JavaNetworking.clientX=post1;
                            JavaNetworking.clientY=post2;
                            JavaNetworking.myTurn = true;
                        }
                        catch (NumberFormatException e)
                        {
                            e.printStackTrace();
                        }
                        catch (NullPointerException e)
                        {
                            disconnect();
                        }
                    }
                }
                catch (SocketException e)
                {
                    disconnect();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public static boolean isConnected()
    {
        return connected;
    }
}