package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Despliegue.fachadaCompCatalogoRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns = {"/controladorNuevaConfiguracion"})
public class controladorNuevaConfiguracion extends HttpServlet {
    @EJB
    private fachadaCompCatalogoRemote fachadaCompCatalogo;

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
        
        String velCPUS = request.getParameter("velocidad");
        String capRAMS = request.getParameter("ram");
        String capDDS = request.getParameter("dd");
        String velTarGrafS = request.getParameter("velGraf");
        String memTarGrafS = request.getParameter("memGraf");
        String idTipoCPUS = request.getParameter("tipoCPU");
        String idsDescrComp = request.getParameter("componentes");
        String idS = request.getParameter("idConf");
        
        String message="";
        
        if(velCPUS.equals("") || capRAMS.equals("")||capDDS.equals("")||velTarGrafS.equals("")||
                memTarGrafS.equals("")||idTipoCPUS.equals("")||idsDescrComp.equals("")||idS.equals("")){
            message = "Menú principal";
            session.setAttribute("mensaje",message);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
        }

        int velCPU = Integer.parseInt(velCPUS);
        int capRAM = Integer.parseInt(capRAMS);
        int capDD = Integer.parseInt(capDDS);
        int velTarGraf = Integer.parseInt(velTarGrafS);
        int memTarGraf = Integer.parseInt(memTarGrafS);
        short idTipoCPU = Short.parseShort(idTipoCPUS);
        
        List<Integer> componentes = new ArrayList<>();
        componentes.add(Integer.parseInt(idsDescrComp));
        

        String url="/empleado.jsp";
        
        
        boolean success;
        if(request.getParameter("envioNC")!=null){
            success=fachadaCompCatalogo.addConfiguracion(velCPU, capRAM, capDD, velTarGraf, memTarGraf, idTipoCPU, componentes);
            if(success){
                message="Nueva configuración con éxito";
            }else{
                message="Error al añadir nueva configuración";
            }
            session.setAttribute("mensaje",message);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
        }else if(request.getParameter("envioEC")!=null){
            int id = Integer.parseInt(idS);
            success=fachadaCompCatalogo.editConfiguracion(id,velCPU, capRAM, capDD, velTarGraf, memTarGraf, idTipoCPU);
            if(success){
                message="Editada configuración con éxito";
            }else{
                message="Error al editar configuración";
            }
            session.setAttribute("mensaje",message);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
        }else if(request.getParameter("envioSalir")!=null){
            message = "Página principal";
            session.setAttribute("mensaje",message);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
        }
        
        
        
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
