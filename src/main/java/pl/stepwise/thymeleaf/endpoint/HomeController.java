package pl.stepwise.thymeleaf.endpoint;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    @RequestMapping("/home")
    String index() {
        return "index";
    }

    @RequestMapping("/sample-table")
    public String list(Model model) {
        List<Row> rows = IntStream.rangeClosed(1, 10)
                .mapToObj(idx -> new Row(idx, "Row " + idx, LocalDateTime.now().plusDays(idx)))
                .collect(Collectors.toList());

        model.addAttribute("rows", rows);
        return "hello/table";
    }
}

class Row {
    public int id;
    public String name;
    private LocalDateTime date;

    public Row(int id, String name, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
