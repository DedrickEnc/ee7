/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tries;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author IMA7
 */
public class MyFirstServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFirstServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyFirstServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String prenom = request.getParameter("prenom");
        //        this is not the correct place to write this code
        //                TODO : fond the correct place for this code
        //                        configuring a cookie a setting httOnly to true
        //                        to avoid cross-site scripting (XSS)
        ServletContext context = request.getServletContext();
        
        SessionCookieConfig config = context.getSessionCookieConfig();
//        config.setHttpOnly(true); //this methode thrown error when called more the once
        
        
//        this line of code is for getting a session instance
        HttpSession session = request.getSession(true);      

        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFirstServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyFirstServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2> The parameter prenom is " + prenom + "</h2>");
            out.println("</body>");
            out.println("</html>");
//            context.getRequestDispatcher("/calculusURL").forward(request, response); //forwarding a request through the servlet context / is necessary to precise that we are looking from the current context
            request.getRequestDispatcher("calculusURL").forward(request, response); // forwarding from the request object, / is not important
           
        } finally {            
            out.close();
        }
        
        
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet is just a trial, a way of practicing the book theory";
    }
}
