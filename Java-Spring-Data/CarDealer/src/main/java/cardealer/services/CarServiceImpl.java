package cardealer.services;

import cardealer.dto.car.ExportCarJsonDto;
import cardealer.dto.car.ExportCarWithPartsJsonDto;
import cardealer.dto.car.ImportCarJsonDto;
import cardealer.entities.Car;
import cardealer.entities.Part;
import cardealer.repositories.CarRepository;
import cardealer.repositories.PartRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static cardealer.util.Filepaths.*;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, @Qualifier("skipCarId") Gson gson, ModelMapper mapper) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void importCars() throws IOException {
        String json = String.join(System.lineSeparator(), Files.readAllLines(Path.of(JSON_IMPORT_CARS)));

        List<Car> cars = Arrays.stream(gson.fromJson(json, ImportCarJsonDto[].class))
                .map(e -> mapper.map(e, Car.class))
                .map(this::setParts)
                .collect(Collectors.toList());

        this.carRepository.saveAll(cars);
    }

    @Override
    public void exportToyota() throws IOException {
        List<Car> toyotas = this.carRepository.getCarByMakeOrderByModelAscTraveledDistanceDesc("Toyota");

        List<ExportCarJsonDto> dtos = toyotas.stream()
                .map(e -> mapper.map(e, ExportCarJsonDto.class))
                .collect(Collectors.toList());

        FileOutputStream fos = new FileOutputStream(JSON_EXPORT_QUERY_2);
        fos.write(gson.toJson(dtos).getBytes());
        fos.close();
    }


    private Car setParts(Car car) {
        Random r = new Random();
        int numParts = r.nextInt(3) + 3;

        while (car.getParts().size() < numParts) {
            Part part = this.partRepository.getById(r.nextInt((int) this.partRepository.count()) + 1);
            Set<Part> carParts = new HashSet<>(car.getParts());
            carParts.add(part);
            car.setParts(carParts);
        }

        return car;
    }

    @Override
    @Transactional
    public void exportCarsWithParts() throws IOException {
        List<Car> allCars = this.carRepository.getAllCars();
        List<ExportCarWithPartsJsonDto> dtos = allCars.stream()
                .map(e -> mapper.map(e, ExportCarWithPartsJsonDto.class))
                .collect(Collectors.toList());

        FileOutputStream fos = new FileOutputStream(JSON_EXPORT_QUERY_4);
        fos.write(gson.toJson(dtos).getBytes());
        fos.close();
    }

}
