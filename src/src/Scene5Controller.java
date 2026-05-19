import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Scene5Controller {

    @FXML private Label durationLabel;
    @FXML private Label setsLabel;
    @FXML private Label repsLabel;
    @FXML private Label heartrateLabel;
    @FXML private Label cbLabel;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setWorkoutData(int duration, int sets, int reps) {
        Weight workout = new Weight(duration, sets, reps, 0, 0);
        int heartRate = workout.heartRate(duration, sets, reps);
        int calories = workout.calculateCalories();

        Controller.MANAGER.addWorkout(workout);

        durationLabel.setText("Duration (Min): " + duration);
        setsLabel.setText("Sets: " + sets);
        repsLabel.setText("Reps: " + reps);
        heartrateLabel.setText("HeartRate (BPM): " + heartRate);
        cbLabel.setText("Calories Burned (cal): " + calories);
    }
}
