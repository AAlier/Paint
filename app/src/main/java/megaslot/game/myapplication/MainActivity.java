package megaslot.game.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnClear);
        final Draw draw = findViewById(R.id.btnDraw);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draw.clear();
            }
        });

    }
}
