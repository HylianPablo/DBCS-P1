package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Despliegue.FachadaCompUsuarioLocal;
import Dominio.Empleado;
import Dominio.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Propietario
 */
@WebServlet(urlPatterns = {"/controladorIndex"})
public class controladorIndex extends HttpServlet {
    @EJB
    private FachadaCompUsuarioLocal fachadaCompUsuario;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String nifcif = request.getParameter("NifCif");
        String password = request.getParameter("clave");
        String url="";
        String message="";

        Empresa empresa = fachadaCompUsuario.getEmpresa(nifcif);
        if(empresa!=null){
            if(empresa.getUsuario().getPassword().equals(password) && request.getParameter("botonC")!=null){
                url = "/cliente.jsp";
                message="Bienvenido cliente";
                
            }else{
                message = "Contraseña incorrecta";
                url = "/index.jsp";
            }
        }else{
            Empleado empleado = fachadaCompUsuario.getEmpleado(nifcif);
            if(empleado!=null){
                if(empleado.getUsuario().getPassword().equals(password) && request.getParameter("botonE")!=null){
                    message="Bienvenido empleado";
                    url = "/empleado.jsp";
                }else{
                    message="Contraseña incorrecta";
                    url = "/index.jsp";
                }
            }else{
                message="Usuario incorrecto";
                url = "/index.jsp";
            }
        }
        session.setAttribute("NifCif",nifcif);
        session.setAttribute("mensaje",message);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
        return "Short description";
    }// </editor-fold>

}
