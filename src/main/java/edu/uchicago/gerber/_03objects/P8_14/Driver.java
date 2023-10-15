package edu.uchicago.gerber._03objects.P8_14;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Country> countries = new ArrayList<>();

        // Populate the countries list with data
        countries.add(new Country("Country 1", 100000, 5000));
        countries.add(new Country("Country 2", 200000, 3000));
        countries.add(new Country("Country 3", 150000, 4000));

        // Find the country with the largest area
        Country largestAreaCountry = getCountryWithLargestArea(countries);

        // Find the country with the largest population
        Country largestPopulationCountry = getCountryWithLargestPopulation(countries);

        // Find the country with the largest population density
        Country largestPopulationDensityCountry = getCountryWithLargestPopulationDensity(countries);

        // Print the results
        System.out.println("Country with the largest area: " + largestAreaCountry.getName());
        System.out.println("Country with the largest population: " + largestPopulationCountry.getName());
        System.out.println("Country with the largest population density: " + largestPopulationDensityCountry.getName());
    }

    public static Country getCountryWithLargestArea(ArrayList<Country> countries) {
        Country countryWithLargestArea = countries.get(0);
        for (Country country : countries) {
            if (country.getArea() > countryWithLargestArea.getArea()) {
                countryWithLargestArea = country;
            }
        }
        return countryWithLargestArea;
    }

    public static Country getCountryWithLargestPopulation(ArrayList<Country> countries) {
        Country countryWithLargestPopulation = countries.get(0);
        for (Country country : countries) {
            if (country.getPopulation() > countryWithLargestPopulation.getPopulation()) {
                countryWithLargestPopulation = country;
            }
        }
        return countryWithLargestPopulation;
    }

    public static Country getCountryWithLargestPopulationDensity(ArrayList<Country> countries) {
        Country countryWithLargestPopulationDensity = countries.get(0);
        for (Country country : countries) {
            if (country.getPopulationDensity() > countryWithLargestPopulationDensity.getPopulationDensity()) {
                countryWithLargestPopulationDensity = country;
            }
        }
        return countryWithLargestPopulationDensity;
    }
}
