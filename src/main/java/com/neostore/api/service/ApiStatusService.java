package com.neostore.api.service;

import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author kaciano
 */
@ApplicationScoped
public class ApiStatusService {

    public String getApiStatus() {
        return "Injected: API Online";
    }
}
