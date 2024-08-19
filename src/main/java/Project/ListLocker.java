package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListLocker
 */
@WebServlet("/ListLocker")
public class ListLocker extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLocker() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int lockerCount = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/locker?characterEncoding=latin1",
                    "root", "Deek2003");

            // Query to count locker ids
            PreparedStatement psCount = con.prepareStatement("SELECT COUNT(locker_id) AS locker_count FROM addlocker");
            ResultSet rsCount = psCount.executeQuery();
            if (rsCount.next()) {
                lockerCount = rsCount.getInt("locker_count");
            }

            // Query to select all lockers
            PreparedStatement ps = con.prepareStatement("select * from addlocker");

            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<title>List Locker</title>");
            out.print("<style>");
            out.print("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-image: url(\"https://img.etimg.com/thumb/width-1200,height-900,imgsize-273406,resizemode-75,msid-85430100/wealth/save/banks-will-be-liable-for-loss-of-locker-contents-but-only-up-to-100-times-annual-rent.jpg\"); }");
            out.print("table { width: 100%; border-collapse: collapse; background-color: white; }");
            out.print("th, td { padding: 8px; text-align: center; border-bottom: 1px solid #ddd; }");
            out.print("th { background-color: #f2f2f2; }");
            out.print("td:not(:first-child) { border-left: 1px solid #ddd; }");
            out.print("input[type='submit'] { padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer; }");
            out.print("input[type='submit']:hover { background-color: #45a049; }");
            out.print("nav { background-color: #333; padding: 10px 0; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); }");
            out.print("nav ul { list-style-type: none; margin: 0; padding: 0; text-align: center; }");
            out.print("nav ul li { display: inline; margin-right: 20px; }");
            out.print("nav ul li a { color: #fff; text-decoration: none; padding: 10px 20px; border-radius: 5px; transition: background-color 0.3s; }");
            out.print("nav ul li a:hover { background-color: #555; }");
            out.print("footer { background-color: #333; color: #fff; text-align: center; padding: 3px 0; position: fixed; bottom: 0; width: 100%; }");
            // Additional style for the total lockers section
            out.print(".total-lockers { background-color: white; padding: 10px; margin-bottom: 20px; }");
            out.print("</style>");
            out.print("</head>");
            out.print("<body>");
            out.print("<nav>");
            out.print("<ul>");
            out.print("<li><a href=\"./Home.html\">Home</a></li>");
            out.print("<li><a href=\"./Insert.html\">Insert</a></li>");
            out.print("<li><a href=\"./update.html\">Update</a></li>");
            out.print("<li><a href=\"./delete.html\">Delete</a></li>");
            out.print("<li><a href=\"./list.html\">List</a></li>");
            out.print("<li><a href=\"./search.html\">Search</a></li>");
            out.print("<li style=\"color: white;\">Consultation Number: 123-456-789</li>");
            out.print("</ul>");
            out.print("</nav>");
            // Apply the additional style to the total lockers section
            out.print("<div class=\"total-lockers\">");
            out.print("<h2>Total Lockers: " + lockerCount + "</h2>");
            out.print("</div>");
            out.print("<form action=\"./ListLocker\" method=\"get\">");
            out.print("<input type=\"submit\" value=\"List\" />");
            out.print("</form>");
            out.print("<table>");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int total = rsmd.getColumnCount();
            out.print("<tr>");
            for (int i = 1; i <= total; i++) {
                out.print("<th>" + rsmd.getColumnName(i) + "</th>");
            }
            out.print("</tr>");
            while (rs.next()) {
                out.print("<tr>");
                for (int i = 1; i <= total; i++) {
                    out.print("<td>" + rs.getString(i) + "</td>");
                }
                out.print("</tr>");
            }
            out.print("</table>");
            out.print("<footer>");
            out.print("<p style=\"color: white;\">&copy; 2024 LockerDBMS. All rights reserved.</p>");
            out.print("</footer>");
            out.print("</body>");
            out.print("</html>");
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            out.close();
        }
    }
}

