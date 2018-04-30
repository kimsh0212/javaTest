package com.ksh.user.repository;

import com.ksh.config.DBRoute;
import com.ksh.config.RoutingBaseSqlSessionRepository;
import com.ksh.config.SqlSessionTemplateType;
import com.ksh.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@DBRoute(SqlSessionTemplateType.KSH)
@Repository
public class UserRepository  extends RoutingBaseSqlSessionRepository {

    @Override
    protected String getSqlMapperPrefix() {return "user.";}

    public User selectUserInfo(Map<String, Object> params){
       return selectOne("selectUserInfo",params);
    }
}
