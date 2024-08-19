package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteLocker
 */
@WebServlet("/DeleteLocker")
public class DeleteLocker extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
public DeleteLocker() {
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
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/locker?characterEncoding=latin1",
					"root", "Deek2003");
			PreparedStatement ps = con.prepareStatement("delete from addlocker where locker_id=?");
			ps.setInt(1, rn);
			ps.executeUpdate();
			out.println("Deleted Successfully");
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			out.close();
		}
	}
}
