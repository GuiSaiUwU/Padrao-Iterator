module com.guisai.padraoiterator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.guisai.padraoiterator to javafx.fxml;
    exports com.guisai.padraoiterator;
}