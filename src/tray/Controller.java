package tray;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import tray.animation.AnimationType;
import tray.notif.NotificationType;
import tray.notif.TrayNotification;

public class Controller implements Initializable
{
  @FXML
  private TextField txtTitle;
  @FXML
  private TextField txtMessage;
  @FXML
  private TextField txtDelay;
  @FXML
  private ImageView imgView;
  @FXML
  private ColorPicker fillPicker;
  @FXML
  private ComboBox<String> cboNotificationType;
  @FXML
  private ComboBox<String> cboAnimations;
  @FXML
  private Pane middlePane;
  TrayNotification tray;
  
  public void initialize(URL location, ResourceBundle resources)
  {
    this.tray = new TrayNotification();
    
    this.txtTitle.setText("WhatsApp");
    this.txtMessage.setText("Omni - Sup? Let me know when you wan that RF mate.");
    this.txtDelay.setText("3000");
    
    this.fillPicker.setValue(javafx.scene.paint.Color.web("#2A9A84"));
    
    this.cboNotificationType.getItems().addAll(new String[] { "Success", "Information", "Notice", "Warning", "Error", "Custom" });
    this.cboAnimations.getItems().addAll(new String[] { "Slide", "Fade", "Popup" });
    
    this.cboNotificationType.getSelectionModel().selectLast();
    this.cboAnimations.getSelectionModel().selectFirst();
    
    this.cboNotificationType.fireEvent(new ActionEvent());
    
    this.imgView.setImage(new Image(getClass().getResource("whatsapp-128.png").toString()));
  }
  
  @FXML
  private void btnShow_onAction(ActionEvent event) {
    setTray();
    
    this.tray.showAndWait();
  }
  
  @FXML
  private void btnDismiss_onAction(ActionEvent event) {
    this.tray.dismiss();
  }
  
  @FXML
  private void btnShowDimisss_onAction(ActionEvent event) {
    setTray();
    
    this.tray.showAndDismiss(javafx.util.Duration.millis(Double.parseDouble(this.txtDelay.getText())));
  }
  
  @FXML
  private void cboNotificationType_onAction(ActionEvent event) {
    if (getNotificationType(this.cboNotificationType) == NotificationType.CUSTOM) {
      this.middlePane.setDisable(false);
      this.imgView.setVisible(true);
    } else {
      this.middlePane.setDisable(true);
      this.imgView.setVisible(false);
    }
  }
  
  private NotificationType getNotificationType(ComboBox<String> cbo)
  {
    NotificationType notifyType = null;
    
    switch ((String)cbo.getSelectionModel().getSelectedItem())
    {
    case "Information": 
      notifyType = NotificationType.INFORMATION;
      break;
    
    case "Notice": 
      notifyType = NotificationType.NOTICE;
      break;
    
    case "Success": 
      notifyType = NotificationType.SUCCESS;
      break;
    
    case "Warning": 
      notifyType = NotificationType.WARNING;
      break;
    
    case "Error": 
      notifyType = NotificationType.ERROR;
      break;
    
    case "Custom": 
      notifyType = NotificationType.CUSTOM;
    }
    
    
    return notifyType;
  }
  
  private AnimationType getAnimationType(ComboBox<String> cbo)
  {
    AnimationType animationType = null;
    
    switch ((String)cbo.getSelectionModel().getSelectedItem())
    {
    case "Slide": 
      animationType = AnimationType.SLIDE;
      break;
    
    case "Fade": 
      animationType = AnimationType.FADE;
      break;
    
    case "Popup": 
      animationType = AnimationType.POPUP;
    }
    
    
    return animationType;
  }
  
  private void setTray()
  {
    this.tray.setTitle(this.txtTitle.getText());
    this.tray.setMessage(this.txtMessage.getText());
    this.tray.setAnimationType(getAnimationType(this.cboAnimations));
    
    NotificationType selectedType = getNotificationType(this.cboNotificationType);
    
    if (selectedType == NotificationType.CUSTOM) {
      this.tray.setRectangleFill((javafx.scene.paint.Paint)this.fillPicker.getValue());
      this.tray.setImage(this.imgView.getImage());
    } else {
      this.tray.setNotificationType(selectedType);
    }
  }
  
  @FXML
  private void btnBrowseImage_onAction(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Image");
    
    fileChooser.getExtensionFilters().add(new javafx.stage.FileChooser.ExtensionFilter("Images", new String[] { "*.png", "*.jpg", "*.gif" }));
    
    java.io.File file = fileChooser.showOpenDialog(this.imgView.getScene().getWindow());
    
    if (file != null) {
      this.imgView.setImage(new Image("file:" + file.getPath()));
    }
  }
}
