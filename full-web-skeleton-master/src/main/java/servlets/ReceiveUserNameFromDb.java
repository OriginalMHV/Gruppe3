package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TableModel;
import tools.repository.UserRepository;


@WebServlet(name = "ReceiveUserNameFromDb", urlPatterns = {"/ReceiveUserNameFromDb"})
public class ReceiveUserNameFromDb extends AbstractAppServlet {
    /**
     * Tar imot http requesten og kaller på writeResponse()
     *
     * @param request  objektet sender data til servletet
     * @param response objektet sender data fra servleten.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        writeResponse(request, response, "Hello!");
    }

    /**
     * skriver ut body på servlet som html.
     *
     * @param req http request objektet med data.
     * @param out http respons objektet som sender data.
     */
    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
        String username = req.getParameter("uname");
        List<TableModel> tableModelList = UserRepository.getResults(out);

        out.println("<h1> here is your results: ");
        out.println("<table classname='table table-dark'>");
        out.println("<tr>");
        out.println("<th scope=col> Rank </th>");
        out.println("<th scope=col> Score </th>");
        out.println("<th scope=col> Navn </th>");
        out.println("<th scope=col> Klubb</th> ");
        out.println("</tr>");
        for (TableModel model : tableModelList) {

            out.format(" <tr><td> %s </td><td> %s </td><td> %s </td><td> %s </td> <td>  %s </td> <td>  %s </td> <td> %s </td> </tr>", model.getSargeant(),
                    model.getRank(), model.getFødt(), model.getKlubb(),model.getMeter2000(), model.getMeter3000(),model.getNavn());
        }
        req.setAttribute("liste", tableModelList);


    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Alle get forespørsler til denne servleten blir håndert av doGEt.
     * får servleten en Get request vil den svare med doGet som kaller på metoden process Request.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("/viewSearch.jsp");
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
