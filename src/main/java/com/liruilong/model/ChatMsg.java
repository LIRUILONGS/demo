package com.liruilong.model;

import java.util.Date;


/**
 * @Author Liruilong
 * @Description  一对一聊天POJO
 * @Date 19:09 2020/2/11
 * @Param
 * @return
 **/

public class ChatMsg {
    private String from;
    private String to;
    private String content;
    private Date date;
    private String fromNickname;

    public String getFromNickname() {
        return fromNickname;
    }

    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ChatMsg{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", fromNickname='" + fromNickname + '\'' +
                '}';
    }
}
