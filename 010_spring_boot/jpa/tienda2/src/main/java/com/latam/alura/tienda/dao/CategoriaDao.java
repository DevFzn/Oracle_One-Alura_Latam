package com.latam.alura.tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;

public class CategoriaDao {

    private EntityManager em;
    
    public CategoriaDao(EntityManager em) {
        this.em = em;
    }
    
    public void guardar(Categoria categoria) {
        this.em.persist(categoria);
    }
    
    public void actualizar(Categoria categoria) {
        this.em.merge(categoria);
    }
    
    public void remover(Categoria categoria) {
        categoria = this.em.merge(categoria);
        this.em.remove(categoria);
    }

    public Categoria consultaPorId(Long id) {
        return em.find(Categoria.class, id);
    }
    
    public List<Categoria> consultarTodos() {
        String jpql = "SELECT P FROM Categoria AS P";
        return em.createQuery(jpql, Categoria.class).getResultList(); 
    }
}
