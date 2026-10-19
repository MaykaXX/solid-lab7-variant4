package task3;

public class WarehouseManager {
    // Метод приймає лише фізичні товари, контракт гарантує коректне повернення
    public void processDefectiveReturn(PhysicalInventoryItem item, int quantity) {
        item.returnToSupplier(quantity);
    }
}