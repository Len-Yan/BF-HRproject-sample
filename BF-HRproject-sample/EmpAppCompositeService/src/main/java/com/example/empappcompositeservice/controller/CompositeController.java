package com.example.empappcompositeservice.controller;

import com.example.empappcompositeservice.service.CompositeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jliao
 */
@RestController
@RequestMapping("empappcomposite")
public class CompositeController {

        private CompositeService compositeService;

        @Autowired
        public void setCompositeService(CompositeService compositeService) {
            this.compositeService = compositeService;
        }



}
