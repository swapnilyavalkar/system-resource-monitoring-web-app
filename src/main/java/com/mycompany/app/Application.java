package com.mycompany.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.util.Map;
import java.util.HashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
class InfoController {

    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }

    @GetMapping("/info")
    public ResponseEntity<?> getInfo() {
        String hostname = "Unknown";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostname = inetAddress.getHostName();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get system information
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        double cpuLoad = osBean.getSystemCpuLoad() * 100;
        long freeMemory = osBean.getFreePhysicalMemorySize() / (1024 * 1024);
        long totalMemory = osBean.getTotalPhysicalMemorySize() / (1024 * 1024);

        // Return system info as JSON
        Map<String, Object> info = new HashMap<>();
        info.put("hostname", hostname);
        info.put("cpuLoad", cpuLoad);
        info.put("freeMemory", freeMemory);
        info.put("totalMemory", totalMemory);
        info.put("creator", "Swapnil Yavalkar");

        return ResponseEntity.ok(info);
    }
}
