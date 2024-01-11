package engine.logging;

import java.time.LocalDate;
import java.time.LocalTime;

public record LogMessage(
        LoggerIdentifier identifier,
        StackTraceElement stackTraceElement,
        String content,
        LogPriority priority,
        LogCategory category,
        LocalTime relativeTime,
        LocalTime absoluteTime,
        LocalDate date
) {}