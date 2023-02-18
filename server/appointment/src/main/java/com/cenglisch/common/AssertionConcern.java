package com.cenglisch.common;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class AssertionConcern {
    protected void assertArgumentNotNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    protected void assertArgumentLength(String aString, int aMinimum, int aMaximum, String aMessage) {
        int length = aString.trim().length();
        if (length < aMinimum || length > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentRange(int aValue, int aMinimum, int aMaximum, String aMessage) {
        if (aValue < aMinimum || aValue > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentFuture(Time aTime, String aMessage) {
        LocalTime now = LocalTime.now();
        if (aTime.toLocalTime().isBefore(now)) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentFuture(Date aDate, String aMessage) {
        LocalDate now = LocalDate.now();
        if (aDate.toLocalDate().isBefore(now)) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentPast(Time aTime, String aMessage) {
        LocalTime now = LocalTime.now();
        if (aTime.toLocalTime().isAfter(now)) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentPast(Date aDate, String aMessage) {
        LocalDate now = LocalDate.now();
        if (aDate.toLocalDate().isAfter(now)) {
            throw new IllegalArgumentException(aMessage);
        }
    }
}
