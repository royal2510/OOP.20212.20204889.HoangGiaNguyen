package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Store store;
	private Cart cart;
	ObservableList<Media> lMedia = FXCollections.observableArrayList();
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, Integer> colMediaId;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Label costLabel;
    
	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
	
	@FXML
	public void initialize() {
		colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		for (int i = 0; i < Cart.tmp.size(); i++) {
			cart.addMedia(Cart.tmp.get(i));
		}
		Cart.tmp.clear();
		for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
			lMedia.add(cart.getItemsOrdered().get(i));
		}
		if (cart.getItemsOrdered() != null) {
			tblMedia.setItems(lMedia);
		}
		costLabel.setText(Float.toString(cart.totalCost()) + "$");
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}
		});
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
	}
	
	void updateButtonBar(Media media) {
		if (media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		}
		else {
			btnRemove.setVisible(true);
			if (media instanceof Playable) {
				btnPlay.setVisible(true);
			}
			else {
				btnPlay.setVisible(false);
			}
		}
	}
	
	void showFilteredMedia(String val) {
		List<Media> tmp;
		lMedia.clear();
		if (radioBtnFilterId.isSelected()) {
			if (val != "") {
				tmp = cart.searchAllMatches(Integer.parseInt(val));
			}
			else {
				tmp = cart.searchAllMatches("");
			}
			for (int i = 0; i < tmp.size(); i++) {
				lMedia.add(tmp.get(i));
			}
		}
		else if (radioBtnFilterTitle.isSelected()) {
			tmp = cart.searchAllMatches(val);
			for (int i = 0; i < tmp.size(); i++) {
				lMedia.add(tmp.get(i));
			}
		}
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		lMedia.remove(media);
		costLabel.setText(Float.toString(cart.totalCost()) + "$");
	}
	
	@FXML
    void btnPlayPressed(ActionEvent event) {
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

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
    		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
    		fxmlLoader.setController(viewStoreController);
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {

    }
}
