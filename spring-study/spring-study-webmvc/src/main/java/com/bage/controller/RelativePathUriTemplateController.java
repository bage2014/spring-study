package com.bage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners/{ownerId}")
public class RelativePathUriTemplateController {

        @GetMapping(path = "/pets/{petId}", params = "myParam=myValue")
        public void findPetParams(@PathVariable String ownerId, @PathVariable String petId, Model model) {
                // implementation omitted
        }

        @GetMapping(path = "/pets", headers = "myHeader=myValue")
        public void findPetHeaders(@PathVariable String ownerId, @PathVariable String petId, Model model) {
                // implementation omitted
        }
}
