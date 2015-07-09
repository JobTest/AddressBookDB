package main.java.com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataFactory {

    private static SessionFactory sessionFactory;

    private DataFactory(){}

    /* корень проекта, папка - 'src' - ложим сюда в корень конфигурационный файл 'hibernate.cfg.xml' (по умолчанию, чтобы не делать хитрых путей...); 'Configuration' || 'AnnotationConfiguration' */
    public static SessionFactory getInstance() throws ExceptionInInitializerError {
        return sessionFactory == null ? sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory() : sessionFactory;
    }

}