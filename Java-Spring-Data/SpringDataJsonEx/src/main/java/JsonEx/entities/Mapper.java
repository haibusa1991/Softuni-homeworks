package JsonEx.entities;

import org.modelmapper.ModelMapper;

public class Mapper {
    private static Mapper instance;
    private final ModelMapper mapper;

    private Mapper() {
        this.mapper = new ModelMapper();
    }

    public static Mapper getInstance() {
        if (instance == null) {
            instance = new Mapper();
        }
        return instance;
    }

    public ModelMapper getMapper() {
        return mapper;
    }
}
