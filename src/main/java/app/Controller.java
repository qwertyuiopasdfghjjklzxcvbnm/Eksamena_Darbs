package app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import enums.ShoeCategory;

public class Controller {

    @FXML private TableView<ShoeProductModel> shoeTable;
    @FXML private ComboBox<String> categoryFilter;
    @FXML private Label totalLabel;
    @FXML private TextField customerName, customerAddress;
    
    @FXML private VBox employeePanel;
    @FXML private PasswordField adminPassword;

    private ArrayList<OrderItemModel> cart = new ArrayList<>();
    private double currentTotal = 0.0;

    public void initialize() {
        DataManager.testShoes();

        categoryFilter.getItems().add("ALL");
        for (ShoeCategory category : ShoeCategory.values()) {
            categoryFilter.getItems().add(category.toString());
        }
        categoryFilter.setValue("ALL");

        refreshTable(DataManager.allShoes);
    }

    // customer logic

    @FXML
    public void Filter() {
        String selected = categoryFilter.getValue();
        ArrayList<ShoeProductModel> filtered = new ArrayList<>();
        for (ShoeProductModel shoe : DataManager.allShoes) {
            if (selected.equals("ALL") || shoe.getCategory().toString().equals(selected)) {
                filtered.add(shoe);
            }
        }
        refreshTable(filtered);
    }

    @FXML
    public void AddToCart() {
        ShoeProductModel selected = shoeTable.getSelectionModel().getSelectedItem();
        if (selected != null && selected.getStockQuantity() > 0) {
            selected.stockQuantity -= 1;
            
            currentTotal += selected.getPrice();
            totalLabel.setText("Total: €" + String.format("%.2f", currentTotal));
            
            cart.add(new OrderItemModel(1, selected.getPrice(), null, selected.getStockID()));
            
            shoeTable.refresh();
        } else if (selected != null) {
            System.out.println("Nav noliktavā!");
        }
    }

    @FXML
    public void Checkout() {
        if (customerName.getText().isEmpty() || cart.isEmpty()) {
            System.out.println("Kļūda: Ievadiet vārdu vai pievienojiet preci!");
            return;
        }
        System.out.println("Pasūtījums veiksmīgs klientam: " + customerName.getText());
        
        cart.clear();
        currentTotal = 0;
        totalLabel.setText("Total: €0.00");
        customerName.clear();
        customerAddress.clear();
    }

    // ghetto admin logic

    @FXML
    public void AdminLogin() {
        if (adminPassword.getText().equals("admin123")) {
            employeePanel.setVisible(true);
            adminPassword.clear();
        } else {
            employeePanel.setVisible(false);
            System.out.println("Nepareiza parole!");
        }
    }

    @FXML
    public void Restock() {
        ShoeProductModel selected = shoeTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.stockQuantity += 10; // riktigi ghetto, vajadzetu profesionalak
            shoeTable.refresh();
        }
    }

    private void refreshTable(ArrayList<ShoeProductModel> list) {
        shoeTable.setItems(FXCollections.observableArrayList(list));
    }
}