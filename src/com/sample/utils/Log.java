package com.sample.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Log {
    private static Log log;
    private String event;
    private Date at;

    private Log(){

    }

    public static Log getLog() {
        if(log ==null){
            log = new Log();
        }
        return log;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getAt() {
        return at;
    }

    public void setAt(Date at) {
        this.at = at;
    }

    public void write(String event){
        Auth.getAuth().getSession().setTimer(300000);
        this.event = new String();
        this.at = new Date();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH'h'mm");

        this.setEvent("["+dateFormat.format(this.at)+"] "+event+"\n");

        try {
            Database.getInstance().set("INSERT INTO event VALUES(null,d,task);");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String read(){
        List<Log> logs = new ArrayList<>();
        try {
            ResultSet rs = Database.getInstance().get("SELECT * FROM event ORDER BY at DESC");
            while (rs.next()) {
                Log log = new Log();
                log.setAt(rs.getDate("date"));
                log.setEvent(rs.getString("event"));
                logs.add(log);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return logs.toString();
    }
}
