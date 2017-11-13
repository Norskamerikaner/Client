/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Clayton
 */
public class UserInfo {
    private static String username;
    private static String password; 
    
    public UserInfo(String username, String password) {
    this.username = username;
    this.password = password;
    }
    
    static String getUsername(){
        return username;
    }
    
    static String getPassword(){
        return password;
    }
}
