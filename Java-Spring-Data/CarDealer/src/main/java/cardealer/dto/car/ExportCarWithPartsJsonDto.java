package cardealer.dto.car;

import cardealer.dto.part.ExportPartJsonDto;
import com.google.gson.annotations.SerializedName;

import java.util.Set;

public class ExportCarWithPartsJsonDto {
    @SerializedName("car")
    private ExportCarJsonDto car;

    private Set<ExportPartJsonDto> parts;

    public ExportCarWithPartsJsonDto() {
    }

    public ExportCarJsonDto getCar() {
        return car;
    }

    public void setCar(ExportCarJsonDto car) {
        this.car = car;
    }

    public Set<ExportPartJsonDto> getParts() {
        return parts;
    }

    public void setParts(Set<ExportPartJsonDto> parts) {
        this.parts = parts;
    }
}
