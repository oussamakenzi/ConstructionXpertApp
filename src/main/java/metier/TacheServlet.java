package metier;

import dao.ITacheDao;
import dao.ITacheDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tache;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/tache")
public class TacheServlet extends HttpServlet {
    private ITacheDao tacheDAO;

    @Override
    public void init() {
        tacheDAO = new ITacheDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "listTache":
                    listTaches(request, response);
                    break;
                case "newTache":
                    showNewForm(request, response);
                    break;
                case "insertTache":
                    insertTache(request, response);
                    break;
                case "deleteTache":
                    deleteTache(request, response);
                    break;
                case "editTache":
                    showEditForm(request, response);
                    break;
                case "updateTache":
                    updateTache(request, response);
                    break;
                default:
                    listTaches(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listTaches(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idProjet = Integer.parseInt(request.getParameter("idProjet"));
        List<Tache> listTache = tacheDAO.listAllTachesByProjet(idProjet);
        request.setAttribute("listTache", listTache);
        request.setAttribute("idProjet", idProjet);
        request.getRequestDispatcher("WEB-INF/listTache.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProjet = Integer.parseInt(request.getParameter("idProjet"));
        request.setAttribute("idProjet", idProjet);
        request.getRequestDispatcher("newTache.jsp").forward(request, response);
    }

    private void insertTache(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nom = request.getParameter("nomTache");
        String description = request.getParameter("description");
        LocalDate dateDbTache = LocalDate.parse(request.getParameter("dateDbTache"));
        LocalDate dateFinTache = LocalDate.parse(request.getParameter("dateFinTache"));
        String status = request.getParameter("status");
        int idProjet = Integer.parseInt(request.getParameter("idProjet"));

        Date startDate = Date.valueOf(dateDbTache);
        Date endDate = Date.valueOf(dateFinTache);
        Tache newTache = new Tache(0, nom, description, startDate, endDate, status, idProjet);
        tacheDAO.insertTache(newTache);
        response.sendRedirect("tache?action=listTache&idProjet=" + idProjet);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idTache = Integer.parseInt(request.getParameter("idTache"));
        Tache existingTache = tacheDAO.getTache(idTache);
        request.setAttribute("tache", existingTache);
        request.getRequestDispatcher("editTache.jsp").forward(request, response);
    }

    private void updateTache(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idTache = Integer.parseInt(request.getParameter("idTache"));
        String nom = request.getParameter("nomTache");
        String description = request.getParameter("description");
        LocalDate dateDbTache = LocalDate.parse(request.getParameter("dateDbTache"));
        LocalDate dateFinTache = LocalDate.parse(request.getParameter("dateFinTache"));
        String status = request.getParameter("status");
        int idProjet = Integer.parseInt(request.getParameter("idProjet"));
        Date startDate = Date.valueOf(dateDbTache);
        Date endDate = Date.valueOf(dateFinTache);
        Tache tache = new Tache(idTache, nom, description, startDate, endDate, status, idProjet);
        tacheDAO.updateTache(tache);
        response.sendRedirect("tache?action=listTache&idProjet=" + idProjet);
    }

    private void deleteTache(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idTache = Integer.parseInt(request.getParameter("idTache"));
        Tache tache = tacheDAO.getTache(idTache);
        tacheDAO.deleteTache(idTache);
        response.sendRedirect("tache?action=listTache&idProjet=" + tache.getIdProjet());
    }
}
