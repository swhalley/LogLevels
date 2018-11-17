package ca.sean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;

@RestController
public class LoggingRestController {

    private static Logger log = LoggerFactory.getLogger(LoggingRestController.class);

    @PostMapping("/change")
    public int changeLogger(@RequestBody LoggingModel model) {
        String name = model.getName();
        String sLevel = model.getLevel();

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        ch.qos.logback.classic.Logger logger = loggerContext.getLogger(name);

        Level level = Level.toLevel(sLevel);

        logger.setLevel(level);
        log.info(name + " set to " + level);

        log.debug("A really low level error");
        return 0;
    }

}