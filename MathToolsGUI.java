package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lớp chính tạo giao diện đồ họa cho các công cụ toán học
 */
public class MathToolsGUI extends JFrame {
    private JTabbedPane tabbedPane;  // Thanh tab chứa các chức năng

    // Constructor: Khởi tạo cửa sổ chính
    public MathToolsGUI() {
        setTitle("Công Cụ Toán Học");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Hiển thị giữa màn hình

        tabbedPane = new JTabbedPane();

        // Thêm các tab chức năng vào giao diện
        tabbedPane.addTab("Giải PT bậc nhất", createLinearEquationPanel());
        tabbedPane.addTab("Số lớn nhất/nhỏ nhất", createMinMaxPanel());
        tabbedPane.addTab("Kiểm tra số đối xứng", createPalindromePanel());
        tabbedPane.addTab("Ước chung lớn nhất", createGCDPanel());
        tabbedPane.addTab("Sắp xếp tăng dần", createSortPanel());

        add(tabbedPane);  // Thêm thanh tab vào frame chính
    }

    /**
     * Tạo panel giải phương trình bậc nhất ax + b = 0
     */
    private JPanel createLinearEquationPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));  // Bố cục lưới 4x2
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Thêm padding

        // Các thành phần GUI
        JLabel lblA = new JLabel("Hệ số a:");
        JTextField txtA = new JTextField();
        JLabel lblB = new JLabel("Hệ số b:");
        JTextField txtB = new JTextField();
        JButton btnSolve = new JButton("Giải phương trình");
        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);  // Không cho chỉnh sửa kết quả

        // Xử lý sự kiện khi nhấn nút giải
        btnSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(txtA.getText());
                    double b = Double.parseDouble(txtB.getText());

                    if (a == 0) {
                        if (b == 0) {
                            txtResult.setText("Phương trình có vô số nghiệm");
                        } else {
                            txtResult.setText("Phương trình vô nghiệm");
                        }
                    } else {
                        double solution = -b / a;
                        txtResult.setText("Nghiệm: x = " + solution);
                    }
                } catch (NumberFormatException ex) {
                    txtResult.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });

        // Thêm các thành phần vào panel
        panel.add(lblA);
        panel.add(txtA);
        panel.add(lblB);
        panel.add(txtB);
        panel.add(btnSolve);
        panel.add(new JLabel());  // Ô trống để căn chỉnh bố cục
        panel.add(new JLabel("Kết quả:"));
        panel.add(new JScrollPane(txtResult));  // Thêm thanh cuộn cho vùng kết quả

        return panel;
    }

    /**
     * Tạo panel tìm số lớn nhất/nhỏ nhất giữa 2 số
     */
    private JPanel createMinMaxPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Các thành phần GUI
        JLabel lblNum1 = new JLabel("Số thứ nhất:");
        JTextField txtNum1 = new JTextField();
        JLabel lblNum2 = new JLabel("Số thứ hai:");
        JTextField txtNum2 = new JTextField();
        JButton btnFindMax = new JButton("Tìm số lớn nhất");
        JButton btnFindMin = new JButton("Tìm số nhỏ nhất");
        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);

        // Xử lý sự kiện tìm số lớn nhất
        btnFindMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(txtNum1.getText());
                    double num2 = Double.parseDouble(txtNum2.getText());
                    double max = Math.max(num1, num2);
                    txtResult.setText("Số lớn nhất: " + max);
                } catch (NumberFormatException ex) {
                    txtResult.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });

        // Xử lý sự kiện tìm số nhỏ nhất
        btnFindMin.addActionListener(new ActionListener() {
                try {
                    double num1 = Double.parseDouble(txtNum1.getText());
                    double num2 = Double.parseDouble(txtNum2.getText());
                    double min = Math.min(num1, num2);
                    txtResult.setText("Số nhỏ nhất: " + min);
                } catch (NumberFormatException ex) {
                    txtResult.setText("Vui lòng nhập số hợp lệ!");
                }
        });

        // Thêm các thành phần vào panel
        panel.add(lblNum1);
        panel.add(txtNum1);
        panel.add(lblNum2);
        panel.add(txtNum2);
        panel.add(btnFindMax);
        panel.add(btnFindMin);
        panel.add(new JLabel("Kết quả:"));
        panel.add(new JScrollPane(txtResult));

        return panel;
    }

    /**
     * Kiểm tra số đối xứng (palindrome)
     * @param num Số cần kiểm tra
     * @return true nếu là số đối xứng, ngược lại false
     */
    private boolean isPalindrome(int num) {
//---
    }

    /**
     * Tạo panel kiểm tra số đối xứng
     */
    private JPanel createPalindromePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Các thành phần GUI
        JLabel lblNumber = new JLabel("Nhập số:");
        JTextField txtNumber = new JTextField();
        JButton btnCheck = new JButton("Kiểm tra");
        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);

        // Xử lý sự kiện kiểm tra
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(txtNumber.getText());
                    if (isPalindrome(number)) {
                        txtResult.setText(number + " là số đối xứng");
                    } else {
                        txtResult.setText(number + " không phải số đối xứng");
                    }
                } catch (NumberFormatException ex) {
                    txtResult.setText("Vui lòng nhập số nguyên hợp lệ!");
                }
            }
        });

        // Thêm các thành phần vào panel
        panel.add(lblNumber);
        panel.add(txtNumber);
        panel.add(btnCheck);
        panel.add(new JLabel());
        panel.add(new JLabel("Kết quả:"));
        panel.add(new JScrollPane(txtResult));

        return panel;
    }

    /**
     * Tìm ước chung lớn nhất (GCD) bằng thuật toán Euclid
     * @param a Số thứ nhất
     * @param b Số thứ hai
     * @return ƯCLN của a và b
     */
    private int findGCD(int a, int b) {
                a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Tạo panel tìm ƯCLN
     */
    private JPanel createGCDPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Các thành phần GUI
        JLabel lblNum1 = new JLabel("Số thứ nhất:");
        JTextField txtNum1 = new JTextField();
        JLabel lblNum2 = new JLabel("Số thứ hai:");
        JTextField txtNum2 = new JTextField();
        JButton btnFindGCD = new JButton("Tìm ƯCLN");
        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);

        // Xử lý sự kiện tìm ƯCLN
        btnFindGCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                    int num1 = Integer.parseInt(txtNum1.getText());
                    int num2 = Integer.parseInt(txtNum2.getText());
                    int gcd = findGCD(num1, num2);
                    txtResult.setText("Ước chung lớn nhất: " + gcd);
                } catch (NumberFormatException ex) {
                    txtResult.setText("Vui lòng nhập số nguyên hợp lệ!");
                }
            }            }
        });

        // Thêm các thành phần vào panel
        panel.add(lblNum1);
        panel.add(txtNum1);
        panel.add(lblNum2);
        panel.add(txtNum2);
        panel.add(btnFindGCD);
        panel.add(new JLabel());
        panel.add(new JLabel("Kết quả:"));
        panel.add(new JScrollPane(txtResult));

        return panel;
    }

    /**
     * Tạo panel sắp xếp 2 số tăng dần
     */
    private JPanel createSortPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Các thành phần GUI
        JLabel lblNum1 = new JLabel("Số thứ nhất:");
        JTextField txtNum1 = new JTextField();
        JLabel lblNum2 = new JLabel("Số thứ hai:");
        JTextField txtNum2 = new JTextField();
        JButton btnSort = new JButton("Sắp xếp tăng dần");
        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);

        // Xử lý sự kiện sắp xếp
        btnSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                    double num1 = Double.parseDouble(txtNum1.getText());
                    double num2 = Double.parseDouble(txtNum2.getText());
                    
                    if (num1 <= num2) {
                        txtResult.setText(num1 + ", " + num2);
                    } else {
                        txtResult.setText(num2 + ", " + num1);
                    }
                } catch (NumberFormatException ex) {
                    txtResult.setText("Vui lòng nhập số hợp lệ!");
                }
            }            }
        });

        // Thêm các thành phần vào panel
        panel.add(lblNum1);
        panel.add(txtNum1);
        panel.add(lblNum2);
        panel.add(txtNum2);
        panel.add(btnSort);
        panel.add(new JLabel());
        panel.add(new JLabel("Kết quả:"));
        panel.add(new JScrollPane(txtResult));

        return panel;
    }

    // Hàm main khởi chạy ứng dụng
    public static void main(String[] args) {
        // Đảm bảo giao diện chạy trên luồng EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MathToolsGUI().setVisible(true);
            }
        });
    }
}