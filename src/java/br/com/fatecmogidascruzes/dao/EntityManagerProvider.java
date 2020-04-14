/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Josias Wattrelos
 */
public class EntityManagerProvider {

    /* Deprecated */
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal<Session> session = new ThreadLocal<Session>();

    static {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
        } catch (Throwable th) {
            System.err.println("Enitial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    // Constructor:
    private EntityManagerProvider() {
    } //maling the Hibernate SessionFactory object as singleton 

    public static Session getSession() {
        Session localsession = EntityManagerProvider.session.get();
        if (localsession == null) {
            localsession = sessionFactory.openSession();
            EntityManagerProvider.session.set(localsession);
        }
        return localsession;
    }
}
