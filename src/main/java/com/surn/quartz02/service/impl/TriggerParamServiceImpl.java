package com.surn.quartz02.service.impl;

import com.surn.quartz02.entity.TriggerParam;
import com.surn.quartz02.mapper.TriggerParamMapper;
import com.surn.quartz02.service.TriggerParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @site www..comz-surn
 * @company 公司
 * @create  2019-03-26 10:26
 */
@Service
public class TriggerParamServiceImpl  implements TriggerParamService {

    @Autowired
    private TriggerParamMapper triggerParamMapper;

    @Override
    public List<TriggerParam> queryScheduleParamLst(Integer triggerId) {
        return triggerParamMapper.queryScheduleParamLst(triggerId);
    }
}
