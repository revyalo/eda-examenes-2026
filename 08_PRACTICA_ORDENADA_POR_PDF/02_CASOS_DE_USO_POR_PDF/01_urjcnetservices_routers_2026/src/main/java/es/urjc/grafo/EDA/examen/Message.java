package es.urjc.grafo.EDA.examen;

import java.net.InetAddress;
import java.util.Date;
import java.util.Objects;

public class Message {
    private final int id;
    private final InetAddress originIP;
    private final Date date;

    public Message(int id, InetAddress origin, Date date) {
        if (date == null) throw new IllegalArgumentException();
        this.id = id;
        this.originIP = origin;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public InetAddress getOrigin() {
        return originIP;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return getId() == message.getId() && originIP.equals(message.originIP) && getDate().equals(message.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), originIP, getDate());
    }
}
