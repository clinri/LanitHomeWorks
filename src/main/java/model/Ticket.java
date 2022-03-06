package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.Objects;

/**
 * Объект тикета (POJO)
 */
public class Ticket {
    // serialized поля, геттеры и сеттеры
    private Integer id; //readOnly: true
    private String due_date;
    private String assigned_to; //pattern: ^[\w.@+-]+$
    private String title; //maxLength: 200
    private String created; //Date this ticket was first created
    private String modified; //Date this ticket was most recently changed.
    private String submitter_email; //nullable. The submitter will receive an email for all public follow-ups left for this task.
    private Integer status;
    private boolean on_hold; //If a ticket is on hold, it will not automatically be escalated.
    private String description; //nullable. The content of the customers query.
    private String resolution; //nullable. The resolution provided to the customer by our staff.
    private Integer priority; //1 = Highest Priority, 5 = Low Priority
    private String lastEscalation; // readOnly: true. Updated automatically by management/commands/escalate_tickets.py
    private String secret_key; //Secret key needed for viewing/editing ticket by non-logged in users
    private Integer queue; //*
    //@JsonIgnore
    private Integer kbitem; //nullable. Knowledge base item the user was viewing when they created this ticket.
    //@JsonIgnore
    private Integer merged_to; //nullable

    public Ticket(String due_date, String title,
                  String submitter_email, Integer status,
                  boolean on_hold, String description, Integer priority, int queue) {
        this.due_date = due_date;
        this.title = title;
        this.submitter_email = submitter_email;
        this.status = status;
        this.on_hold = on_hold;
        this.description = description;
        this.priority = priority;
        this.queue = queue;
    }

    public Integer getId() {
        return id;
    }

    public String getDue_date() {
        return due_date;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public String getTitle() {
        return title;
    }

    public String getCreated() {
        return created;
    }

    public String getModified() {
        return modified;
    }

    public String getSubmitter_email() {
        return submitter_email;
    }

    public Integer getStatus() {
        return status;
    }

    public boolean isOn_hold() {
        return on_hold;
    }

    public String getDescription() {
        return description;
    }

    public String getResolution() {
        return resolution;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getLastEscalation() {
        return lastEscalation;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public int getQueue() {
        return queue;
    }

    public int getKbitem() {
        return kbitem;
    }

    public int getMerged_to() {
        return merged_to;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id.equals(ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}