package com.example.demo.controller;

import com.example.demo.model.Request;
import com.example.demo.repository.ReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CRMController {

    @Autowired
    private ReqRepository reqRepository;

    @GetMapping(value="/")
    public String homePage(Model model){
        List<Request> requestList = reqRepository.findAll();
        model.addAttribute("requesttar", requestList);
        return "homepage";
    }

    @GetMapping(value="/сheckedreq")
    public String CheckedReqPage(Model model){
        List<Request> requestList = reqRepository.findAllByHandledEquals(true);
        model.addAttribute("requesttar", requestList);
        return "homepage";
    }


    @GetMapping(value="/newreq")
    public String NewReqPage(Model model){
        List<Request> requestList = reqRepository.findAllByHandledEquals(false);
        model.addAttribute("requesttar", requestList);
        return "homepage";
    }

    @GetMapping(value="/addreq")
    public String addReqPage(Model model) {
        return "addrequest";
    }

    @PostMapping(value="/addreq")
    public String addReq(Request request){
        reqRepository.save(request);
        return "redirect:/";
    }

    @GetMapping(value="/details/{reqId}")
    public String reqDetails(@PathVariable(name="reqId") Long id, Model model){
        Request request = reqRepository.findById(id).orElse(null);
        model.addAttribute("request", request);
        return "details";
    }

    @PostMapping(value="/delete-music")
    public String reqDelete(@RequestParam(name="id") Long id){
        reqRepository.deleteById(id);
        return "redirect:/";
    }
}
