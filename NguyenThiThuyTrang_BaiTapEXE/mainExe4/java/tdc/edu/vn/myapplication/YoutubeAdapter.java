package tdc.edu.vn.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.VideoHolder> {
    List<Youtubevideo> youtubevideos;

    public YoutubeAdapter(Vector<Youtubevideo> youtubevideos) {
        this.youtubevideos = youtubevideos;
    }

    @NonNull
    @Override
    public YoutubeAdapter.VideoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);

        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeAdapter.VideoHolder videoHolder, int i) {
        videoHolder.webView.loadData(youtubevideos.get(i).getVideo(), "text/html", "urf-8");
    }

    @Override
    public int getItemCount() {
        return youtubevideos.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder{
        WebView webView;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            webView = (WebView) itemView.findViewById(R.id.youtube);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient(){

            });
        }
    }
}
