/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Ahmed
 */
public class client {
    protected String nid;
    protected String password;
    protected double money;
    public client(String nid){
        this.nid=nid;
    }

    public String getPassword() {
        return password;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }
//    public static void main(String[] args) {
//        client c=new client("a12");
//        System.out.println(c.nid);
//    }
    
    
}
