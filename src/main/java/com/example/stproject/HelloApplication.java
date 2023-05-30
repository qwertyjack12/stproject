package com.example.stproject;

import com.example.stproject.server.API;
import com.example.stproject.server.ProjectInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.concurrent.Executors;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        var retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create()).build();
        var request = retrofit.create(API.class);

        var ex = Executors.newSingleThreadExecutor();

        ex.execute(()-> {
            try {
                var result = request.greeting(1).execute();
                assert result.body() != null;

                ProjectInfo.getState().setStudentId(Integer.parseInt((String) result.body().get("studentId")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("image/app_ico.png")).toURI().toURL().toString()));
        stage.setTitle("Application");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
