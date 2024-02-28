package com.nikhil.maintainanceactivity.dto;

import lombok.*;

import java.sql.*;
@Data
public class MaintainActDto {
    private String type;
    private Timestamp startTime;
    private Timestamp endTime;
}
