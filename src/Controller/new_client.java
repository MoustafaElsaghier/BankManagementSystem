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
public class new_client extends client{
    public String name;
    public String address;
    public String phone;
    public int age;
    
    public new_client(String nid,String name,String address,String phone,int age) {
        super(nid);
        this.name=name;
        this.address=address;
        this.age=age;
        this.phone=phone;
    }
    
//    public static void main(String[] args) {
//        new_client n=new new_client("aa", "ahmed", "zx", "123", 5);
//        System.out.println(n.nid+" "+n.name+" "+n.address+" "+n.phone+" "+n.age);
//        n.setMoney(45);
//        n.setPassword("asd");
//        System.out.println(n.getMoney()+" "+n.getPassword());
//    }
    
}
