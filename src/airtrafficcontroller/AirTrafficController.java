/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airtrafficcontroller;

import java.lang.reflect.InvocationTargetException;
import javax.swing.JTextField;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

class Runway {

    static final double rx = 0, ry = 0, rz = 0;
    public boolean lstatus;

    Runway(boolean lstatus) {
        this.lstatus = lstatus;
    }
}

public class AirTrafficController //extends Runway
{

    //double safe=10;
    public static boolean l;
    double x, y, z; //Coordinates
    String name;
    public char status;
    public static String str1;

    public AirTrafficController() {

    }

    public AirTrafficController(double x, double y, double z, String name, char status) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
        this.status = status;
    }

    double distanceToP(AirTrafficController p1, AirTrafficController p2) {
        double dist = (Math.sqrt(Math.pow((p1.x - p2.x), 2)) + (Math.pow((p1.y - p2.y), 2)) + (Math.pow((p1.z - p2.z), 2)));
        return dist;
    }

    public double distanceToR(AirTrafficController p1) {
        System.out.println(Runway.rx + " " + Runway.ry + " " + Runway.rz);
        double dist = (Math.sqrt(Math.pow((p1.x - Runway.rx), 2.0) + Math.pow((p1.y - Runway.ry), 2.0) + Math.pow((p1.z - Runway.rz), 2.0)));
        System.out.println(dist);
        return dist;
    }

    public boolean land(AirTrafficController p) {
        double d = distanceToR(p);
        System.out.println(d);
        if (d < 10) {
            l = true;
            return l;
        } else {
            l = false;
            return l;
        }
    }
    //@Override
   /*public void run()
     { try
     {
     AirTrafficController pc=new AirTrafficController(x,y,z,name,status);
     for(int i=1;true;i++)
     {
     l=land(pc);
     pc.x=pc.x-1;
     pc.y=pc.y-1;
     pc.z=pc.z-1;
     Thread.sleep(1000);
     System.out.println(pc.x+" "+pc.y+" "+pc.z);
     System.out.println(l);
       
     if(l)
     {
     JOptionPane.showMessageDialog(null,"Plane requesting permission to Land");
     str1="Plane requesting permission to Land";
           
           
            
     //jTextField1.setText("Plane requesting permission to Land");
                 

     break;
     }
           
     }
     }
     catch(Exception e)
     {
       
     System.out.println("exception found");
     }
     }   
       
       
       
     }*/

     public void load(ATCUI e) throws InterruptedException {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    try {
                        AirTrafficController pc = new AirTrafficController(x, y, z, name, status);
                        for (int i = 1; true; i++) {
                            l = land(pc);
                            pc.x = pc.x - 1;
                            pc.y = pc.y - 1;
                            pc.z = pc.z - 1;
                            Thread.sleep(1000);
                            System.out.println(pc.x + " " + pc.y + " " + pc.z);
                            System.out.println(l);
                            
                            if (l) {
                                JOptionPane.showMessageDialog(null, "Plane requesting permission to Land");
                                str1 = "Plane requesting permission to Land";
                                
                                //jTextArea.setText("Plane requesting permission to Land");
                                e.showText();
                                
                                break;
                            }
                            
                        }

                    } catch (Exception e) {
                        
                        System.out.println("exception found");
                    }

                }
            });
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AirTrafficController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/**
 *
 * @author
 *
 */

/*public class AirTrafficController {

 /**
 * @param args the command line arguments
 *
    
 public static void main(String[] args) {
 // TODO code application logic here
 /*JOptionPane.showMessageDialog(null,"HII");
 AirTrafficController p1=new AirTrafficController(12,13,15,"plane 1",'f');
 //AirTrafficController p=new AirTrafficController();
 boolean l=p1.land(p1);
 System.out.println(l);
 Thread t1=new Thread(p1);
 t1.start();
       
        
        
 }
    
 }
 */
