package com.kat.lap_trinh_web.common.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, Date> birthDay;
	public static volatile SingularAttribute<UserEntity, String> code;
	public static volatile SingularAttribute<UserEntity, Integer> permission;
	public static volatile SingularAttribute<UserEntity, String> training;
	public static volatile SingularAttribute<UserEntity, Boolean> published;
	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, Timestamp> createdDate;
	public static volatile SingularAttribute<UserEntity, String> name;
	public static volatile SingularAttribute<UserEntity, Timestamp> lastModified;
	public static volatile SingularAttribute<UserEntity, Integer> id;
	public static volatile SingularAttribute<UserEntity, String> email;
	public static volatile SingularAttribute<UserEntity, Integer> status;
	public static volatile SingularAttribute<UserEntity, String> username;

}

