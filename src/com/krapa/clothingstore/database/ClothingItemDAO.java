package com.krapa.clothingstore.database;
import com.krapa.clothingstore.model.ClothingItem;
import com.krapa.clothingstore.model.Shirt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClothingItemDAO {
    public void insertClothingItem(ClothingItem clothingItem) {
        String sql = "INSERT INTO clothingitem (name, price, size, brand, quantity, item_type) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set parameters (? → actual values)
            statement.setString(1, clothingItem.getItemName());
            statement.setDouble(2, clothingItem.getItemPrice());
            statement.setString(3, clothingItem.getItemSize());
            statement.setString(4, clothingItem.getItemBrand());
            statement.setInt(5, clothingItem.getItemQuantity());
            statement.setString(6, clothingItem.getItemType());
            // Execute INSERT
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Clothing item inserted successfully!");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("❌ Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public void getAllClothingItems() {
        String sql = "SELECT * FROM clothingitem";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\n--- ALL CLOTHING ITEMS FROM DATABASE ---");
            while (resultSet.next()) {
                int id = resultSet.getInt("item_id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String size = resultSet.getString("size");
                String brand = resultSet.getString("brand");
                int quantity = resultSet.getInt("quantity");
                String item_type = resultSet.getString("item_type");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price: " + price);
                System.out.println("Size: " + size);
                System.out.println("Brand: " + brand);
                System.out.println("Quantity: " + quantity);
                System.out.println("Type: " + item_type);
                System.out.println("---");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("❌ Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public boolean updateShirt(Shirt shirt) {
        String sql = "UPDATE clothingitem SET name = ?, price = ?, " + "size = ?, brand = ?, quantity = ? " + "WHERE item_id = ? AND item_type = 'SHIRT'";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, shirt.getItemName());
            statement.setDouble(2, shirt.getItemPrice());
            statement.setString(3, shirt.getItemSize());
            statement.setString(4, shirt.getItemBrand());
            statement.setInt(5, shirt.getItemQuantity());
            statement.setInt(6, shirt.getItemId()); // WHERE condition
            int rowsUpdated = statement.executeUpdate();
            statement.close();
            if (rowsUpdated > 0) {
                System.out.println("✅ Shirt updated: " + shirt.getItemName());
                return true;
            }
        } catch (SQLException e) {
            System.out.println("❌ Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }
    public ClothingItem getItemById(int itemId) {
        String sql = "SELECT * FROM clothingitem WHERE item_id = ?";
        Connection connection = DatabaseConnection.getConnection();

        if (connection == null) {
            return null;
        }

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, itemId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("item_id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String size = resultSet.getString("size");
                String brand = resultSet.getString("brand");
                int quantity = resultSet.getInt("quantity");
                String type = resultSet.getString("item_type");

                if ("SHIRT".equalsIgnoreCase(type)) {
                    return new Shirt(id, name, price, size, brand, quantity, "SHIRT");
                }
                return null;
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }
    public boolean deleteClothingItem(int itemId) {
        String sql = "DELETE FROM clothingitem WHERE item_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, itemId);
            int rowsDeleted = statement.executeUpdate();
            statement.close();
            if (rowsDeleted > 0) {
                System.out.println("✅ Clothing item deleted (ID: " + itemId + ")");
                return true;
            } else {
                System.out.println("No clothes found with ID: " + itemId);

            }
        } catch (SQLException e) {
            System.out.println("❌ Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }
    private ClothingItem extractClothingItemFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("item_id");
        String name = rs.getString("name");
        double price = rs.getDouble("price");
        String size = rs.getString("size");
        String brand = rs.getString("brand");
        int quantity = rs.getInt("quantity");
        String type = rs.getString("item_type");

        if ("SHIRT".equalsIgnoreCase(type)) {
            return new Shirt(id, name, price, size, brand, quantity, type);
        }
        else{
            return null;
        }
    }

    public List<ClothingItem> searchByName(String name) {
        List<ClothingItem> clothingItemList = new ArrayList<>();
        // ILIKE = case-insensitive
        // % = wildcard (matches any characters)
        String sql = "SELECT * FROM clothingitem WHERE name ILIKE ? ORDER BY name";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return clothingItemList;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%"); // Add wildcards!
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClothingItem clothingItem = extractClothingItemFromResultSet(resultSet);
                if (clothingItem != null) {
                    clothingItemList.add(clothingItem);
                }
            }
            resultSet.close();
            statement.close();
            System.out.println("✅ Found " + clothingItemList.size() + " clothing item");
        } catch (SQLException e) {
            System.out.println("❌ Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return clothingItemList;
    }

    public List<ClothingItem> searchByPriceRange(double minPrice, double maxPrice) {
        List<ClothingItem> clothingItemList = new ArrayList<>();
        // BETWEEN includes both min and max (inclusive)
        String sql = "SELECT * FROM clothingitem " +
                "WHERE price BETWEEN ? AND ? " +
                "ORDER BY price DESC";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return clothingItemList;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClothingItem item = extractClothingItemFromResultSet(resultSet);
                if (item != null) {
                    clothingItemList.add(item);
                }
            }
            resultSet.close();
            statement.close();
            System.out.println("✅ Found " + clothingItemList.size() + " clothing item");
        } catch (SQLException e) {
            System.out.println("❌ Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return clothingItemList;
    }

    public List<ClothingItem> searchByMinPrice(double minPrice) {
        List<ClothingItem> clothingItemList = new ArrayList<>();
        String sql = "SELECT * FROM clothingitem " +
                "WHERE price >= ? " +
                "ORDER BY price DESC";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return clothingItemList;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClothingItem item = extractClothingItemFromResultSet(resultSet);
                if (item != null) {
                    clothingItemList.add(item);
                }
            }
            resultSet.close();
            statement.close();
            System.out.println("✅ Found " + clothingItemList.size() + " clothing item");
        } catch (SQLException e) {
            System.out.println("❌ Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return clothingItemList;
    }

}
