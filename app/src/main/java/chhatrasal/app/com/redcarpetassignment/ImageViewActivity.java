package chhatrasal.app.com.redcarpetassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        Picasso.with(this)
                .load(getIntent().getStringExtra("url"))
                .into((ImageView) findViewById(R.id.full_screen_view));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in_back, R.anim.fade_out_back);
    }
}
