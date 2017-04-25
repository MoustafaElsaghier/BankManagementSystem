/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Controller.teller;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ahmed
 */
public class test_Teller {
    
    @Test
    public void test_teller_t() {
        String id="t1";
        String password="admin1";
        teller t=new teller();
        boolean flag=true;
        assertEquals(flag, t.login(id, password));
    }
     @Test
    public void test_teller_f() {
        String id="t1";
        String password="3434";
        teller t=new teller();
        boolean flag=false;
        assertEquals(flag, t.login(id, password));
    }
    
}
