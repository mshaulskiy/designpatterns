package net.uk.interconnect.dependencyinjection;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class Controller {
    // wire up the private member variables for the different UI elements.
    // We use the @FXML annotation. This helps the FXMLLoader to match the UI elements
    // to the correct member variables. Make sure the names of the member variables match
    // the names we gave when we were setting up the UI in scenebuilder


    @FXML
    private TextField urlTextField;

    @FXML
    private Button goButton;

    @FXML
    private TextField currentUrlTextField;

    @FXML
    private WebView browser;

    @FXML
    private TextArea summaryTextArea;

    @FXML
    private TreeView treeView;

    private String currentUrl = "http://doxydonkey.blogspot.in";
    // we set up the default earlier as usual

    // Let's set up the maps with UrlInfo and Tree node information
    private Map<TreeItem, UrlInfo> urlInfoMap = new HashMap<>();
    private Map<String, TreeItem> treeNodeMap = new HashMap<>();

    @FXML
    public void initialize() {

        // The initialize method with the @FXML annotation will be looked for and run by the
        // FXMLLoader. This is basically where we wire up the controller.

        // Ok - now that we are satisfied that the basic wiring works, let's set up the controller
        // in earnest
        // first - wire up the general code for changing the current url (i.e. the stuff that
        // runs when the go button is clicked
        treeView.setRoot(new TreeItem<>("URLs"));
        go(currentUrl);
        // let's bind the text field which shows currentDisplayedURL to the contents of the
        // Url text field. The initialize() function is perfect for such code - you could also
        // choose to wire this up in the fxml
        currentUrlTextField.textProperty().bind(browser.getEngine().locationProperty());

        // there are two more involved listeners/customizations needed to the treeview, we will add
        // these here in the initialize() method
        treeView.setCellFactory(p -> new TextFieldTreeCellImpl());

        treeView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) ->
                {
                    TreeItem treeItem = (TreeItem) newValue;
                    if (newValue != null && urlInfoMap.containsKey(newValue)) {
                        UrlInfo urlInfo = urlInfoMap.get(treeItem);
                        urlTextField.setText(urlInfo.getUrl());
                        summaryTextArea.setText(urlInfo.getSummary());
                        browser.getEngine().load(urlInfo.getUrl());
                    }
                });


    }

    private void go(String someUrl) {
        // update our currentUrl internal state variable
        this.currentUrl = someUrl;

        // update the url text field - this line is only needed if the
        // change in URL is via the tree (and not from the urlTextField itself)
        urlTextField.setText(currentUrl);

        //update the main browser display
        browser.getEngine().load(currentUrl);

        // figure out whether a new tree node is needed or not, and
        // either way the internal maps get updated
        TreeItem<String> childNode = null;
        if (treeNodeMap.containsKey(currentUrl)) {
            childNode = treeNodeMap.get(currentUrl);
        } else {
            childNode = new TreeItem<>(currentUrl);
            treeNodeMap.put(currentUrl, childNode);
            treeView.getRoot().getChildren().add(childNode);
        }

        if (!urlInfoMap.containsKey(childNode)) {
            urlInfoMap.put(childNode, new UrlInfo(currentUrl));
        }

        // update the tree - again this line is not needed if the source of the update was the tree
        treeView.getSelectionModel().select(childNode);
        // update the summary text area so it shows the new summary
        summaryTextArea.setText(urlInfoMap.get(childNode).getSummary());

        // we have yet to wire up the selectionArea to update the contents of the underlying urlInfo object
        summaryTextArea.textProperty().addListener(
                e -> {
                    currentUrl = urlTextField.getText();
                    if (treeNodeMap.containsKey(currentUrl)) {
                        urlInfoMap.get(treeNodeMap.get(currentUrl)).setSummary(summaryTextArea.getText());
                    }
                }
        );
    }

    @FXML
    public void handleExitMenuAction() {
        Platform.exit();
    }

    @FXML
    public void handleSaveMenuAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Snippet File");
        File selectedFile = fileChooser.showSaveDialog(null);
        if (selectedFile != null) {
            HtmlWriter.writeToHTML(selectedFile.getAbsolutePath(), urlInfoMap.values());
            go(selectedFile.toURI().toString());
        }
    }

    // There was a bug here. The actionhandler for gobutton doesn't take an argument
    @FXML
    public void handleGoButtonClick() {
        go(urlTextField.getText());
    }

    @FXML
    public void handleOnEditCommit(TreeView.EditEvent event) {
        urlInfoMap.get(event.getTreeItem()).setHeadline(event.getNewValue().toString());
    }


}



















