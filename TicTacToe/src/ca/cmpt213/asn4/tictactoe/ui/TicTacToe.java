package ca.cmpt213.asn4.tictactoe.ui;

import ca.cmpt213.asn4.tictactoe.game.Board;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This is the Class that sets up the board using elements from the Board class and
 * sets up the UI which effectively starts the game and displays the GUI
 * NOTE TO TA: IN VM OPTIONS YOU WILL HAVE TO ENABLE THE JAVAFX SDK
 */

public class TicTacToe extends Application {
    private ImageView[] image;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe");
        Button new_game = new Button("New Game");
        Label resultLabel = new Label();
        image = new ImageView[16];
        GridPane grid = new GridPane();
        Board game = new Board();
        VBox vbox = new VBox(10, resultLabel, new_game);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10,0,100,0));
        for (int i = 0; i < 16; i++) {
            image[i] = new ImageView(new Image("file:Q2/images/white.png"));
        }

        for (int i = 0, index = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++, index++) {
                grid.add(image[index], j, i);
            }
        }

        BorderPane border = new BorderPane();
        border.setCenter(grid);
        border.setBottom(vbox);
        new_game.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            game.clear();
            for (int i = 0; i < 16; i++) {
                image[i].setImage(new Image("file:Q2/images/white.png"));
                image[i].setDisable(false);
            }
            resultLabel.setText("");

        });

        for (int image = 0; image < 16; image++) {
            int row = GridPane.getRowIndex(this.image[image]);
            int col = GridPane.getColumnIndex(this.image[image]);
            final int index = image;
            this.image[image].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                if (game.move(row, col)) {
                    if (game.move() == 1) {
                        ((ImageView) mouseEvent.getSource()).setImage(new Image("file:Q2/images/x.png"));
                    } else {
                        ((ImageView) mouseEvent.getSource()).setImage(new Image("file:Q2/images/o.png"));
                    }
                    this.image[index].setDisable(true);
                }
                if (game.isWinner(row, col)) {
                    if (game.move() == 1) {
                        resultLabel.setText("Great Performance X! You Win");
                    }
                    else {
                        resultLabel.setText("Wow O, You've Won");
                    }
                    game.endGame(this.image);
                    return;
                }
                if (game.isDraw()) {
                    resultLabel.setText("It ends in a Draw, Play Again!");
                    game.endGame(this.image);
                    return;
                }
                game.nextMove();
            });
        }
        grid.setVgap(10);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        Scene scene = new Scene(border, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
