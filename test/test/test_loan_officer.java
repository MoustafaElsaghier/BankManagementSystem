/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Controller.loan_officer;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Ahmed
 */
public class test_loan_officer {

    @Test
    public void test_loan_login_t() {
        String id="l1";
        String password="admin2";
        loan_officer l=new loan_officer();
        boolean flag=true;
        assertEquals(flag, l.login(id, password));
    }
    @Test
    public void test_loan_login_f() {
        String id="l1";
        String password="1212";
        loan_officer l=new loan_officer();
        boolean flag=false;
        assertEquals(flag, l.login(id, password));
    }
}
