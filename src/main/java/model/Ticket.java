package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * Объект тикета (POJO)
 */
public class Ticket {
    // serialized поля, геттеры и сеттеры
    @SerializedName("id")
    private int id;

    @SerializedName("due_date")
    private String dueDate;

    @JsonIgnore
    @SerializedName("assigned_to")
    private Integer assignedTo;

    @SerializedName("title")
    private String title;

    @SerializedName("created")
    private String created;

    @SerializedName("modified")
    private String modified;

    @SerializedName("submitter_email")
    private String submitterEmail;

    @SerializedName("status")
    private Enum<Status> status;

    @SerializedName("on_hold")
    private Boolean onHold;

    @SerializedName("description")
    private String description;

    @SerializedName("resolution")
    private String resolution;

    @SerializedName("priority")
    private int priority;

    @SerializedName("last_escalation")
    private String lastEscalation;

    @SerializedName("secret_key")
    private int secretKey;

    @SerializedName("queue")
    private int queue;

    @JsonIgnore
    @SerializedName("kbitem")
    private Integer kbitem;

    @JsonIgnore
    @SerializedName("merged_to")
    private Integer mergedTo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}