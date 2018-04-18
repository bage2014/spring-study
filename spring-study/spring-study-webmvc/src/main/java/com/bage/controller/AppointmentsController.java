package com.bage.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bage.domain.Appointment;
import com.bage.domain.AppointmentBook;
import com.bage.domain.AppointmentForm;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {

        private final AppointmentBook appointmentBook;

        @Autowired
        public AppointmentsController(AppointmentBook appointmentBook) {
                this.appointmentBook = appointmentBook;
        }

        //  @GetMapping
        @RequestMapping(method = RequestMethod.GET) // it only accepts GET requests
        public Map<String, Appointment> get() {
                return appointmentBook.getAppointmentsForToday();
        }
        	
        // @GetMapping("/{day}")
        @RequestMapping(path = "/{day}", method = RequestMethod.GET)
        public Map<String, Appointment> getForDay(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day, Model model) {
                return appointmentBook.getAppointmentsForDay(day);
        }

        // @GetMapping("/new")
        @RequestMapping(path = "/new", method = RequestMethod.GET)
        public AppointmentForm getNewForm() {
                return new AppointmentForm();
        }

        // @PostMapping
        @RequestMapping(method = RequestMethod.POST)
        public String add(AppointmentForm appointment, BindingResult result) {
                if (result.hasErrors()) {
                        return "appointments/new";
                }
                appointmentBook.addAppointment(appointment);
                return "redirect:/appointments";
        }
}
