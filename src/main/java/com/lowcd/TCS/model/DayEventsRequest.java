package com.lowcd.TCS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
/**
 * The `DayEventsRequest` class is a model representing a request for retrieving events
 * for a specific day, based on a list of user IDs and the target date.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayEventsRequest {
    private List<Long> ids;
    private LocalDate date;

}
