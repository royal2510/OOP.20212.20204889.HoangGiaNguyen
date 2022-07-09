package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ItemController {
	private Media media;
	@FXML
    private Label lblTitle;
    @FXML
    private Label lblCost;
	@FXML
    private Button btnAddToCart;
    @FXML
    private Button btnPlay;
    
    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	Cart.tmp.add(media);
    }
    @FXML
    void btnPlayClicked(ActionEvent event) {
    	try {
    		final String PLAY_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Play.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PLAY_FXML_FILE_PATH));
    		Parent root = fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setTitle("Play");
    		stage.setScene(new Scene(root));
    		stage.show();		
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

	public void setData(Media media) {
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText(Float.toString(media.getCost()));
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
		}
	}
}
