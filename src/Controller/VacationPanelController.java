package Controller;
import Model.IModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class VacationPanelController implements Observer,Initializable  {

     public ObservableList<Fly> list = FXCollections.observableArrayList();
     public TableView<Fly> table;
     private IModel model;
     private String userName;

    @Override
    public void update(Observable o, Object arg) {
    }

    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] str = {"From","To","Depart","Return date","Luggage","Cabin class","Vacation Type","Flight Company","Price",
                "Number of Travelers","Sleep included"};


        TableColumn from = new TableColumn(str[0]);
        from.setMinWidth(120);
        from.setCellValueFactory(
                new PropertyValueFactory<>(str[0]));

        TableColumn to = new TableColumn(str[1]);
        to.setMinWidth(120);
        to.setCellValueFactory(
                new PropertyValueFactory<>(str[1]));

        TableColumn depart = new TableColumn(str[2]);
        depart.setMinWidth(110);
        depart.setCellValueFactory(
                new PropertyValueFactory<>(str[2]));

        TableColumn return_date = new TableColumn(str[3]);
        return_date.setMinWidth(110);
        return_date.setCellValueFactory(
                new PropertyValueFactory(str[3]));

        TableColumn luggage = new TableColumn(str[4]);
        luggage.setMinWidth(100);
        luggage.setCellValueFactory(
                new PropertyValueFactory<>(str[4]));

        TableColumn cabin_class = new TableColumn(str[5]);
        cabin_class.setMinWidth(100);
        cabin_class.setCellValueFactory(
                new PropertyValueFactory<>(str[5]));

        TableColumn vac_type = new TableColumn(str[6]);
        vac_type.setMinWidth(100);
        vac_type.setCellValueFactory(
                new PropertyValueFactory<>(str[6]));

        TableColumn flight_comp = new TableColumn(str[7]);
        flight_comp.setMinWidth(100);
        flight_comp.setCellValueFactory(
                new PropertyValueFactory<>(str[7]));

        TableColumn price = new TableColumn(str[8]);
        price.setMinWidth(80);
        price.setCellValueFactory(
                new PropertyValueFactory<>(str[8]));

        TableColumn num_of_travelers = new TableColumn(str[9]);
        num_of_travelers.setMinWidth(60);
        num_of_travelers.setCellValueFactory(
                new PropertyValueFactory<>(str[9]));

        TableColumn sleep_included = new TableColumn(str[10]);
        sleep_included.setMinWidth(60);
        sleep_included.setCellValueFactory(
                new PropertyValueFactory<>(str[10]));



        list = FXCollections.observableArrayList();

        //connect between col name and to his values

        from.setCellValueFactory(new PropertyValueFactory<Fly,String>("from"));
        to.setCellValueFactory(new PropertyValueFactory<Fly,String>("to"));
        depart.setCellValueFactory(new PropertyValueFactory<Fly,String>("depart"));
        return_date.setCellValueFactory(new PropertyValueFactory<Fly,String>("return_date"));
        luggage.setCellValueFactory(new PropertyValueFactory<Fly,String>("luggage"));
        cabin_class.setCellValueFactory(new PropertyValueFactory<Fly,String>("cabin_class"));
        vac_type.setCellValueFactory(new PropertyValueFactory<Fly,String>("vac_type"));
        flight_comp.setCellValueFactory(new PropertyValueFactory<Fly,String>("flight_comp"));
        price.setCellValueFactory(new PropertyValueFactory<Fly,String>("price"));
        num_of_travelers.setCellValueFactory(new PropertyValueFactory<Fly,String>("num_of_travelers"));
        sleep_included.setCellValueFactory(new PropertyValueFactory<Fly,String>("sleep_included"));

        //connect between the list and the table
        table.setItems(list);
        // add flights to list
        list.add( new Fly("1", "Jacob", "24", "mmmm", "jacob.smith@example.com", "jacob.smith@example.com","1","2","3","4","10"));
        list.add( new Fly("2", "Motek", "Habibi", "danny shin", "halas", "tzizerit","96","guy shani","avi elly","agadir","yosef burger"));
        list.add( new Fly("3", "WhereIsMyFreedom?", "StopWorking", "Diesel", "barbur", "itzik_d","maor","anael","raanan","pilo","matan"));
        // enter the cols to the table
        table.getColumns().addAll(from,to,depart,return_date,luggage,cabin_class,vac_type,flight_comp,price,num_of_travelers,sleep_included);

    }

}
