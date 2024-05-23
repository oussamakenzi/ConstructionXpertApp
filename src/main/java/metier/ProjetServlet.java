package metier;

import dao.IProjetDao;
import dao.IProjetDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Projet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class ProjetServlet extends HttpServlet {
    private IProjetDao iProjetDao;

    public void init() {
        iProjetDao = new IProjetDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertProjet(request, response);
                    break;
                case "/delete":
                    deleteProjet(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateProjet(request, response);
                    break;
                default:
                    listProjet(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listProjet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Projet> listProjet = iProjetDao.getAllProjets();
        request.setAttribute("listProjet", listProjet);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("projet-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProjet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nomProjet = request.getParameter("nomProjet");
        String description = request.getParameter("description");
        Date dateDebut = Date.valueOf(request.getParameter("dateDebut"));
        Date dateFin = Date.valueOf(request.getParameter("dateFin"));
        double budget = Double.parseDouble(request.getParameter("budget"));

        Projet newProjet = new Projet();
        newProjet.setNomProjet(nomProjet);
        newProjet.setDescription(description);
        newProjet.setDateDebut(dateDebut);
        newProjet.setDateFin(dateFin);
        newProjet.setBudget(budget);

        iProjetDao.addProjet(newProjet);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Projet existingProjet = iProjetDao.getProjet(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("projet-form.jsp");
        request.setAttribute("projet", existingProjet);
        dispatcher.forward(request, response);
    }

    private void updateProjet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nomProjet = request.getParameter("nomProjet");
        String description = request.getParameter("description");
        Date dateDebut = Date.valueOf(request.getParameter("dateDebut"));
        Date dateFin = Date.valueOf(request.getParameter("dateFin"));
        double budget = Double.parseDouble(request.getParameter("budget"));

        Projet projet = new Projet();
        projet.setIdProjet(id);
        projet.setNomProjet(nomProjet);
        projet.setDescription(description);
        projet.setDateDebut(dateDebut);
        projet.setDateFin(dateFin);
        projet.setBudget(budget);

        iProjetDao.updateProjet(projet);
        response.sendRedirect("list");
    }

    private void deleteProjet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        iProjetDao.deleteProjet(id);
        response.sendRedirect("list");
    }
}
