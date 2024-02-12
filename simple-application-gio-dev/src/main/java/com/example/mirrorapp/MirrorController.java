package com.example.mirrorapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MirrorController {

    @GetMapping("/mirror")
    public String mirrorRequest(@RequestParam String input) {
        return "Mirrored: " + input;
    }
}
