package ca.sean;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoggingController {

    @GetMapping("/loggers")
    public String loggers(ModelMap model) {
        return "loggers";
    }

}