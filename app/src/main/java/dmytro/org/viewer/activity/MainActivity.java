package dmytro.org.viewer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import dmytro.org.viewer.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent login = getIntent();
        String accessToken = login.getStringExtra("accessToken");
        String refreshToken = login.getStringExtra("refreshToken");

        TextView accessTokenTextView = (TextView) findViewById(R.id.textAccessToken);
        accessTokenTextView.setText("Access token: " + accessToken);

        TextView refreshTokenTextView = (TextView) findViewById(R.id.textRefreshToken);
        refreshTokenTextView.setText("Refresh token: " + refreshToken);
    }
}
