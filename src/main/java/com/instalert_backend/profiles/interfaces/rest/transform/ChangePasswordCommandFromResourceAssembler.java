package com.instalert_backend.profiles.interfaces.rest.transform;

import com.instalert_backend.profiles.domain.model.commands.ChangePasswordCommand;
import com.instalert_backend.profiles.interfaces.rest.resources.ChangePasswordResource;

public class ChangePasswordCommandFromResourceAssembler {
    public static ChangePasswordCommand toCommandFromResource(Long id, ChangePasswordResource resource) {
        return new ChangePasswordCommand(id, resource.currentPassword(), resource.newPassword());
    }
}