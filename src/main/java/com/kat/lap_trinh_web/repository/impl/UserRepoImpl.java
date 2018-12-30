package com.kat.lap_trinh_web.repository.impl;

import com.kat.lap_trinh_web.common.constant.UserTypeConst;
import com.kat.lap_trinh_web.common.model.UserEntity;
import com.kat.lap_trinh_web.common.constant.UserTypeConst;
import com.kat.lap_trinh_web.common.model.UserEntity_;
import com.kat.lap_trinh_web.repository.interfaces.UserRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity getUserByUsernameAndPassword(String username, String md5_password) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.isNotNull(root.get(UserEntity_.id)));
        predicates.add(builder.equal(root.get(UserEntity_.username), username));
        predicates.add(builder.equal(root.get(UserEntity_.password), md5_password));
        criteriaQuery.select(root).where(predicates.stream().toArray(Predicate[]::new));
        final TypedQuery<UserEntity> query = entityManager.createQuery(criteriaQuery);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<UserEntity> findAll(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.isNotNull(root.get(UserEntity_.code)));
        criteriaQuery.select(root).where(predicates.stream().toArray(Predicate[]::new));
        final TypedQuery<UserEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<UserEntity> findAllLecturers(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.isNotNull(root.get(UserEntity_.id)));
        predicates.add(builder.equal(root.get(UserEntity_.permission),UserTypeConst.CANBO));
        criteriaQuery.select(root).where(predicates.stream().toArray(Predicate[]::new));
        final TypedQuery<UserEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<UserEntity> findAllStudent(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.isNotNull(root.get(UserEntity_.id)));
        predicates.add(builder.equal(root.get(UserEntity_.permission),UserTypeConst.SINHVIEN));
        criteriaQuery.select(root).where(predicates.stream().toArray(Predicate[]::new));
        final TypedQuery<UserEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(UserEntity userEntity) {
        userEntity.setLastModified(new Timestamp(new Date().getTime()));
        entityManager.merge(userEntity);
    }

    @Override
    @Transactional
    public void add(UserEntity userEntity) {
        userEntity.setLastModified(new Timestamp(new Date().getTime()));
        entityManager.merge(userEntity);
    }

    @Override
    @Transactional
    public void delete(UserEntity userEntity) {
        entityManager.remove(userEntity);
    }

    @Override
    public UserEntity findById(Integer userId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(root.get(UserEntity_.id), userId));
        criteriaQuery.select(root).where(predicates.stream().toArray(Predicate[]::new));
        final TypedQuery<UserEntity> query = entityManager.createQuery(criteriaQuery);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    @Override
    public UserEntity findByEmail(String email) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.isNotNull(root.get(UserEntity_.id)));
        predicates.add(builder.equal(root.get(UserEntity_.email), email));
        criteriaQuery.select(root).where(predicates.stream().toArray(Predicate[]::new));
        final TypedQuery<UserEntity> query = entityManager.createQuery(criteriaQuery);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    @Override
    public UserEntity findByUserName(String username) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.isNotNull(root.get(UserEntity_.id)));
        predicates.add(builder.equal(root.get(UserEntity_.username), username));
        criteriaQuery.select(root).where(predicates.stream().toArray(Predicate[]::new));
        final TypedQuery<UserEntity> query = entityManager.createQuery(criteriaQuery);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
