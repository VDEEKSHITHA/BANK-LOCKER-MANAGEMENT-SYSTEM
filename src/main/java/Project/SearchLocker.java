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
 * Servlet implementation class SearchLocker
 */
@WebServlet("/SearchLocker")
public class SearchLocker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchLocker() {
		super();
	}

// TODO Auto-generated constructor stub}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			String rno = request.getParameter("lockerId");
			int rn = Integer.valueOf(rno);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/locker?characterEncoding=latin1",
					"root", "Deek2003");
			PreparedStatement ps = con.prepareStatement("select * from addlocker where locker_id=?");
			ps.setInt(1, rn);
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset=\"UTF-8\">");
			out.print("<title>Search Result</title>");
			out.print("<style>");
			out.print("table {");
			out.print("    width: 50%;");
			out.print("    border-collapse: collapse;");
			out.print("    margin: 20px auto;");
			out.print("}");
			out.print("th, td {");
			out.print("    padding: 8px;");
			out.print("    text-align: center;");
			out.print("    border: 1px solid #ddd;");
			out.print("}");
			out.print("th {");
			out.print("    background-color: #f2f2f2;");
			out.print("}");
			out.print("</style>");
			out.print("</head>");
			out.print("<body>");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int total = rsmd.getColumnCount();
			out.print("<table>");
			out.print("<tr>");
			for (int i = 1; i <= total; i++) {
				out.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			while (rs.next()) {
				out.print("<tr>");
				for (int i = 1; i <= total; i++) {
					out.print("<td>" + rs.getString(i) + "</td>");
				}
				out.print("</tr>");
			}
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			out.close();
		}
	}
}
