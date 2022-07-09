package exam.service.impl;

import exam.config.ApplicationBeanConfiguration;
import exam.dto.shop.ShopImportDto;
import exam.dto.shop.ShopImportListDto;
import exam.model.Shop;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.Filenames;
import exam.util.LaptopShopFileReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, ModelMapper mapper) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() {
        return LaptopShopFileReader.readFile(Filenames.SHOPS_FILE);
    }

    @Override
    public String importShops() throws JAXBException {
        Unmarshaller unmarshaller = ApplicationBeanConfiguration.getUnmarshaller(ShopImportListDto.class);

        assert unmarshaller != null;
        ShopImportListDto importDtos = (ShopImportListDto) unmarshaller.unmarshal(new StringReader(readShopsFileContent()));

        List<String> results = new ArrayList<>();
        for (ShopImportDto shopDto : importDtos.getShops()) {
            Shop shop = mapper.map(shopDto, Shop.class);
            shop.setTown(this.townRepository.getTownByName(shopDto.getShopTown().getName()));

            try {
                this.shopRepository.save(shop);
                results.add(String.format("Successfully imported Shop %s - %s", shop.getName(), shop.getIncome()));
            } catch (Exception e) {
                results.add("Invalid shop");
            }
        }

        return String.join(System.lineSeparator(), results);
    }
}
