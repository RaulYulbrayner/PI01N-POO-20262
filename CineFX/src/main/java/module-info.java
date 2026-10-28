module uniquindio.edu.co.cinefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens uniquindio.edu.co.cinefx to javafx.fxml;
    exports uniquindio.edu.co.cinefx;
}