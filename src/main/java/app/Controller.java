package app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.util.UUID;

import enums.ShoeCategory;

public class Controller {

    @FXML private TableView<ShoeProductModel> shoeTable;
    @FXML private ComboBox<String> categoryFilter;
    @FXML private Label totalLabel;
    @FXML private TextField custNameInput, custAddressInput;
    
    @FXML private VBox employeePanel;
    @FXML private PasswordField adminPasswordField;

    private ArrayList<OrderItemModel> cart = new ArrayList<>();
    private double currentTotal = 0.0;

    public void initialize() {
        DataManager.loadStarterShoes();

        categoryFilter.getItems().add("ALL");
        for (ShoeCategory cat : ShoeCategory.values()) {
            categoryFilter.getItems().add(cat.toString());
        }
        categoryFilter.setValue("ALL");

        refreshTable(DataManager.allShoes);
    }

    // customer logic

    @FXML
    public void handleFilter() {
        String selected = categoryFilter.getValue();
        ArrayList<ShoeProductModel> filtered = new ArrayList<>();
        for (ShoeProductModel s : DataManager.allShoes) {
            if (selected.equals("ALL") || s.getCategory().toString().equals(selected)) {
                filtered.add(s);
            }
        }
        refreshTable(filtered);
    }

    @FXML
    public void handleAddToCart() {
        ShoeProductModel selected = shoeTable.getSelectionModel().getSelectedItem();
        if (selected != null && selected.getStockQuantity() > 0) {
            selected.stockQuantity -= 1;
            
            currentTotal += selected.getPrice();
            totalLabel.setText("Total: €" + String.format("%.2f", currentTotal));
            
            cart.add(new OrderItemModel(1, selected.getPrice(), null, selected.getSku()));
            
            shoeTable.refresh();
        } else if (selected != null) {
            System.out.println("Nav noliktavā!");
        }
    }

    @FXML
    public void handleCheckout() {
        if (custNameInput.getText().isEmpty() || cart.isEmpty()) {
            System.out.println("Kļūda: Ievadiet vārdu vai pievienojiet preci!");
            return;
        }
        System.out.println("Pasūtījums veiksmīgs klientam: " + custNameInput.getText());
        
        cart.clear();
        currentTotal = 0;
        totalLabel.setText("Total: €0.00");
        custNameInput.clear();
        custAddressInput.clear();
    }

    // ghetto admin logic

    @FXML
    public void handleAdminLogin() {
        if (adminPasswordField.getText().equals("admin123")) {
            employeePanel.setVisible(true);
            adminPasswordField.clear();
        } else {
            employeePanel.setVisible(false);
            System.out.println("Nepareiza parole!");
        }
    }

    @FXML
    public void handleRestock() {
        ShoeProductModel selected = shoeTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.stockQuantity += 10; // ghetto
            shoeTable.refresh();
        }
    }

    private void refreshTable(ArrayList<ShoeProductModel> list) {
        shoeTable.setItems(FXCollections.observableArrayList(list));
    }
}