package dmytro.org.viewer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import dmytro.org.viewer.HttpClient;
import dmytro.org.viewer.R;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText passwordEditText;
    private HttpClient httpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        httpClient = new HttpClient();

        loginEditText = (EditText) findViewById(R.id.editLogin);

        loginEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginEditText.getText().toString().equals(getString(R.string.login))) {
                    loginEditText.setText("");
                }
            }
        });

        passwordEditText = (EditText) findViewById(R.id.editPassword);

        passwordEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordEditText.getText().toString().equals(getString(R.string.password))) {
                    passwordEditText.setText("");
                }
            }
        });
    }

    public void onClickLoginButton(View view) throws IOException, JSONException {
        JSONObject response = httpClient.authorize(
                loginEditText.getText().toString(),
                passwordEditText.getText().toString()
        );

        View errorMessageView = findViewById(R.id.incorrectLoginPasswordView);
        if (response.getInt("httpStatus") != 200) {
            errorMessageView.setVisibility(View.VISIBLE);
        } else {
            errorMessageView.setVisibility(View.INVISIBLE);
            String accessToken = response.getString("accessToken");
            String refreshToken = response.getString("refreshToken");
            Intent main = new Intent(this, MainActivity.class);
            main.putExtra("accessToken", accessToken);
            main.putExtra("refreshToken", refreshToken);
            startActivity(main);
            finish();
        }
    }
}
