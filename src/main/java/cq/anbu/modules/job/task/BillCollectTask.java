package cq.anbu.modules.job.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("billCollectTask")
public class BillCollectTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public void collectTask(){
        logger.info("--------------账单汇总任务开始！-------------");
        logger.info("--------------账单汇总任务结束！-------------");
    }
}
