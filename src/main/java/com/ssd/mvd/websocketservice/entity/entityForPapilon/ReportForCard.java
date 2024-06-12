package com.ssd.mvd.websocketservice.entity.entityForPapilon;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@JsonIgnoreProperties ( ignoreUnknown = true )
public class ReportForCard { // creates when some of Patrul from current Card has finished the work and has written the report about everything he has done
    private Double lan;
    private Double lat;

    private String title; // the name of Report
    private String description;
    private String passportSeries;

    private Date date; // the date when report was created
    private UUID uuidOfPatrul;
    @JsonDeserialize
    private List< String > imagesIds; // contains all images Ids which was downloaded in advance
}
