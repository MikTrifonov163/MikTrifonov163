package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet(name = "CheckSrv", urlPatterns = {"/CheckSrv"})
public class CheckSrv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            String text = "YT dthyst bvz/gfhjkm";

            String name = request.getParameter("name");
            String pwd = request.getParameter("password");

            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/mydb");

            Connection con;
            Statement st;
            int userId = -1;

            con = ds.getConnection();
            st = con.createStatement();
            String qu = "SELECT user_id FROM ADMINSTUD.USERS WHERE name = '" + name + "' AND pwd='" + pwd + "'";
            System.out.println("-------" + qu);
            ResultSet rs = st.executeQuery(qu);

            if (rs.next()) {
                userId = rs.getInt("user_id");
                System.out.println("-------" + userId);
            }
            con.close();
            if (userId > 0) {// прошли регу
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                session.setAttribute("DataSource", ds);

                String path = "/subdir.jsp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
            } else {// не прошли регу
                
                
                
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                session.setAttribute("DataSource", ds);

                String path = "/subdir2.jsp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
                
                

            }

        } catch (NamingException ex) {
            Logger.getLogger(CheckSrv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CheckSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Сервлет проверки регистрацтт";
    }// </editor-fold>

}
