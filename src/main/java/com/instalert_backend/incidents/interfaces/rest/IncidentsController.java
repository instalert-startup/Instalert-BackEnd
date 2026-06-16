package com.instalert_backend.incidents.interfaces.rest;

import com.instalert_backend.incidents.application.commandservices.IncidentCommandService;
import com.instalert_backend.incidents.application.queryservices.IncidentQueryService;

import com.instalert_backend.incidents.interfaces.rest.resources.CreateIncidentResource;
import com.instalert_backend.incidents.interfaces.rest.transform.CreateIncidentCommandFromResourceAssembler;
import com.instalert_backend.incidents.interfaces.rest.transform.IncidentResourceFromEntityAssembler;

import com.instalert_backend.shared.interfaces.rest.transform.ResponseEntityAssembler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import com.instalert_backend.incidents.domain.model.queries.GetAllIncidentsQuery;

import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;

import com.instalert_backend.incidents.domain.model.queries.GetIncidentByIdQuery;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/api/v1/incidents", produces = MediaType.APPLICATION_JSON_VALUE)
public class IncidentsController {

    private final IncidentCommandService incidentCommandService;
    private final IncidentQueryService incidentQueryService;

    public IncidentsController(IncidentCommandService incidentCommandService, IncidentQueryService incidentQueryService) {
        this.incidentCommandService = incidentCommandService;
        this.incidentQueryService = incidentQueryService;
    }

    @PostMapping
    public ResponseEntity<?> createIncident(@RequestBody CreateIncidentResource resource) {
        var createIncidentCommand =
                CreateIncidentCommandFromResourceAssembler.toCommandFromResource(resource);

        var result = incidentCommandService.handle(createIncidentCommand);

        return ResponseEntityAssembler.toResponseEntityFromResult(
                result,
                IncidentResourceFromEntityAssembler::toResourceFromEntity,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllIncidents() {

        var getAllIncidentsQuery = new GetAllIncidentsQuery();

        var incidents = incidentQueryService.handle(getAllIncidentsQuery);

        var resources = incidents.stream()
                .map(IncidentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{incidentId}")
    public ResponseEntity<?> getIncidentById(@PathVariable Long incidentId) {

        var getIncidentByIdQuery = new GetIncidentByIdQuery(incidentId);

        var incident = incidentQueryService.handle(getIncidentByIdQuery);

        if (incident.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var resource =
                IncidentResourceFromEntityAssembler.toResourceFromEntity(incident.get());

        return ResponseEntity.ok(resource);
    }
}