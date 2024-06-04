package com.emergentes.bean;

import com.emergentes.entidades.Estudiante;
import com.emergentes.jpa.EstudianteJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanEstudiante {
    private EntityManagerFactory emf;
    private EstudianteJpaController jpaEstudiante;
    
    public BeanEstudiante(){
        emf = Persistence.createEntityManagerFactory("UPseguimiento");
        jpaEstudiante = new EstudianteJpaController(emf);
    }
    
    public List<Estudiante> listarTodos (){
        return jpaEstudiante.findEstudianteEntities();
    }
    public void insertar (Estudiante e){
        jpaEstudiante.create(e);
    }
    public void eliminar(Integer id){
        try{
            jpaEstudiante.destroy(id);
        }catch (NonexistentEntityException ex){
            System.out.println("ERROR" +ex);
        }
    }
    public void editar (Estudiante e){
        try{
            jpaEstudiante.edit(e);
        } catch (Exception ex) {
            System.out.println("error" +ex);
        }
    }
    public Estudiante buscar (Integer id)
    {
        Estudiante est = new Estudiante();
        est= jpaEstudiante.findEstudiante(id);
        return est;
    }
}
