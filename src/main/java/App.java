import controllers.EstudiantesController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Escuela;
import utils.Path;

public class App extends Application {

    public static void main(String[]args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Path.ESTUDIANTE_VIEW_PATH));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        EstudiantesController controller = loader.getController();
        controller.setEscuela( new Escuela("Mi escuela"));
        stage.show();
    }

}
