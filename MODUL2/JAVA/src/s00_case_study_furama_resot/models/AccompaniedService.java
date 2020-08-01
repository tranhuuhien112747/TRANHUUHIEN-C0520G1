package s00_case_study_furama_resot.models;

/**
 * Resort còn cung cấp các dịch vụ đi kèm như massage, karaoke, thức ăn, nước uống, thuê xe di chuyển tham quan resort.
 * Dịch vụ đi kèm sẽ bao gồm các thông tin: Tên dịch vụ đi kèm, Đơn vị, Giá tiền
 */
public class AccompaniedService {
    private String nameAccompaniedService = "NOT";
    private String unit = "NOT";
    private double price = 0.0;

    public AccompaniedService() {
    }

    public AccompaniedService(String nameAccompaniedService, String unit, double price) {
        this.nameAccompaniedService = nameAccompaniedService;
        this.unit = unit;
        this.price = price;
    }

    public String getNameAccompaniedService() {
        return nameAccompaniedService;
    }

    public void setNameAccompaniedService(String nameAccompaniedService) {
        this.nameAccompaniedService = nameAccompaniedService;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
