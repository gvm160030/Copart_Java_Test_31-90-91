/**
 * 
 */
package com.group.copart.jms;
import java.io.BufferedReader;  
import java.io.InputStreamReader;  
import java.util.Hashtable;

import javax.naming.*;  
import javax.jms.*;
/**
 * @author GAURI
 *
 */
public class Sender {
	
	  
    public static void main(String[] args) {  
        try  
        {   //Create and start connection
            Context ctx=new InitialContext();  
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("myQueueConnectionFactory");  
            QueueConnection con=f.createQueueConnection();  
            con.start();  
            // create queue session  
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
            // get the Queue object  
            Queue t=(Queue)ctx.lookup("myQueue");  
            // create QueueSender object         
            QueueSender sender=ses.createSender(t);  
            // create TextMessage object  
            TextMessage msg=ses.createTextMessage();  
              
            // write message  
            BufferedReader b=new BufferedReader(new InputStreamReader(System.in));  
            while(true)  
            {  
                System.out.println("Enter Msg");  
                String s=b.readLine();  
                if (s.equals("end"))  
                    break;  
                msg.setText(s);  
                //7) send message  
                sender.send(msg);  
                System.out.println("Message successfully sent.");  
            }  
            // connection close  
            con.close();  
        }
        catch(Exception e){
        	System.out.println(e);
        	}  
    } 
}


  
 
