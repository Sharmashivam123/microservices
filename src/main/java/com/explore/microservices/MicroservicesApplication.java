package com.explore.microservices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.explore.microservices.domain.Difficulty;
import com.explore.microservices.domain.Region;
import com.explore.microservices.service.TourPackageService;
import com.explore.microservices.service.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class MicroservicesApplication implements CommandLineRunner{

	@Autowired
	private TourService tourService;
	
	@Value("${ec.importfile}")
	private String importFile;

	@Autowired
	private TourPackageService tourPackageService;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create TourPackages
		createTourPackages();

		createTours(importFile);
	}

	/**
	 * Create tour entities from an external file
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	private void createTours(String fileToImport)
			throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		List<TourFromFile> list = TourFromFile.read(fileToImport);
		list.forEach(importedTour -> tourService.createTour(importedTour.getTitle(), importedTour.getDescription(),
				importedTour.getBlurb(), importedTour.getPrice(), importedTour.getLength(), importedTour.getBullets(),
				importedTour.getKeywords(), importedTour.getPackageType(), importedTour.getDifficulty(),
				importedTour.getRegion()));
	}

	/**
	 * Initialize all the known tour packages
	 */
	private void createTourPackages() {
		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of California");
	}

	private static class TourFromFile {
		private String packageType, title, description, blurb, price, length, bullets, keywords, difficulty, region;

		// reader
		static List<TourFromFile> read(String fileToImport)
				throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
					.readValue(new FileInputStream(fileToImport), new TypeReference<List<TourFromFile>>() {
					});
		}

		protected TourFromFile() {
		}

		String getPackageType() {
			return packageType;
		}

		String getTitle() {
			return title;
		}

		String getDescription() {
			return description;
		}

		String getBlurb() {
			return blurb;
		}

		Integer getPrice() {
			return Integer.parseInt(price);
		}

		String getLength() {
			return length;
		}

		String getBullets() {
			return bullets;
		}

		String getKeywords() {
			return keywords;
		}

		Difficulty getDifficulty() {
			return Difficulty.valueOf(difficulty);
		}

		Region getRegion() {
			return Region.findByLabel(region);
		}
	}

	

}
