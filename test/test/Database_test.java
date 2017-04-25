/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Model.connect;
import java.sql.ResultSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ahmed
 */
public class Database_test {

    String msg = "";

    @Test
    public void test_loan_database_t() {
        try {
            ResultSet r = connect.startConnectionStatement().executeQuery("select * from loan");
            int x = 0;
            boolean flag = false;
            while (r.next()) {
                x = r.getRow();
            }

            if (x > 0) {
                msg = "pass";
            }

        } catch (Exception ex) {
            msg = "not pass";
        } finally {
            connect.closeConnection();
        }
        assertEquals("pass", msg);
        msg = "";
    }

    @Test
    public void test_arshif_database_t() {
        try {
            ResultSet r = connect.startConnectionStatement().executeQuery("select * from arshif");
            int x = 0;
            boolean flag = false;
            while (r.next()) {
                x = r.getRow();
            }

            if (x > 0) {
                msg = "pass";
            }

        } catch (Exception ex) {
            msg = "not pass";
        } finally {
            connect.closeConnection();
        }
        assertEquals("pass", msg);
        msg = "";
    }

    @Test
    public void test_client_database_t() {
        try {
            ResultSet r = connect.startConnectionStatement().executeQuery("select * from client");
            int x = 0;
            boolean flag = false;
            while (r.next()) {
                x = r.getRow();
            }

            if (x > 0) {
                msg = "pass";
            }

        } catch (Exception ex) {
            msg = "not pass";
        } finally {
            connect.closeConnection();
        }
        assertEquals("pass", msg);
        msg = "";
    }

    @Test
    public void test_employee_database_t() {
        try {
            ResultSet r = connect.startConnectionStatement().executeQuery("select * from employee");
            int x = 0;
            boolean flag = false;
            while (r.next()) {
                x = r.getRow();
            }

            if (x > 0) {
                msg = "pass";
            }

        } catch (Exception ex) {
            msg = "not pass";
        } finally {
            connect.closeConnection();
        }
        assertEquals("pass", msg);
        msg = "";
    }

    @Test
    public void test_database_f() {
        try {
            ResultSet r = connect.startConnectionStatement().executeQuery("select * from lan");
            int x = 0;
            boolean flag = false;
            while (r.next()) {
                x = r.getRow();
            }

            if (x > 0) {
                msg = "pass";
            }

        } catch (Exception ex) {
            msg = "not pass";
        } finally {
            connect.closeConnection();
        }
        assertEquals("not pass", msg);
        msg = "";
    }

}
