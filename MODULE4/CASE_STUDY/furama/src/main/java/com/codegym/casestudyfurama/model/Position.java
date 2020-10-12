package com.codegym.casestudyfurama.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Position {
    @Id
    private Long positionId;
    private String positionName;

    public Position() {
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
