package com.surn.quartz02.mapper;

import com.surn.quartz02.entity.Trigger;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TriggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trigger record);

    int insertSelective(Trigger record);

    Trigger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trigger record);

    int updateByPrimaryKey(Trigger record);

    /**
     * 查询触发器中包含的所有任务
     * @return
     */
    List<com.surn.quartz02.entity.Trigger> queryScheduleTriggerLst();
}