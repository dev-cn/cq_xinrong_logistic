package cq.anbu.modules.bill.service.impl;


import cq.anbu.modules.bill.dao.BillCollectTaskDao;
import cq.anbu.modules.bill.service.BillCollectTaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BillCollectTaskServiceImpl implements BillCollectTaskService {
    @Autowired
    BillCollectTaskDao billCollectTaskDao;
    @Override
    public void collectMoney() {
        List<String> billTablesNameList = billCollectTaskDao.queryAllBillTables();

    }
}
