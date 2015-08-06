package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Paquete;
import com.progium.catering.contracts.BaseResponse;
import com.progium.catering.contracts.PaqueteResponse;
import com.progium.catering.contracts.PaqueteRequest;
import com.progium.catering.services.PaqueteServiceInterface;
import com.progium.catering.pojo.PaquetePOJO;
import com.progium.catering.utils.PojoUtils;

@RestController
@RequestMapping(value = "rest/protected/paquete")
public class PaqueteController {
	
	@Autowired
	PaqueteServiceInterface paqueteService;
	
	@Autowired
	HttpServletRequest request;	
	
	
	
	
}