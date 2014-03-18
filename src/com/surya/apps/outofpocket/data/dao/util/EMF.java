package com.surya.apps.outofpocket.data.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
	private static final String EMF_NAME = "out-of-office-web";
    private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory(EMF_NAME);

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}