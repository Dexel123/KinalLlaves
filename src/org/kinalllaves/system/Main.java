package org.kinalllaves.system;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage escenarioPrincipal;

    @Override
    public void start(Stage stage) {
        escenarioPrincipal = stage;
        escenarioPrincipal.setResizable(true);

     
        cambiarEscena("/org/kinalllaves/view/login.fxml", "KinalLlaves | Iniciar sesión");
    }

    
    public static void cambiarEscena(String rutaFXML, String titulo) {
        try {
            URL url = Main.class.getResource(rutaFXML);
            if (url == null) {
                throw new IOException("No se encontró el recurso FXML: " + rutaFXML);
            }

            Parent raiz = FXMLLoader.load(url);
            Scene escena = new Scene(raiz);

            URL css = Main.class.getResource("/org/kinalllaves/view/style/styles.css");
            if (css != null) {
                escena.getStylesheets().add(css.toExternalForm());
            }

            escenarioPrincipal.setTitle(titulo);
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.sizeToScene();
            escenarioPrincipal.centerOnScreen();
            escenarioPrincipal.show();

        } catch (Exception e) {
            
            System.out.println("Aviso: No se pudo cargar '" + rutaFXML + "'. Desplegando pantalla en blanco de prueba.");

            StackPane raizBlanca = new StackPane();
            Scene escenaBlanca = new Scene(raizBlanca, 760, 560);

            escenarioPrincipal.setTitle(titulo);
            escenarioPrincipal.setScene(escenaBlanca);
            escenarioPrincipal.centerOnScreen();
            escenarioPrincipal.show();
        }
    }

    public static Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public static void main(String[] args) {
        launch(args);
    }
}