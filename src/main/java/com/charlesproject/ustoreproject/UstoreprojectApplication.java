package com.charlesproject.ustoreproject;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.charlesproject.ustoreproject.model.entities.Item;
import com.charlesproject.ustoreproject.repository.ItemRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@SpringBootApplication
public class UstoreprojectApplication implements CommandLineRunner {

	@Autowired
	private ItemRepository repository;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(UstoreprojectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		
		List<Item> itens = new ArrayList<Item>();
		Reader reader = Files.newBufferedReader(Paths.get("c:\\temp\\file_hackaton3.csv"));
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

		List<String[]> values = csvReader.readAll();

		for (String[] valu : values) {
			Instant instant = Instant.parse(valu[11]);
			Instant instantEnd = Instant.parse(valu[12]);
			Date usageStartDate = Date.from(instant);
			Date usageEndDate = Date.from(instantEnd);
			String lineItem = valu[1];

			BigDecimal unblendedRate = null;
			BigDecimal unblendedCost = null;
			BigDecimal usageAmount = null;
			if (valu[22] != "") {
				unblendedRate = new BigDecimal(valu[22]);

			}
			if (valu[23] != "") {
				System.out.println(itens.size());
				unblendedCost = new BigDecimal(valu[23]);

			}
			if (valu[18] != "") {
				usageAmount = new BigDecimal(valu[18]);
			}

			itens.add(new Item(null, lineItem, unblendedRate, unblendedCost, usageStartDate, usageEndDate, valu[13],
					valu[15], valu[14], usageAmount, valu[149]));

		}

		for (int i=1; i < itens.size(); i++) {
			repository.save(itens.get(i));
			System.out.println(i);
		}
		
	
	}

}
