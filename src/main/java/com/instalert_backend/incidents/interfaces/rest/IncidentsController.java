package com.instalert_backend.incidents.interfaces.rest;

import com.instalert_backend.incidents.application.commandservices.IncidentCommandService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/incidents", produces = MediaType.APPLICATION_JSON_VALUE)

public class IncidentsController {

    private final IncidentCommandService incidentCommandService;

    public IncidentsController(IncidentCommandService incidentCommandService) {
        this.incidentCommandService = incidentCommandService;
    }
}