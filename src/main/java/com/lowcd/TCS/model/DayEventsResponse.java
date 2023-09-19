package com.lowcd.TCS.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * The `DayEventsResponse` class is a model representing a response for retrieving events
 * for a specific day, organized by user ID. It is used to structure and encapsulate
 * the response data in a clear and organized manner.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayEventsResponse {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private class Data {
        private long userId;
        private List<EventBO> events;
    }

    private List<Data> data = new ArrayList<>();

    public void addData(long userId, List<EventBO> events) {
        this.data.add(new Data(userId, events));
    }
}
