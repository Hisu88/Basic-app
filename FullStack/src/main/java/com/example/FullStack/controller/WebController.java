package com.example.FullStack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
public class WebController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/api/submit")
    @ResponseBody
    public String submitData(@RequestBody DataRequest dataRequest) {
        String inputData = dataRequest.getData();
        int age = dataRequest.getAge();

        // Calculate the year of birth
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birthYear = currentYear - age;

        // Construct the response message
        String responseMessage = "You were born in the year " + birthYear;

        return "{\"message\": \"" + responseMessage + "\"}";
    }

    static class DataRequest {
        private String data;
        private int age;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
