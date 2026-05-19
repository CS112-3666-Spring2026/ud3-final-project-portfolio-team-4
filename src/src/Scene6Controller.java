import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene6Controller {

    @FXML private Label durationLabel;
    @FXML private Label distanceLabel;
    @FXML private Label avgPaceLabel;
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


    public void setWorkoutData(int duration, int distance)
    {
        Cardio workout = new Cardio(duration, distance, 0, 0, 0);
        int avgPace = workout.calculatePace(duration, distance);
        int heartRate = workout.heartRate(duration, distance);
        int calories = workout.calculateCalories();

        Controller.MANAGER.addWorkout(workout);

        durationLabel.setText("Duration (Min): " + duration);
        distanceLabel.setText("Distance (Mi): " + distance);
        avgPaceLabel.setText("Average Pace: " + avgPace);
        heartrateLabel.setText("Heartrate (BPM): " + heartRate);
        cbLabel.setText("Calories Burned (cal): " + calories);
    }
}
