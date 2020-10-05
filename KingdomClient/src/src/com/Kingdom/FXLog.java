package src.com.Kingdom;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.geometry.Insets;
import javafx.geometry.*;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

public class FXLog extends Application {
    public static boolean running;

    //Listener
    private FXListener fxListener;
    //Sizes
    private final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private final int width = gd.getDisplayMode().getWidth();
    private final int height = gd.getDisplayMode().getHeight() - 80;

    //Panes
    private BorderPane loginRoot = new BorderPane();
    private BorderPane registerRoot = new BorderPane();
    private BorderPane mainRoot = new BorderPane();

    //Stage
    private static Stage loginStage;

    //Scenes
    private static Scene log, reg, main;

    //Components
    //Error
    private static Text error = new Text("");

    //login
    private TextField loguser = new TextField("");
    private PasswordField logpass = new PasswordField();

    //register
    private TextField user = new TextField("");
    private PasswordField pass = new PasswordField();
    private TextField email = new TextField("");
    private TextField age = new TextField("");
    //register country list
    ObservableList<String> countrieslist = 
        FXCollections.observableArrayList(
            "United States",
            "Canada",
            "Brazil",
            "Other"
        );
    final ComboBox<String> comboBox = new ComboBox<String>(countrieslist);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage loginStage) {
        RegScenes();
        running = true;
        this.fxListener = new FXListener();
        FXLog.loginStage = loginStage;
        loginStage.setTitle("Login");
        loginStage.setScene(log);
        loginStage.setMaximized(true);
        loginStage.show();
    }

    private void RegScenes() {
        loginRoot.setCenter(addLoginPane());
        log = new Scene(loginRoot,width / 1.5, height / 1.5);

        registerRoot.setCenter(addRegisterPane());
        reg = new Scene(registerRoot, width /1.5,height/1.5);

        mainRoot.setTop(addHBox());
        main = new Scene(mainRoot, width /1.5,height/1.5);

        this.error.setVisible(false);
    }

    
    private HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Home");
        buttonCurrent.setPrefSize(100, 20);

        Button buttonProjected = new Button("Army");
        buttonProjected.setPrefSize(100, 20);
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);


        return hbox;
    }

    private GridPane addRegisterPane() {
    
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(200, 0, 350, 0));
        grid.setAlignment(Pos.CENTER);

        // Category in column 2, row 1
        Text username = new Text("Username");
        username.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        username.setFill(Color.WHITE);
        grid.add(username, 3, 5); 

        Text client = new Text("Kingdom Client");
        client.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        client.setFill(Color.WHITE);
        grid.add(client, 4,3);

        // Title in column 3, row 1
        Text password = new Text("Password");
        password.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        password.setFill(Color.WHITE);
        grid.add(password, 3, 6);

        grid.add(user, 4, 5);
        grid.add(pass, 4,6);
        grid.add(this.email, 4,7);
        grid.add(this.age, 4,8);

        Text email = new Text("Email");
        email.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        email.setFill(Color.WHITE);
        grid.add(email, 3,7);

        Text age = new Text("Age");
        age.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        age.setFill(Color.WHITE);
        grid.add(age, 3, 8);

        Text country = new Text("Country");
        country.setFont(Font.font("Arial",FontWeight.BOLD, 20));
        country.setFill(Color.WHITE);
        grid.add(country,3,9);

        Button register = new Button("Register");
        register.setMaxWidth(150);
        register.setOnAction(event -> {fxListener.register(); });
        //register.setBackground(new Background(new BackgroundFill(
        //Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));;
        grid.add(register, 4, 10);
        grid.add(comboBox,4,9);
        grid.add(this.error, 4, 12);

    
        BackgroundImage myBI= new BackgroundImage(new Image("http://img08.deviantart.net/1c3a/i/2006/076/6/8/medieval_city_by_geistig.jpg",width,height + 80,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
       // ImageView image = new ImageView(myBI.getImage());
                //loginRoot.setBackground(new Background(image));
        //then you set to your nodeBI));

        return grid;
    
    }

    private GridPane addMainPane() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        return grid;
    }

    private GridPane addLoginPane() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(200, 0, 350, 0));

        grid.setAlignment(Pos.CENTER);
        // Category in column 2, row 1
        Text username = new Text("Username");
        username.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        username.setFill(Color.WHITE);
        grid.add(username, 3, 5); 

        Text client = new Text("Kingdom Client");
        client.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        client.setFill(Color.WHITE);
        grid.add(client, 4,3);

        // Title in column 3, row 1
        Text password = new Text("Password");
        password.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        password.setFill(Color.WHITE);
        grid.add(password, 3, 6);

        // Subtitle in columns 2-3, row 2
        grid.add(loguser, 4, 5);
        grid.add(logpass, 4,6);

        Button login = new Button("Login");
        login.setMaxWidth(150);
        login.setOnAction(event -> { /*FXListener.login();*/ fxListener.temp(); });
        grid.add(login, 4, 8);

        Button register = new Button("Register");
        register.setMaxWidth(150);
        register.setOnAction(event -> {fxListener.openRegister(); });
        //register.setBackground(new Background(new BackgroundFill(
        //Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));;

        grid.add(register, 4, 9);
        grid.add(FXLog.error, 4, 11);

        
        // House icon in column 1, rows 1-2
        //ImageView imageHouse = new ImageView(
        //  new Image(LayoutSample.class.getResourceAsStream("graphics/house.png")));
        //grid.add(imageHouse, 0, 0, 1, 2); 

        // Left label in column 1 (bottom), row 3
        //Text goodsPercent = new Text("Goods\n80%");
        //GridPane.setValignment(goodsPercent, VPos.BOTTOM);
        //grid.add(goodsPercent, 0, 2); 

        // Chart in columns 2-3, row 3
        //ImageView imageChart = new ImageView(
        // new Image(LayoutSample.class.getResourceAsStream("graphics/piechart.png")));
        //grid.add(imageChart, 1, 2, 2, 1); 

        // Right label in column 4 (top), row 3
        //Text servicesPercent = new Text("Services\n20%");
        //GridPane.setValignment(servicesPercent, VPos.TOP);
        //grid.add(servicesPercent, 3, 2);

        //GridPane.setHgrow(username, Priority.ALWAYS);
        //GridPane.setHgrow(password, Priority.ALWAYS);
        //GridPane.setHgrow(user, Priority.ALWAYS);
        //GridPane.setHgrow(pass, Priority.ALWAYS);

        BackgroundImage myBI= new BackgroundImage(new Image("http://img08.deviantart.net/1c3a/i/2006/076/6/8/medieval_city_by_geistig.jpg",width,height + 80,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //then you set to your node
        registerRoot.setBackground(new Background(myBI));

        return grid;
    }   

    //Scene changers
    public static void registerScene() {
        loginStage.setMaximized(false);
        loginStage.setScene(reg);
        loginStage.setMaximized(true);
    }

    public static void loginScene() {
        loginStage.setMaximized(false);
        loginStage.setScene(log);
        loginStage.setMaximized(true);
    }

    public static void mainScene() {
        loginStage.setMaximized(false);
        loginStage.setScene(main);
        loginStage.setMaximized(true);
    }

    //Errors/Component changers
    protected static void showError(String msg) {
        error.setWrappingWidth(100);
        error.setVisible(true);
        error.setText(msg);
        error.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        error.setFill(Color.RED);

    }

    //Getters
    protected String getlogUsername() {
        return loguser.getText();
    }

    protected String getlogPassword() {
        return logpass.getText();
    }

    protected String getUsername() {
        return user.getText();
    }

    protected String getPassword() {
        return pass.getText();
    }

    protected String getEmail() {
        return email.getText();
    }

    protected String getAge() {
        return age.getText();
    }

    protected String getCountry() {
        return comboBox.getValue().toString();
    }

}