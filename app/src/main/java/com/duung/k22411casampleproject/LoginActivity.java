package com.duung.k22411casampleproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.duung.connectors.EmployeeConnector;
import com.duung.model.Employee;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    CheckBox chkSaveLogin;

    private int backPressedCount = 0; // Đếm số lần nhấn nút Back

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addViews(); // Gọi phương thức để ánh xạ các view
    }

    private void addViews() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        chkSaveLogin = findViewById(R.id.chkSavelogininfor);
    }

    public void do_login(View view) {
        EmployeeConnector ec = new EmployeeConnector();

        String usr = edtUsername.getText().toString();
        String pwd = edtPassword.getText().toString();

        Employee e_login = ec.login(usr, pwd);
        if (e_login != null) {
            // Nếu đăng nhập thành công, chuyển sang MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            // Nếu đăng nhập thất bại
            Toast.makeText(this, "Login failed! Check your account again!", Toast.LENGTH_LONG).show();
        }
    }

    public void do_exit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

        // Thiết lập tiêu đề:
        Resources res = getResources();
        builder.setTitle(res.getText(R.string.title_confirm_exit_title));
        builder.setMessage(res.getText(R.string.title_confirm_exit_messages));

        // Không sử dụng setIcon() nếu không dùng hình ảnh
        // builder.setIcon(R.drawable.icon_resource); // Dòng này có thể bỏ nếu không cần icon

        // Thiết lập các lựa chọn của người dùng:
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Đóng ứng dụng khi người dùng chọn Yes
                finish();
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Đóng thông báo khi người dùng chọn No
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false); // Đảm bảo người dùng không thể đóng thông báo bằng cách nhấn ra ngoài
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        backPressedCount++; // Tăng số lần nhấn

        if (backPressedCount >= 3) {
            // Hiển thị thông báo khi người dùng nhấn Back 3 lần
            showExitConfirmationDialog();
            backPressedCount = 0; // Đặt lại số lần nhấn sau khi hiển thị thông báo
        } else {
            // Hiển thị thông báo cho người dùng biết số lần nhấn còn lại
            Toast.makeText(this, "Press back " + (3 - backPressedCount) + " more times to exit", Toast.LENGTH_SHORT).show();
        }
    }

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        Resources res = getResources();
        builder.setTitle(res.getText(R.string.title_confirm_exit_title));
        builder.setMessage(res.getText(R.string.title_confirm_exit_messages));

        // Không sử dụng setIcon() nữa vì không dùng hình ảnh
        // builder.setIcon(R.drawable.icon_resource); // Dòng này không cần nữa

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Thoát ứng dụng
                finish();
                System.exit(0);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel(); // Đóng thông báo khi người dùng chọn No
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false); // Đảm bảo người dùng không thể đóng thông báo bằng cách nhấn ra ngoài
        dialog.show();
    }
}
