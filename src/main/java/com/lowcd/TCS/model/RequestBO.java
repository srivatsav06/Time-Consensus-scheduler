package com.lowcd.TCS.model;

import com.lowcd.TCS.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a Business Object (BO) for Request data.
 * This class is used for transferring request-related data between different parts of the application.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBO {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Status status;
    private String title;
    private String description;
    private List<Long> participants;
}
