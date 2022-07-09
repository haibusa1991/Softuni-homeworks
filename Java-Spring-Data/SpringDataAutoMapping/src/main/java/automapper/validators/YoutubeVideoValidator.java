package automapper.validators;

import automapper.annotations.YoutubeVideo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YoutubeVideoValidator implements ConstraintValidator<YoutubeVideo, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.length() == 11) {
            return true;
        }

//        https://www.youtube.com/watch?v=V59ea_-KC8E&list=TLPQMTYwMzIwMjJg_HwlFoSsRg&index=2
        String videoAddress;
        try {
            videoAddress = value.split("&")[0].split("=")[1];
            if (videoAddress.length() == 11 && value.split("=")[0].contains("youtube.com")) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }
}
