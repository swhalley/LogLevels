package ca.sean;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ch.qos.logback.classic.LoggerContext;

@Controller
public class LoggingController {

    private static Logger log = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/loggers")
    public String loggers(ModelMap model) {
        log.info("Retrieving a list of loggers");
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        List<ch.qos.logback.classic.Logger> loggers = loggerContext.getLoggerList();

        List<String> logLevels = Arrays.asList("", "OFF", "ERROR", "WARN", "INFO", "DEBUG", "TRACE", "ALL");

        log.debug("setting a list of loggers on the model");
        model.put("loggers", loggers);
        model.put("logLevels", logLevels);

        return "loggers";
    }
}