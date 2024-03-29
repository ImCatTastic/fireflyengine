package engine.logging;

import engine.identification.Identifier;

import java.time.LocalDate;
import java.time.LocalTime;

public record LogMessage(
        Identifier identifier,
        StackTraceElement stackTraceElement,
        String content,
        LogPriority priority,
        LogCategory category,
        LocalTime relativeTime,
        LocalTime absoluteTime,
        LocalDate date
) {}
