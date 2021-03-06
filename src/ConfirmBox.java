import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);

        Label label = new Label();
        label.setText(message);
        label.setPadding(new Insets(10, 10, 10, 10));
        label.setFont(Font.font("OCR A Extended", 14));
        label.setTextFill(Color.WHITE);
        Button yesButton = new Button("Yes");
        yesButton.setFont(Font.font("OCR A Extended", 16));
        yesButton.setStyle("-fx-background-color: #3a3a3a");
        yesButton.setTextFill(Color.WHITE);
        Button noButton = new Button("No");
        noButton.setFont(Font.font("OCR A Extended", 16));
        noButton.setStyle("-fx-background-color: #3a3a3a");
        noButton.setTextFill(Color.WHITE);
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        FlowPane layout2 = new FlowPane();
        layout2.getChildren().addAll(yesButton, noButton);
        layout2.setAlignment(Pos.BOTTOM_CENTER);
        layout2.setPadding(new Insets(10, 10, 10, 10));
        layout2.setHgap(20);
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, layout2);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: black");
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
