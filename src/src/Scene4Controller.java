import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class Scene4Controller {

    @FXML private Button cardioInputButton;
    @FXML private Label invalidInput;
    @FXML private TextField durationInt;
    @FXML private TextField milesInput;

    @FXML
    private void initialize()
    {
        invalidInput.setVisible(false);

        UnaryOperator<TextFormatter.Change> integerFilter = change ->
                change.getControlNewText().matches("\\d*") ? change : null;

        durationInt.setTextFormatter(new TextFormatter<>(integerFilter));
        milesInput.setTextFormatter(new TextFormatter<>(integerFilter));
    }

    @FXML
    public void validateInput(ActionEvent event) throws IOException
    {
        String d = durationInt.getText();
        String m = milesInput.getText();

        if (d.isEmpty() || m.isEmpty()) {
            invalidInput.setVisible(true);
            return;
        }

        int duration = Integer.parseInt(d);
        int distance = Integer.parseInt(m);

        if (duration <= 0 || distance <= 0) {
            invalidInput.setVisible(true);
            return;
        }

        invalidInput.setVisible(false);
        switchToScene6(event, duration, distance);
    }

    private void switchToScene6(ActionEvent event, int duration, int distance) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("Scene6.fxml")));
        Parent root = loader.load();

        Scene6Controller controller = loader.getController();
        controller.setWorkoutData(duration, distance);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
