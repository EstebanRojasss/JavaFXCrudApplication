package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Escuela;
import models.Estudiante;

public class EstudiantesController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtMatricula;



    @FXML
    private TableColumn<Estudiante, String> colNombre;
    @FXML
    private TableColumn<Estudiante, String> colApellido;
    @FXML
    private TableColumn<Estudiante, String> colTelefono;

    @FXML
    private TableColumn<Estudiante, String> colMatricula;

    @FXML
    private TableView<Estudiante> tblAlumnos;


    private Escuela escuela;

    @FXML
    void actualizarAlumno(ActionEvent event) {
        actualizarAlumno();
    }

    void actualizarAlumno(){
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(txtNombre.getText());
        estudiante.setApellido(txtApellido.getText());
        estudiante.setTelefono(txtTelefono.getText());
        estudiante.setNumMatricula(txtMatricula.getText());

        escuela.actualizarTabla(estudiante);

        limpiarCampo();
        actulizarTabla();
    }


    @FXML
    void eliminarAlumno(ActionEvent event) {
        eliminarAlumno();
    }

    void eliminarAlumno(){
        Estudiante estudiante = tblAlumnos.getSelectionModel().getSelectedItem();
        escuela.borrarEstudiante(estudiante);
        actulizarTabla();
    }

    @FXML
    void guardarAlumno(ActionEvent event) {
        guardarAlumno();
    }

    void guardarAlumno(){
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(txtNombre.getText());
        estudiante.setApellido(txtApellido.getText());
        estudiante.setTelefono(txtTelefono.getText());
        estudiante.setNumMatricula(txtMatricula.getText());
        escuela.guardarEstudiante(estudiante);
        limpiarCampo();
        actulizarTabla();
    }
    @FXML
    void eliminarTodos(ActionEvent event) {
        escuela.deleteAll(escuela.getEstudiantes());
        actulizarTabla();
    }



    private void limpiarCampo() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtMatricula.setText("");

        txtMatricula.setEditable(true);
    }

    private void actulizarTabla(){
        tblAlumnos.getItems().clear();
        tblAlumnos.getItems().addAll(escuela.getEstudiantes());
        tblAlumnos.refresh();
    }

    @FXML
    void initialize(){
        colNombre.setCellValueFactory( new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory( new PropertyValueFactory<>("apellido"));
        colTelefono.setCellValueFactory( new PropertyValueFactory<>("telefono"));
        colMatricula.setCellValueFactory( new PropertyValueFactory<>("numMatricula"));

        tblAlumnos.setOnMouseClicked(mouseEvent -> {
            if(tblAlumnos.getSelectionModel().getSelectedItem() != null) cargarCampo();
        });
    }

    private void cargarCampo(){
        Estudiante estudiante = tblAlumnos.getSelectionModel().getSelectedItem();

        txtNombre.setText(estudiante.getNombre());
        txtApellido.setText(estudiante.getApellido());
        txtTelefono.setText(estudiante.getTelefono());
        txtMatricula.setText(estudiante.getNumMatricula());

        txtMatricula.setEditable(false);
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }
}
