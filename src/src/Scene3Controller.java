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

public class Scene3Controller {

    @FXML private Button enterWeightOutput;
    @FXML private Label invalidInput;
    @FXML private TextField durationInt;
    @FXML private TextField setsInt;
    @FXML private TextField repsInt;

    @FXML
    private void initialize()
    {
        invalidInput.setVisible(false);

        UnaryOperator<TextFormatter.Change> integerFilter = change ->
                change.getControlNewText().matches("\\d*") ? change : null;

        durationInt.setTextFormatter(new TextFormatter<>(integerFilter));
        setsInt.setTextFormatter(new TextFormatter<>(integerFilter));
        repsInt.setTextFormatter(new TextFormatter<>(integerFilter));
    }

    @FXML
    public void validateInput(ActionEvent event) throws IOException
    {
        String d = durationInt.getText();
        String s = setsInt.getText();
        String r = repsInt.getText();

        if (d.isEmpty() || s.isEmpty() || r.isEmpty()) {
            invalidInput.setVisible(true);
            return;
        }

        int duration = Integer.parseInt(d);
        int sets = Integer.parseInt(s);
        int reps = Integer.parseInt(r);

        if (duration <= 0 || sets <= 0 || reps <= 0) {
            invalidInput.setVisible(true);
            return;
        }

        invalidInput.setVisible(false);
        switchToScene5(event, duration, sets, reps);
    }

    private void switchToScene5(ActionEvent event, int duration, int sets, int reps) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("Scene5.fxml")));
        Parent root = loader.load();

        Scene5Controller controller = loader.getController();
        controller.setWorkoutData(duration, sets, reps);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
