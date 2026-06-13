package com.instalert_backend.incidents.interfaces.rest.resources;

public record CreateIncidentResource(
        Long userId,
        String type,
        String severity,
        String address,
        String description,
        String status,
        Double latitude,
        Double longitude,
        String timeReported
) {
}