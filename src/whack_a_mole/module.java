/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whack_a_mole;

import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author khatri
 */
public class module {
    
    Connection con;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;
    protected void conn()
    {
        try
        {
        Class.forName("java.sql.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcanvass","root","");
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error in Connection");
        }
    }
    
    //User game record Insertion
    protected void storeGameRecord(String name,String email,String dte,int points,int hit)
    {
        try
        {   conn();
            st=con.createStatement();
            String str="insert into tbgame_master(uname,email,dte,points,common_hit) values('"+ name +"','"+ email +"','"+ dte +"',"+ points +","+ hit +")";
            st.executeUpdate(str);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
    }
    
    //Sent mail
    protected void sentMail(String to,String contnt)
    {
        try
			{
			Properties pros=new Properties();
			pros.put("mail.smtp.host","mail.domain.com");
			pros.put("mail.smtp.auth",true);
			Authenticator auth=new SMTPAuthenticator();
			Session session=Session.getDefaultInstance(pros,auth);
			Message msg=new MimeMessage(session);
			InternetAddress addressTo=new InternetAddress(to);
			InternetAddress addressFrom=new InternetAddress("email@domain.com","Whack a Mole");
			msg.setFrom(addressFrom);
			msg.setRecipient(Message.RecipientType.TO,addressTo);
			msg.setSubject("Whack a Mole game Score");
			msg.setContent("Dear Candidate! Your Score of game is "+contnt,"text/plain");
			Transport.send(msg);
			
                        JOptionPane.showMessageDialog(null, "Your Score Sent Successfully!");
			}catch(Exception ex)
			{
                            if(checkInternet()==false)
                            {
                                JOptionPane.showMessageDialog(null, "Please Connect Internet","Error",JOptionPane.ERROR_MESSAGE);
                            }
                            else
                            {
			System.out.println(ex);
                            }
			}
    }
    
    //Top3 Players
protected void fetchTop3(javax.swing.JTable dtl)
{
model=(DefaultTableModel)dtl.getModel();        
try
        {
           
        if(con.isClosed())
        {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcanvass","root","");
        }         
         if(model.getRowCount()>0)
            {
          while(model.getRowCount()>0)
           {
               model.removeRow(0);
           }
            }
        st=con.createStatement();
        String query="select uname,sum(`points`) as 'Total',`common_hit` from tbgame_master group by uname order by Total desc limit 3";
        
        rs=st.executeQuery(query);
    
        
        while(rs.next())
        {
            model.addRow(new Object[]{rs.getString("uname"),rs.getInt("Total"),rs.getInt("common_hit")});
            
        }
       
        
        rs.close();
        
        st.close();
        //con.close();
              
        
        
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
}
   
//Retrieve Game History
protected void fetchHistory(javax.swing.JTable dtl)
{
    model=(DefaultTableModel)dtl.getModel();
    try
    {
        if(con.isClosed())
        {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcanvass","root","");
        }         
        if(model.getRowCount()>0)
        {
        for(int i=0;i<model.getRowCount()-1;i++)
        {
            model.removeRow(i);
        }
        }
        st=con.createStatement();
        rs=st.executeQuery("select dte,uname,points from tbgame_master order by game_id desc");
        while(rs.next())
        {
            model.addRow(new Object[]{rs.getString("dte"),rs.getString("uname"),rs.getInt("points")});
        }
        rs.close();
        
        st.close();
    }
    catch(Exception ex)
    {
        System.out.println(ex);
    }
}

protected int[] mostHitMole(int[] top)
{
    try
    {
        st=con.createStatement();
        String query="select common_hit,count(*) as 'Total' from tbgame_master group by common_hit order by Total desc limit 3";
        rs=st.executeQuery(query);
        int i=0;
        while(rs.next())
        {
           //b1.setText(String.valueOf(rs.getInt("common_hit")));
           top[i]=rs.getInt("common_hit");
           i++;
        }
        
    }
    catch(Exception ex)
    {
        
    }
    return top;
}

      //Email Validation 
    public boolean validEmail(String str)
    {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        boolean flag;
        if(str.matches(EMAIL_REGEX)==true)
        {
            flag=true;
        }
        else
        {
            flag=false;
        }
        return flag;
    }
    //Check Intenet Connectivity 
    public boolean checkInternet()
    {
  boolean connectivity;
try {
    URL url = new URL("http://google.co.in");
    URLConnection conn = url.openConnection();
    conn.connect();
    connectivity = true;
    } catch (Exception e) {
    connectivity = false;
    }
    if(connectivity==true)
    {
        return true;
    }
    else
    {
        return false;
    }
    }
    
    public int gRandom()
    {
        int ra=1+(int)(Math.random()*((9-1)+1));
        return ra;
    }
    public static Map sortByComparator(Map unsortMap) 
   { 
        List list=new LinkedList(unsortMap.entrySet()); 
       
        Collections.sort(list,new Comparator() 
        {
             @Override
             public int compare(Object o1,Object o2) 
             {
     return ((Comparable)((Map.Entry)(o2)).getKey()).compareTo(((Map.Entry) (o1)).getKey());
             }
        });

       
    Map sortedMap=new LinkedHashMap();
    for (Iterator it=list.iterator();it.hasNext();) 
    {
         Map.Entry entry=(Map.Entry)it.next();
         sortedMap.put(entry.getKey(),entry.getValue());
    }
    return sortedMap;
   }    
    

private class SMTPAuthenticator extends javax.mail.Authenticator
{   
	public PasswordAuthentication getPasswordAuthentication()
	{
	return new PasswordAuthentication("email@domain.com","password");
	
	}

}

}