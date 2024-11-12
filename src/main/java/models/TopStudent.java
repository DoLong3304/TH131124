package models;

import java.sql.Date;

public class TopStudent extends Student {
    private Double diemcaonhat;  // Additional field for top students

    // Constructor with additional diemcaonhat field
    public TopStudent(String masv, String hoten, Date ngaysinh, String gioitinh, String malop, Double diemcaonhat) {
        super(masv, hoten, ngaysinh, gioitinh, malop); // Call the superclass constructor
        this.diemcaonhat = diemcaonhat;
    }

    // Getter for diemcaonhat
    public Double getDiemcaonhat() {
        return diemcaonhat;
    }

    public void setDiemcaonhat(Double diemcaonhat) {
        this.diemcaonhat = diemcaonhat;
    }
}
