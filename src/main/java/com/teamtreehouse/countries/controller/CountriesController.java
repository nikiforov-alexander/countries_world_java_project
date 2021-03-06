package com.teamtreehouse.countries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamtreehouse.countries.data.CountryRepository;
import com.teamtreehouse.countries.model.Country;

@Controller
public class CountriesController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@RequestMapping("/")
	public String countryList(ModelMap modelMap){
		List<Country> listCountries=countryRepository.getListCountries();
		modelMap.put("countries",listCountries);
		return "index";
	}
	
	@RequestMapping("/country/{countryName}")
	public String findByCountry(@PathVariable String countryName,ModelMap modelMap){
		Country listByName=countryRepository.findByName(countryName);
		modelMap.put("country",listByName);
		return "country";
	}
}
