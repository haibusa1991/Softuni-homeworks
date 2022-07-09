package lecture06Solid.logger.factories;

import lecture06Solid.logger.interfaces.Layout;
import lecture06Solid.logger.layouts.SimpleLayout;
import lecture06Solid.logger.layouts.XmlLayout;

public class LayoutFactory {
    public Layout create(String type) {
        switch (type) {
            case "SimpleLayout":
                return   new SimpleLayout();
            case "XmlLayout":
                return new XmlLayout();
            default:
                throw new IllegalArgumentException("No such layout - " + type);
        }
    }
}
