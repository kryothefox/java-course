/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todolist.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tasks")
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t"),
    @NamedQuery(name = "Tasks.findByTaskId", query = "SELECT t FROM Tasks t WHERE t.taskId = :taskId"),
    @NamedQuery(name = "Tasks.findByTaskName", query = "SELECT t FROM Tasks t WHERE t.taskName = :taskName"),
    @NamedQuery(name = "Tasks.findByCreationDate", query = "SELECT t FROM Tasks t WHERE t.creationDate = :creationDate"),
    @NamedQuery(name = "Tasks.findByLimitDate", query = "SELECT t FROM Tasks t WHERE t.limitDate = :limitDate"),
    @NamedQuery(name = "Tasks.findByTaskState", query = "SELECT t FROM Tasks t WHERE t.taskState = :taskState"),
    @NamedQuery(name = "Tasks.findByIsComplete", query = "SELECT t FROM Tasks t WHERE t.isComplete = :isComplete")})
public class Tasks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_id")
    private Integer taskId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "task_name")
    private String taskName;
    @Lob
    @Size(max = 65535)
    @Column(name = "task_description")
    private String taskDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limit_date")
    @Temporal(TemporalType.DATE)
    private Date limitDate;
    @Size(max = 11)
    @Column(name = "task_state")
    private String taskState;
    private Boolean isComplete;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AppUser userId;

    public Tasks() {
    }

    public Tasks(Integer taskId) {
        this.taskId = taskId;
    }

    public Tasks(Integer taskId, String taskName, Date creationDate, Date limitDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.creationDate = creationDate;
        this.limitDate = limitDate;
    }

    public Tasks(String taskName, String taskDescription, Date limitDate, String taskState) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.creationDate = new Date();
        this.limitDate = limitDate;
        this.taskState = taskState;
        this.isComplete = taskState.equals("completed");
    }

    public Tasks(String taskName, String taskDescription, Date limitDate, String taskState, AppUser userId) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.creationDate = new Date();
        this.limitDate = limitDate;
        this.taskState = taskState;
        this.isComplete = taskState.equals("completed");
        this.userId = userId;
    }

    public Tasks(Integer taskId, String taskName, String taskDescription, Date creationDate, Date limitDate, String taskState, Boolean isComplete) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.creationDate = creationDate;
        this.limitDate = limitDate;
        this.taskState = taskState;
        this.isComplete = isComplete;
    }

    
    
    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    public AppUser getUserId() {
        return userId;
    }

    public void setUserId(AppUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tasks{" + "taskId=" + taskId + ", taskName=" + taskName + ", taskDescription=" + taskDescription + ", creationDate=" + creationDate + ", limitDate=" + limitDate + ", taskState=" + taskState + ", isComplete=" + isComplete + ", userId=" + userId + '}';
    }

}
