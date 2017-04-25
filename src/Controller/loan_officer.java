/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.LoanFrame;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static View.LoanFrame.txt_years;
import java.sql.ResultSet;
import Model.connect;

/**
 *
 * @author Ahmed
 */
public class loan_officer {

    public static int Loan_year;
    public static String name;
    private String id;
    private String password;
    connect c = new connect();
    
   

    public boolean login(String id, String password) {
        try {
            ResultSet  result=connect.startConnectionStatement().executeQuery("select * from employee where emp_id='"+id+"' and emp_type='loan officer' ");
            String a ="";
            String p="";
                while(result.next()) {
                    a = result.getString(1);
                    p=result.getString(4);
                }
                
                if(a.equals(id)&&p.equals(password)){
                    LoanFrame j=new LoanFrame();
                    j.setVisible(true);
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "wrong National_id or password");
                }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            connect.closeConnection();
        }
        return false;
    }

    public void manage_loan(String nid, Double money) {
        try {
            Double addmoney=0.0;
            ArrayList<String> s=new ArrayList<String>();
            ArrayList<Double> ss=new ArrayList<Double>();
            Loan_year = Integer.parseInt(txt_years.getText());
            name=LoanFrame.txt_name.getText();
            loan n = new loan();
            n.setNID(nid);
            n.setMoney(money);
            PreparedStatement pre = connect.startConnection().prepareStatement("insert into loan (loan_NID,loan_name, loan_money,loan_year,total_money,loan_date,today_date,requested_money)"
                    + " values (?,?,?,?,?,?,?,?)");
            pre.setString(1, n.getNID());
            pre.setString(2, name);       
            pre.setInt(4, Loan_year);
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            pre.setTimestamp(6, date);
            pre.setTimestamp(7, date);
            
                int yy=1;
                String msg="";
                for (int i = Loan_year; i >= 1; i--) {
                    //our loan law
                    s.add("you will pay for every month in "+yy+" year : " +String.valueOf((((money * i * 7) / (Loan_year * 100)) + (money / Loan_year)) / 12));
                    ss.add((money * i * 7) / (Loan_year * 100));
                    yy++;
                }
                for(int i=0;i<s.size();i++){
                   msg+=s.get(i)+"\n";
                }
                 for(int i=0;i<ss.size();i++){
                   addmoney+=ss.get(i);
                }
                 pre.setDouble(3, n.getMoney()+addmoney);
                 pre.setDouble(5, n.getMoney()+addmoney);
                 pre.setDouble(8, n.getMoney());
                 pre.execute();
             
                JOptionPane.showMessageDialog(null, msg);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            connect.closeConnection();
        }
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
}
