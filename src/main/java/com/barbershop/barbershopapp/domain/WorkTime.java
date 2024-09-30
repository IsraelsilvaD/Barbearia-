package com.trimtime.app.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Worktimes")
public class WorkTime {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private LocalDateTime startTime;

private LocalDateTime endTime;

@ManyToOne
@joinColumn(name = "user_id")
private User user;

}
