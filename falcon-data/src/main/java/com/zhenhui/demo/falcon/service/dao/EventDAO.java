package com.zhenhui.demo.falcon.service.dao;

import com.zhenhui.demo.falcon.core.domain.Event;
import com.zhenhui.demo.falcon.service.mybatis.mapper.EventMapper;
import com.zhenhui.demo.falcon.service.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Component
public class EventDAO {

    @Autowired
    private EventMapper eventMapper;

    public boolean createEvent(Event event) {
        try {
            return eventMapper.insert(event) > 0;
        } catch (Exception e) {
            if (ExceptionUtils.hasDuplicateEntryException(e)) {
                return true;
            }

            throw e;
        }
    }

}




