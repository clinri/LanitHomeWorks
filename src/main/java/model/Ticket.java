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
    @JsonIgnore
    private String assigned_to; //pattern: ^[\w.@+-]+$
    private String title; //maxLength: 200
    private String created; //Date this ticket was first created
    private String modified; //Date this ticket was most recently changed.
    private String submitter_email; //nullable. The submitter will receive an email for all public follow-ups left for this task.
    private Enum<Status> status;
    private boolean on_hold; //If a ticket is on hold, it will not automatically be escalated.
    private String description; //nullable. The content of the customers query.
    private String resolution; //nullable. The resolution provided to the customer by our staff.
    private Integer priority; //1 = Highest Priority, 5 = Low Priority
    @JsonIgnore
    private String lastEscalation; // readOnly: true. Updated automatically by management/commands/escalate_tickets.py
    private String secret_key; //Secret key needed for viewing/editing ticket by non-logged in users
    private int queue;
    @JsonIgnore
    private int kbitem; //nullable. Knowledge base item the user was viewing when they created this ticket.
    @JsonIgnore
    private int merged_to; //nullable

    public Ticket(String due_date, String title, String created, String modified, String submitter_email,
                  Enum<Status> status, boolean on_hold, Integer priority, int queue) {
        this.due_date = due_date;
        this.title = title;
        this.created = created;
        this.modified = modified;
        this.submitter_email = submitter_email;
        this.status = status;
        this.on_hold = on_hold;
        this.priority = priority;
        this.queue = queue;
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