package com.chathu;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.BinaryLogClient.EventListener;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.EventType;

import java.io.IOException;

class MysqlBinLogReader {

    static void captureChanges() {
        BinaryLogClient client = new BinaryLogClient("localhost", 3306, "root", "1234");
        client.registerEventListener(new EventListener() {

            @Override
            public void onEvent(Event event) {
                //Print details for INSERT, UPDATE, DELETE events.
                EventType eventType = event.getHeader().getEventType();
                if (eventType.equals(EventType.EXT_DELETE_ROWS) ||
                        eventType.equals(EventType.EXT_UPDATE_ROWS) ||
                        eventType.equals(EventType.EXT_WRITE_ROWS)) {
                    System.out.println("\nEvent occured.");
                    System.out.println(event.toString());
                }
            }
        });
        try {
            client.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
