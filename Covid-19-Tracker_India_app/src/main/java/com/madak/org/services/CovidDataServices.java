package com.madak.org.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.madak.org.model.CovidDataSource;

@Service
public class CovidDataServices {
	
	private List<CovidDataSource> data = new ArrayList<>();
	
	 public List<CovidDataSource> getAllData() {
	        return data;
	    }
	 
	 @PostConstruct
	 public void fetchallData() throws IOException, InterruptedException {
		 
	  List<CovidDataSource> list=new ArrayList<CovidDataSource>();
	
	 String url="https://api.covid19india.org/csv/latest/districts.csv";
	 HttpClient client = HttpClient.newHttpClient();
     HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
    
HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

StringReader apidata = new StringReader(httpResponse.body());


Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(apidata);



for (CSVRecord record : records) {
	
	CovidDataSource obj = new CovidDataSource();
	
	obj.setDate(record.get("Date"));
	obj.setState(record.get("State"));
	obj.setDistrict(record.get("District"));
	long confirmed=Long.parseLong(record.get("Confirmed"));
	
	if(confirmed<1000) {
		obj.setZoneStatus("GREEN");
		obj.setServiceAvailable("YES");
	}
	else if(confirmed>1000 && confirmed<3000) {
		obj.setZoneStatus("ORANGE");
		obj.setServiceAvailable("YES");
	}
	else {
		obj.setZoneStatus("RED");
		obj.setServiceAvailable("NO");
	}
	obj.setConfirmed(confirmed);
	long recovered=Long.parseLong(record.get("Recovered"));
	obj.setRecovered(recovered);
	long deceased=Long.parseLong(record.get("Deceased"));
	obj.setDeceased(deceased);
	
	list.add(obj);
	}
this.data=list;


}}  


	

