import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Register extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)
{
try
{
res.setContentType("text/html");
String a=req.getParameter("N1");
String b=req.getParameter("P1");
String c=req.getParameter("E1");
String d=req.getParameter("R1");
String e=req.getParameter("C1");
String f=req.getParameter("C2");
String g=req.getParameter("S1");
String h=req.getParameter("CM");

PrintWriter pw=res.getWriter();

Class.forName("com.mysql.jdbc.Driver");

Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/orga","root","");

PreparedStatement pst=con.prepareStatement("insert into applicant values(?,?,?,?,?,?,?,?)");

pst.setString(1,a);
pst.setString(2,b);
pst.setString(3,c);
pst.setString(4,d);
pst.setString(5,e);
pst.setString(6,f);
pst.setString(7,g);
pst.setString(8,h);

int u=pst.executeUpdate();

if(u>0)
res.sendRedirect("Wel.html");


}
catch(Exception ett)
{
try
{
PrintWriter out=res.getWriter();

out.print(ett);
}
catch(Exception et)
{

}
}
}
}