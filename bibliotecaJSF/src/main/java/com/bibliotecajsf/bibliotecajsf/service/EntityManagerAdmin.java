package com.bibliotecajsf.bibliotecajsf.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.xml.stream.events.EntityReference;

public class EntityManagerAdmin {
    private static final String UNIDAD = "default";

    public static EntityManager getInstance() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory(UNIDAD);
        return emf.createEntityManager();
    }

    private EntityManagerAdmin(){}
}


// Datasource: su funcion es conectarse al apache tomcat, para manejar un pull de conexiones a la BD de forma automatica.
// pull de conexiones: