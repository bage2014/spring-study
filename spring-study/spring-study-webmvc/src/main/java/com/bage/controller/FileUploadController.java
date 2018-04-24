package com.bage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

        @PostMapping("/form")
        public String handleFormUpload(@RequestParam("name") String name,
                        @RequestParam("file") MultipartFile file) throws Exception {

                if (!file.isEmpty()) {
                        byte[] bytes = file.getBytes();
                        System.out.println(bytes);
                        // store the bytes somewhere
                        return "redirect:uploadSuccess";
                }

                return "redirect:uploadFailure";
        }

        // When using Servlet 3.0 multipart parsing you can also use javax.servlet.http.Part for the method parameter:
//        @PostMapping("/form")
//        public String handleFormUpload(@RequestParam("name") String name,
//                        @RequestParam("file") Part file) {
//
//                InputStream inputStream = file.getInputStream();
//                // store bytes from uploaded file somewhere
//
//                return "redirect:uploadSuccess";
//        }
        
}
