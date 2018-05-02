package com.bage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bage.domain.Clinic;

@Controller // multi-action controller using @RequestMapping
@RequestMapping("/clinic")
public class ClinicController {

        private final Clinic clinic;

        @Autowired
        public ClinicController(@Qualifier("domainClinic") Clinic clinic) {
                this.clinic = clinic;
        }

        @RequestMapping("/")
        public void welcomeHandler() {
        }

        @RequestMapping("/vets")
        public ModelMap vetsHandler() {
                return new ModelMap(this.clinic.getVets());
        }

}
