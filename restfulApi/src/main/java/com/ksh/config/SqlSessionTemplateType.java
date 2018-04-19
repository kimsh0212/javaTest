package com.ksh.config;

public enum SqlSessionTemplateType {
    KSH("local");

    private String id;

    SqlSessionTemplateType(String sqlTemplateId){this.id = sqlTemplateId;}

    public String getId(){return id;}
}
