package com.signapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum NumberOfSessions {
    ONE("1"),
    FOUR("4"),
    EIGHT("8");

    private final String value;
}
