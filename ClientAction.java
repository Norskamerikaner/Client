/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Clayton
 */
public class ClientAction {
    
    public static String host = "localhost";
    public static int clientport = 2001;
    
    public static boolean register(String username, String password) {
        try {
            String response;
            Socket clientsock = new Socket(host, clientport);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientsock.getInputStream()));
            PrintWriter out =
                new PrintWriter(clientsock.getOutputStream(), true);
            // Registration protocol
            out.println("REGISTER");
            response = in.readLine();
            if (response.equals("OK")){
                out.println(username);
                response = in.readLine();
                if (response.equals("OK")){
                    out.println("PASSWORD");
                    response = in.readLine();
                    if (response.equals("OK")){
                        out.println(password);
                        if (response.equals("OK")){
                            out.println("IP");
                            if (response.equals("OK")){
                                out.println(InetAddress.getLocalHost());
                            }else{System.out.println("FAIL"); return false;}
                        }else{System.out.println("FAIL"); return false;}
                    }else{System.out.println("FAIL"); return false;}
                }else{System.out.println("FAIL"); return false;}
            }else{System.out.println("FAIL"); return false;}

            // Close the socket on completion
            in.close();
            clientsock.close();
            return true;
        }
        catch (UnknownHostException e){
            System.err.println("Error: host not found");
            return false;
        }
        catch (IOException e){
            System.err.println("I/O EXCEPTION");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean logOn(String username, String password) {
        try {
            String response;
            Socket clientsock = new Socket(host, clientport);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientsock.getInputStream()));
            PrintWriter out =
                new PrintWriter(clientsock.getOutputStream(), true);
            // Logon protocol
            out.println("LOGON");
            response = in.readLine();
            if (response.equals("OK")){
                out.println(username);
                response = in.readLine();
                if (response.equals("OK")){
                    out.println("PASSWORD");
                    response = in.readLine();
                    if (response.equals("OK")){
                        out.println(password);
                        if (response.equals("OK")){
                            out.println("IP");
                            if (response.equals("OK")){
                                out.println(InetAddress.getLocalHost());
                            }else{System.out.println("FAIL"); return false;}
                        }else{System.out.println("FAIL"); return false;}
                    }else{System.out.println("FAIL"); return false;}
                }else{System.out.println("FAIL"); return false;}
            }else{System.out.println("FAIL"); return false;}

            // Close the socket on completion
            in.close();
            clientsock.close();
            return true;
        }
        catch (UnknownHostException e){
            System.err.println("Error: host not found");
            return false;
        }
        catch (IOException e){
            System.err.println("I/O EXCEPTION");
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean logOut( String args[] ) {
        try {
            String response;
            Socket clientsock = new Socket(host, clientport);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientsock.getInputStream()));
            PrintWriter out =
                new PrintWriter(clientsock.getOutputStream(), true);
            // Logout protocol
            out.println("LOGOUT" + " " + UserInfo.getUsername());
            response = in.readLine();
            if (response.equals("OK")){
                out.println("PASSWORD" + " " + UserInfo.getPassword());
                response = in.readLine();
                if (response.equals("OK")){
                }else{System.out.println("FAIL"); return false;}
            }else{System.out.println("FAIL"); return false;}

            // Close the socket on completion
            in.close();
            clientsock.close();
        }catch (UnknownHostException e){
            System.err.println("Error: host not found");
            return false;
        }catch (IOException e){
            System.err.println("I/O EXCEPTION");
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static boolean sendMessage(String body, String hashtag) {
        try {
            String response;
            Socket clientsock = new Socket(host, clientport);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientsock.getInputStream()));
            PrintWriter out =
                new PrintWriter(clientsock.getOutputStream(), true);
            // Send message protocol
            out.println("SENDMESSAGE");
            response = in.readLine();
            if (response.equals("OK")){
                out.println(UserInfo.getUsername());
                response = in.readLine();
                if (response.equals("OK")){
                    out.println("BODY");
                    response = in.readLine();
                    if (response.equals("OK")){
                        out.println(body);
                        response = in.readLine();
                        if (response.equals("OK")){
                            out.println("HASHTAG");
                            response = in.readLine();
                            if (response.equals("OK")){
                                out.println(hashtag);
                            }else{System.out.println("FAIL"); return false;}
                        }else{System.out.println("FAIL"); return false;}
                    }else{System.out.println("FAIL"); return false;}
                }else{System.out.println("FAIL"); return false;}
            }else{System.out.println("FAIL"); return false;}

            // Close the socket on completion
            in.close();
            clientsock.close();
            return true;
        }catch (UnknownHostException e){
            System.err.println("Error: host not found");
            return false;
        }catch (IOException e){
            System.err.println("I/O EXCEPTION");
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean followUser(String username) {
        try {
            String response;
            Socket clientsock = new Socket(host, clientport);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientsock.getInputStream()));
            PrintWriter out =
                new PrintWriter(clientsock.getOutputStream(), true);
            // Follow a user protocol
            out.println("ADDFOLLOW");
            response = in.readLine();
            if (response.equals("OK")){
                out.println(UserInfo.getUsername());
                response = in.readLine();
                if (response.equals("OK")){
                    out.println("FOLLOW");
                    response = in.readLine();
                    if (response.equals("OK")){
                        out.println(username);
                    }else{System.out.println("FAIL"); return false;}
                }else{System.out.println("FAIL"); return false;}
            }else{System.out.println("FAIL"); return false;}

            // Close the socket on completion
            in.close();
            clientsock.close();
            return true;
        }catch (UnknownHostException e){
            System.err.println("Error: host not found");
            return false;
        }catch (IOException e){
            System.err.println("I/O EXCEPTION");
            System.err.println(e.getMessage());
            return false;
        }
    }
}
