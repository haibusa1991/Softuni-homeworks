package lecture04Interfaces.E05Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            sb.append(isValidUrl(url)).append(System.lineSeparator());

        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            sb.append(isValidNumber(number)).append(System.lineSeparator());

        }
        return sb.toString().trim();
    }


    private String isValidUrl(String url) {
        for (char c : url.toCharArray()) {
            if (Character.isDigit(c)) {
                return "Invalid URL!";
            }
        }
        return "Browsing: " + url + "!";
    }


    private String isValidNumber(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "Invalid number!";
            }
        }
        return "Calling... "+ number;
    }
}
