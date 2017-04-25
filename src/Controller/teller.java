/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.connect;
import View.TellerFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed
 */
public class teller {


    
    public static boolean deposite_flag = false;
    public static boolean withdraw_flag = false;
    public static boolean new_flag = false;
    public static boolean transfer_flag = false;
    private String id;
    private String password;

    public boolean login(String id, String password) {

        try {
            ResultSet result = connect.startConnectionStatement().executeQuery("select * from employee where emp_id='" + id + "' and emp_type='teller' ");
            String a = "";
            String p = "";
            while (result.next()) {
                a = result.getString(1);
                p = result.getString(4);
            }

            if (a.equals(id) && p.equals(password)) {
                TellerFrame t = new TellerFrame();
                t.setVisible(true);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "wrong National_id or password");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            connect.closeConnection();
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void withdraw(client c) {
        try {
            ResultSet result = connect.startConnectionStatement().executeQuery("select * from client where c_national_id='" + c.nid + "' ");

            Double money = 0.0;
            while (result.next()) {
                money = result.getDouble(7);
            }
            if ((c.getMoney() > money)) {
                JOptionPane.showMessageDialog(null, "you request money more than you have");
            } else if ((c.getMoney() < 0)) {
                JOptionPane.showMessageDialog(null, "you entered money under 0");
            } else {
                Double total = money - c.getMoney();
                connect.startConnectionStatement().executeUpdate("update client set c_money=" + total + "where c_national_id='" + c.nid + "' ");
                withdraw_flag = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            connect.closeConnection();
        }

    }

    public void deposit(client c) {
        try {
            ResultSet result = connect.startConnectionStatement().executeQuery("select * from client where c_national_id='" + c.nid + "' ");

            Double money = 0.0;
            while (result.next()) {
                money = result.getDouble(7);
            }
            if ((c.getMoney() < 0)) {
                JOptionPane.showMessageDialog(null, "you entered money under 0");
            }
            else {
                Double total = money + c.getMoney();
                connect.startConnectionStatement().executeUpdate("update client set c_money=" + total + "where c_national_id='" + c.nid + "' ");
                deposite_flag = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            connect.closeConnection();
        }

    }

    public void transfer_money(client c1, client c2) {
        try {
            ResultSet result1 = connect.startConnectionStatement().executeQuery("select * from client where c_national_id='" + c1.nid + "'");

            Double c1_money = 0.0;
            while (result1.next()) {
                c1_money = result1.getDouble(7);
            }
            ResultSet result2 = connect.startConnectionStatement().executeQuery("select * from client where c_national_id='" + c2.nid + "'");
            Double c2_money = 0.0;
            while (result2.next()) {
                c2_money = result2.getDouble(7);
            }
            if ((c1_money < c1.getMoney())) {
                JOptionPane.showMessageDialog(null, "you transfer money more than you have");
            }else if(c1.getMoney()<0){
                JOptionPane.showMessageDialog(null, "you entered money under 0");
            }
            else {
                Double c1_total = c1_money - c1.getMoney();
                Double c2_total = c2_money + c1.getMoney();
                connect.startConnectionStatement().executeUpdate("update client set c_money=" + c1_total + "where c_national_id='" + c1.nid + "' ");
                connect.startConnectionStatement().executeUpdate("update client set c_money=" + c2_total + "where c_national_id='" + c2.nid + "' ");
                transfer_flag = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
            connect.closeConnection();
        }

    }

    public void openNewaccount(new_client n) {
        try {
            connect.startConnectionStatement().executeUpdate("insert into client (c_national_id , c_name , c_phone , c_address , c_age , c_password , c_money) values ('" + n.nid + "','" + n.name + "','" + n.phone + "','" + n.address + "'," + n.age + ",'" + n.getPassword() + "'," + n.getMoney() + ")");
            ResultSet result = connect.startConnectionStatement().executeQuery("select * from client where c_national_id='" + n.nid + "' ");
            String check_nid = "";
            while (result.next()) {
                check_nid = result.getString(1);
            }
            if (check_nid.equals(n.nid)) {
                new_flag = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            connect.closeConnection();
        }

    }

}
