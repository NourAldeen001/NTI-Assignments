package org.example.dto;

import org.example.model.Address;

public record RegisterRequest(String name, String email, Address address) { }
