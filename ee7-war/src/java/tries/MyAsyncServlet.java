/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tries;

import classes.MyAsyncService;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author IMA7
 */
public class MyAsyncServlet extends HttpServlet {

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

        //getting the async context from the request, request 
        //will be processed in this context
        AsyncContext ac = request.startAsync();

        //adding listener on the context

        ac.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                System.out.println("traitement de la requette termine");
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                System.out.println("delai depasse");

            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                System.out.println("Erreur lors du traitement");
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                System.out.println("Debut traitement requette");

            }
        });

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
        scheduledThreadPoolExecutor.execute(new MyAsyncService(ac));

    }
}
