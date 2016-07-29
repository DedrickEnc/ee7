/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tries;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author IMA7
 */
public class Calculus extends HttpServlet {   
    
    
    private int getSomme(int x, int y){        
        return x+y;        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));
            
            out.println("<h1> la somme est "+ getSomme(a, b) +"</h1>");
        } catch (Exception e) {
            out.println("erreur lors de la conversion");
        }
    }

   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
