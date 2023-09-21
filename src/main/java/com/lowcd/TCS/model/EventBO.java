package com.lowcd.TCS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventBO {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String title;
    private String description;
    private List<Long> participants;

}
