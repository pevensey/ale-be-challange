package com.rest.ale.be.repository;

import com.rest.ale.be.model.Kelas;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class KelasRepositoryImpl implements KelasRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public void persist(Kelas kelas) {
        em.persist(kelas);
    }

}
