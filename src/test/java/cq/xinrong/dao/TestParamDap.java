package cq.xinrong.dao;

import cq.anbu.modules.bill.entity.AbParameterEntity;
import cq.anbu.modules.bill.service.AbParameterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestParamDap {
    @Autowired
    AbParameterService abParameterService;
    @Test
    public void test(){
        AbParameterEntity abParameter = new AbParameterEntity();
        abParameter.setParaParentCode("test");
        List<AbParameterEntity> paramList = abParameterService.queryParamList(abParameter);
        System.out.println(paramList.size());
    }
}
