package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/** Объект тикета */
public class Ticket {
    /** Название проблемы */
    private String title; //maxLength: 200

    // todo: остальные поля необходимые для заполнения тикета
    private Integer id; //readOnly: true
    private String due_date;
    @JsonIgnore
    private String assigned_to; //pattern: ^[\w.@+-]+$
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
    @JsonIgnore
    private Integer kbitem; //nullable. Knowledge base item the user was viewing when they created this ticket.
    @JsonIgnore
    private Integer merged_to; //nullable

    public String getTitle() {
        return title;
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

    public Integer getQueue() {
        return queue;
    }

    public Integer getKbitem() {
        return kbitem;
    }

    public Integer getMerged_to() {
        return merged_to;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setOn_hold(boolean on_hold) {
        this.on_hold = on_hold;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setLastEscalation(String lastEscalation) {
        this.lastEscalation = lastEscalation;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public void setKbitem(Integer kbitem) {
        this.kbitem = kbitem;
    }

    public void setMerged_to(Integer merged_to) {
        this.merged_to = merged_to;
    }
    // todo: методы get и set для остальных полей

    // todo: equals и hashCode
}
