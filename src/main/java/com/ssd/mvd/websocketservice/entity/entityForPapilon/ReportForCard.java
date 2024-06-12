package com.ssd.mvd.websocketservice.entity.entityForPapilon;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public final class ReportForCard {
    private double lan;
    private double lat;

    private String title; // the name of Report
    private String description;
    private String passportSeries;

    private Date date; // the date when report was created
    private UUID uuidOfPatrul;
    @JsonDeserialize
    private List< String > imagesIds; // contains all images Ids which was downloaded in advance
}
