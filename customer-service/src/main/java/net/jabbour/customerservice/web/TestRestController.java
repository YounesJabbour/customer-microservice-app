package net.jabbour.customerservice.web;

import net.jabbour.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


//@RestController
//@RefreshScope
public class TestRestController {
//    @Autowired
//    private GlobalConfig globalConfig;
//    @Value("${global.params.p1}")
//    private int p1;
//    @Value("${global.params.p2}")
//    private int p2;
//    @Value("${customer.params.x}")
//    private int x;
//    @Value("${customer.params.y}")
//    private int y;
//    @GetMapping("/TestConfig")
//    public Map<String,Integer> testConfig() {
//        return Map.of("p1", p1, "p2", p2, "x", x, "y", y);
//    }
//    @GetMapping("/config")
//    public GlobalConfig configValues() {
//        return globalConfig;
//    }
}
