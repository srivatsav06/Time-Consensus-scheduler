package com.lowcd.TCS.model;

import com.lowcd.TCS.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBO {
    private LocalDateTime dateTime;
    private Status status;
    private String title;
    private String description;
    private List<Long> participants;
}
