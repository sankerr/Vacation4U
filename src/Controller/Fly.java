package Controller;

import javafx.beans.property.SimpleStringProperty;

public class Fly {

    private final SimpleStringProperty from;
    private final SimpleStringProperty to;
    private final SimpleStringProperty depart;
    private final SimpleStringProperty return_date;
    private final SimpleStringProperty luggage;
    private final SimpleStringProperty cabin_class;
    private final SimpleStringProperty vac_type;
    private final SimpleStringProperty flight_comp;
    private final SimpleStringProperty price;
    private final SimpleStringProperty num_of_travelers;
    private final SimpleStringProperty sleep_included;


    public Fly(String from, String to, String depart, String return_date, String luggage, String cabin_class,
               String vac_type, String price, String flight_comp, String num_of_travelers, String sleep_included) {
        this.from = new SimpleStringProperty(from);
        this.to = new SimpleStringProperty(to);
        this.depart = new SimpleStringProperty(depart);
        this.return_date = new SimpleStringProperty(return_date);
        this.luggage = new SimpleStringProperty(luggage);
        this.cabin_class = new SimpleStringProperty(cabin_class);
        this.vac_type = new SimpleStringProperty(vac_type);
        this.flight_comp = new SimpleStringProperty(flight_comp);
        this.price = new SimpleStringProperty(price);
        this.num_of_travelers = new SimpleStringProperty(num_of_travelers);
        this.sleep_included = new SimpleStringProperty(sleep_included);

    }


    public String getFrom() {
        return from.get();
    }

    public SimpleStringProperty fromProperty() {
        return from;
    }

    public void setFrom(String from) {
        this.from.set(from);
    }

    public String getTo() {
        return to.get();
    }

    public SimpleStringProperty toProperty() {
        return to;
    }

    public void setTo(String to) {
        this.to.set(to);
    }

    public String getDepart() {
        return depart.get();
    }

    public SimpleStringProperty departProperty() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart.set(depart);
    }

    public String getReturn_date() {
        return return_date.get();
    }

    public SimpleStringProperty return_dateProperty() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date.set(return_date);
    }

    public String getLuggage() {
        return luggage.get();
    }

    public SimpleStringProperty luggageProperty() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage.set(luggage);
    }

    public String getCabin_class() {
        return cabin_class.get();
    }

    public SimpleStringProperty cabin_classProperty() {
        return cabin_class;
    }

    public void setCabin_class(String cabin_class) {
        this.cabin_class.set(cabin_class);
    }

    public String getVac_type() {
        return vac_type.get();
    }

    public SimpleStringProperty vac_typeProperty() {
        return vac_type;
    }

    public void setVac_type(String vac_type) {
        this.vac_type.set(vac_type);
    }

    public String getFlight_comp() {
        return flight_comp.get();
    }

    public SimpleStringProperty flight_compProperty() {
        return flight_comp;
    }

    public void setFlight_comp(String flight_comp) {
        this.flight_comp.set(flight_comp);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getNum_of_travelers() {
        return num_of_travelers.get();
    }

    public SimpleStringProperty num_of_travelersProperty() {
        return num_of_travelers;
    }

    public void setNum_of_travelers(String num_of_travelers) {
        this.num_of_travelers.set(num_of_travelers);
    }

    public String getSleep_included() {
        return sleep_included.get();
    }

    public SimpleStringProperty sleep_includedProperty() {
        return sleep_included;
    }

    public void setSleep_included(String sleep_included) {
        this.sleep_included.set(sleep_included);
    }
}
