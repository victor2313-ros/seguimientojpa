package com.emergentes.controller;

import com.emergentes.bean.BeanEstudiante;
import com.emergentes.entidades.Estudiante;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*System.out.println("ESTAMOS EN EL SERVLET");
       nuevo();
       eliminar();
       mostrar();
       editar();
       mostrar();*/
        BeanEstudiante dao = new BeanEstudiante();
        Estudiante est = new Estudiante();
        List<Estudiante> lista = dao.listarTodos();
        int id;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("estudiante", est);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                est = dao.buscar(id);
                request.setAttribute("estudiante", est);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                response.sendRedirect("MainController");
                dao.eliminar(id);
                break;
            case "view":
                request.setAttribute("estudiante", lista);
                request.getRequestDispatcher("estudiante.jsp").forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanEstudiante dao = new BeanEstudiante();
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String fechaNac = request.getParameter("fechaNac");

        Estudiante est = new Estudiante();
        est.setId(id);
        est.setNombres(nombres);
        est.setApellidos(apellidos);
        est.setEmail(email);
        est.setFechaNac(convierteFecha(fechaNac));
        

        if (id > 0) {
            dao.editar(est);
        } else {
            dao.insertar(est);
        }
        response.sendRedirect("MainController");
    }

    public java.sql.Date convierteFecha(String fechaNac) {
        java.sql.Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fechaTMP = formato.parse(fechaNac);
            fechaBD = new java.sql.Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return fechaBD;
    }
    /*private void eliminar(){
        BeanEstudiante dao=new BeanEstudiante();
        Integer id= 3;
        dao.eliminar(id);
    }
    public void editar(){
       BeanEstudiante dao=new BeanEstudiante();
       Integer id= 2;
       Estudiante e =  dao.buscar(id);
       e.setNombres("Juan");
        e.setApellidos("Perez");
        e.setEmail("juan.perez@example.com");
        e.setFechaNac(new java.sql.Date(System.currentTimeMillis()));
        dao.editar(e);
    }
        private void nuevo() {
        BeanEstudiante dao = new BeanEstudiante();
        Estudiante e = new Estudiante();
        e.setNombres("Juan");
        e.setApellidos("Perez");
        e.setEmail("juan.perez@example.com");
        e.setFechaNac(new java.sql.Date(System.currentTimeMillis()));
        dao.insertar(e);
    }
    private void mostrar(){
        BeanEstudiante dao=new BeanEstudiante();
        List<Estudiante> lista = dao.listarTodos();
        
        for (Estudiante item : lista){
            System.out.println(item.toString());
        }
    }*/
}
