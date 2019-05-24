package tdc.edu.vn.myapplication;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.SimpleTimeZone;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycle;
    Vector<Youtubevideo> youtubevideos = new Vector<>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();

        setEvent();

    }

    private void setControl() {
        recycle = findViewById(R.id.list);

    }

    public void setEvent() {
       recycle.setHasFixedSize(true);
       recycle.setLayoutManager(new LinearLayoutManager(this));
       youtubevideos.add(new Youtubevideo("<iframe width=\"50%\" height=\"50%\" src=\"https://www.youtube.com/embed/R2T6TPMbyp8\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
       youtubevideos.add(new Youtubevideo("<iframe width=\"50%\" height=\"50%\" src=\"https://www.youtube.com/embed/34A2Fm9WUOM\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
       youtubevideos.add(new Youtubevideo("<iframe width=\"50%\" height=\"50%\" src=\"https://www.youtube.com/embed/lesZdC9OO5k\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
       youtubevideos.add(new Youtubevideo("<iframe width=\"50%\" height=\"50%\" src=\"https://www.youtube.com/embed/vMItj_3CkIw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
       youtubevideos.add(new Youtubevideo("<iframe width=\"50%\" height=\"50%\" src=\"https://www.youtube.com/embed/2UuUC5y6yNQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
       youtubevideos.add(new Youtubevideo("<iframe width=\"50%\" height=\"50%\" src=\"https://www.youtube.com/embed/3DM0jIYwzvA\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
       youtubevideos.add(new Youtubevideo("<iframe width=\"50%\" height=\"50%\" src=\"https://www.youtube.com/embed/QjW5YgqAcDs\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));

       YoutubeAdapter adapter = new YoutubeAdapter(youtubevideos);
       recycle.setAdapter(adapter);

    }
}
