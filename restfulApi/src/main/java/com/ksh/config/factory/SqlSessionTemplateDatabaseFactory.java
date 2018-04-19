package com.ksh.config.factory;
import org.mybatis.spring.SqlSessionTemplate;

public interface SqlSessionTemplateDatabaseFactory {
    SqlSessionTemplate getSqlSessionTemplate(String id);
}
