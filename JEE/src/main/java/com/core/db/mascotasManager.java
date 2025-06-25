package com.core.db;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.core.modules.entityclasses.Mascotas;

public class mascotasManager {
    public EntityManagerFactory emf = 
    Persistence.createEntityManagerFactory(
        "com.core_JEE_jar_1.0-SNAPSHOTPU");

    public Mascotas findMascota(int ID){
        EntityManager em = emf.createEntityManager();
        
        Query query1 = em.createNamedQuery("Mascotas.findByIdMascota",Mascotas.class);
        
        return (Mascotas) query1.setParameter("idMascota",ID).getSingleResult();

    }

    @SuppressWarnings("unchecked")
    public List<Mascotas> findByLimitAndRace(int limit, String filterRace){
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createNamedQuery("Mascotas.findAll");

        Stream<Mascotas> stream = q1.getResultStream();
        return stream.filter((Mascotas m) -> m.getActivo())
        .limit(limit)
        .toList();

    }


}
