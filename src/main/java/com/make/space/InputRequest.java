package com.make.space;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InputRequest {

    private String operationType;
    private String startTime;
    private String endTime;
    private Integer numberOfMembers;

    public InputRequest(String operationType, String startTime, String endTime) {

        this.operationType = operationType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public InputRequest(String operationType, String startTime, String endTime, String numberOfMembers) {

        this.operationType = operationType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfMembers = Integer.parseInt(numberOfMembers);
    }
}
