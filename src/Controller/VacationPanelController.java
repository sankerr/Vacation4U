package Controller;
import Model.Fly;
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

        String[] str = {"Vacation Index", "User Name", "From", "To", "Depart", "Return Date",
                "Flight Company", "Total Price in $" , "Number Of Tickets", "Luggage",
                "Ticket Type", "Vacation Type", "Sleep Included", "Sleep Rank"};

        TableColumn vac_idx = new TableColumn(str[0]);
        vac_idx.setMinWidth(120);
        vac_idx.setCellValueFactory(
                new PropertyValueFactory<>(str[0]));

        TableColumn user_name = new TableColumn(str[1]);
        user_name.setMinWidth(120);
        user_name.setCellValueFactory(
                new PropertyValueFactory<>(str[1]));

        TableColumn from = new TableColumn(str[2]);
        from.setMinWidth(120);
        from.setCellValueFactory(
                new PropertyValueFactory<>(str[2]));

        TableColumn to = new TableColumn(str[3]);
        to.setMinWidth(120);
        to.setCellValueFactory(
                new PropertyValueFactory<>(str[3]));

        TableColumn depart = new TableColumn(str[4]);
        depart.setMinWidth(110);
        depart.setCellValueFactory(
                new PropertyValueFactory<>(str[4]));

        TableColumn return_date = new TableColumn(str[5]);
        return_date.setMinWidth(110);
        return_date.setCellValueFactory(
                new PropertyValueFactory(str[5]));

        TableColumn flight_company = new TableColumn(str[6]);
        flight_company.setMinWidth(100);
        flight_company.setCellValueFactory(
                new PropertyValueFactory<>(str[6]));

        TableColumn total_price = new TableColumn(str[7]);
        total_price.setMinWidth(80);
        total_price.setCellValueFactory(
                new PropertyValueFactory<>(str[7]));

        TableColumn num_of_tickets = new TableColumn(str[8]);
        num_of_tickets.setMinWidth(60);
        num_of_tickets.setCellValueFactory(
                new PropertyValueFactory<>(str[8]));

        TableColumn luggage = new TableColumn(str[9]);
        luggage.setMinWidth(100);
        luggage.setCellValueFactory(
                new PropertyValueFactory<>(str[9]));

        TableColumn ticket_type = new TableColumn(str[10]);
        ticket_type.setMinWidth(100);
        ticket_type.setCellValueFactory(
                new PropertyValueFactory<>(str[10]));

        TableColumn vac_type = new TableColumn(str[11]);
        vac_type.setMinWidth(100);
        vac_type.setCellValueFactory(
                new PropertyValueFactory<>(str[11]));

        TableColumn sleep_included = new TableColumn(str[12]);
        sleep_included.setMinWidth(60);
        sleep_included.setCellValueFactory(
                new PropertyValueFactory<>(str[12]));

        TableColumn sleep_rank = new TableColumn(str[13]);
        sleep_rank.setMinWidth(60);
        sleep_rank.setCellValueFactory(
                new PropertyValueFactory<>(str[13]));

        list = FXCollections.observableArrayList();

        //connect between col name and to his values
        vac_idx.setCellValueFactory(new PropertyValueFactory<Fly,String>("Vacation_Index"));
        user_name.setCellValueFactory(new PropertyValueFactory<Fly,String>("user_name"));
        from.setCellValueFactory(new PropertyValueFactory<Fly,String>("from"));
        to.setCellValueFactory(new PropertyValueFactory<Fly,String>("to"));
        depart.setCellValueFactory(new PropertyValueFactory<Fly,String>("depart"));
        return_date.setCellValueFactory(new PropertyValueFactory<Fly,String>("return_date"));
        flight_company.setCellValueFactory(new PropertyValueFactory<Fly,String>("flight_comp"));
        total_price.setCellValueFactory(new PropertyValueFactory<Fly,String>("price"));
        num_of_tickets.setCellValueFactory(new PropertyValueFactory<Fly,String>("num_of_travelers"));
        luggage.setCellValueFactory(new PropertyValueFactory<Fly,String>("luggage"));
        ticket_type.setCellValueFactory(new PropertyValueFactory<Fly,String>("cabin_class"));
        vac_type.setCellValueFactory(new PropertyValueFactory<Fly,String>("vac_type"));
        sleep_included.setCellValueFactory(new PropertyValueFactory<Fly,String>("sleep_included"));
        sleep_rank.setCellValueFactory(new PropertyValueFactory<Fly,String>("sleep_rank"));

        //connect between the list and the table
        table.setItems(list);
        // add flights to list
        //list.add( new Fly("1", "Jacob", "24", "mmmm", "jacob.smith@example.com", "jacob.smith@example.com","1","2","3","4","10"));
        //list.add( new Fly("2", "Motek", "Habibi", "danny shin", "halas", "tzizerit","96","guy shani","avi elly","agadir","yosef burger"));
        list.add( new Fly("3", "s",  "a", "s","WhereIsMyFreedom?", "StopWorking", "Diesel", "barbur", "itzik_d","maor","anael","raanan","pilo","matan"));
        // enter the cols to the table
        table.getColumns().addAll(vac_idx,user_name,from,to,depart,return_date,flight_company,total_price,num_of_tickets,luggage,ticket_type,vac_type,sleep_included,sleep_rank);

    }

}
