package com.ssd.mvd.websocketservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true )
public class ReqCar {
    private UUID lustraId;
    private String gosNumber;
    private String trackerId;
    private String vehicleType;
    private String carImageLink;
    private String patrulPassportSeries;

    private Integer sideNumber; // бортовой номер
    private Integer simCardNumber;

    private Double latitude;
    private Double longitude;
    private Double averageFuelSize; // средний расход топлива по документам
    private Double averageFuelConsumption = 0.0; // средний расход топлива исходя из стиля вождения водителя
}
