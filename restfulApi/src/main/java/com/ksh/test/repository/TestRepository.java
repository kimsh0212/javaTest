package com.ksh.test.repository;

import com.ksh.config.DBRoute;
import com.ksh.config.SqlSessionTemplateType;
import com.ksh.test.model.Test;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import com.ksh.config.RoutingBaseSqlSessionRepository;

@DBRoute(SqlSessionTemplateType.KSH)
@Repository
public class TestRepository extends RoutingBaseSqlSessionRepository{
    @Override
    protected String getSqlMapperPrefix() {return "test.";}

    public Test selectUtcTimeInfo(){
        return selectOne("testTime");
    }
}
