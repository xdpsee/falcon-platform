/*
 * Copyright 2016 Anton Tananaev (anton@traccar.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhenhui.demo.falcon.core.support.event;

import java.util.Collection;
import java.util.Collections;

import com.zhenhui.demo.falcon.core.domain.Event;
import com.zhenhui.demo.falcon.core.domain.EventType;
import com.zhenhui.demo.falcon.core.domain.Position;
import com.zhenhui.demo.falcon.core.server.ServerConnector;
import com.zhenhui.demo.falcon.core.support.handler.AbstractEventHandler;

public class AlertEventHandler extends AbstractEventHandler {

    public AlertEventHandler(ServerConnector connector) {
        super(connector);
    }

    @Override
    protected Collection<Event> analyzePosition(Position position) {
        String alarm = position.getString(Position.KEY_ALARM);
        if (alarm != null) {
            Event event = new Event(EventType.TYPE_ALARM, position.getDeviceId(), position.getId());
            event.set(Position.KEY_ALARM, alarm);
            return Collections.singleton(event);
        }

        return null;
    }

}
