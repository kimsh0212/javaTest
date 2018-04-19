package com.ksh.test.service;

import com.ksh.test.model.Test;
import com.ksh.test.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public Test selectUtcTimeInfoService(){
        Test result = testRepository.selectUtcTimeInfo();
        return result;
    }
}
