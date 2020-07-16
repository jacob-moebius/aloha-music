//TODO: Create new activity: SplashActivity
//TODO: Design layout file with a background of the hawaii_wave.png (in drawable folder)
//TODO: In onCreate of SplashActivity, fire an Intent and delay 2-3 seconds before
//TODO: starting the MainActivity
//TODO: Edit the AndroidManifest.xml to indicate SplashActivity is the LAUNCHER (starting activity)

package edu.miracostacollege.cs134.alohamusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    // DONE: Define fields for the 3 buttons
    private Button ukuleleButton, ipuButton, hulaButton;

    // DONE: Define fields for the 2 MediaPlayer objects (ukulele and ipu)
    MediaPlayer ukuleleMediaPlayer, ipuMediaPlayer;

    // DONE: Define field for the VideoView (hula video)
    VideoView hulaVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DONE: Wire up the 3 buttons
        ukuleleButton = findViewById(R.id.ukuleleButton);
        ipuButton = findViewById(R.id.ipuButton);
        hulaButton = findViewById(R.id.hulaButton);

        // DONE: Wire up the MediaPlayers
        ukuleleMediaPlayer = MediaPlayer.create(this, R.raw.ukulele);
        ipuMediaPlayer = MediaPlayer.create(this, R.raw.ipu);

        // DONE: Wire up the VideoView
        hulaVideoView = findViewById(R.id.hulaVideoView);

        // DONE: Set the video URI of the VideoView (android.resource:// + getPackageName() + R.raw.hula
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/" + R.raw.hula);
        hulaVideoView.setVideoURI(uri);

        // DONE: Set the media controller of the VideoView to a new instance
        hulaVideoView.setMediaController( new MediaController(this));
    }

    // DONE: Create new method playMedia(View v)
    public void playMedia(View v) {
        // DONE: Make a decision on the view's id using switch statement
        switch (v.getId()) {
            case R.id.ukuleleButton:
                // DONE: Case R.id.ukuleleButton: check to see if the media player is playing:
                // DONE: If true, pause the music, set the text to Play Ukulele Song and make the other buttons VISIBLE
                if (ukuleleMediaPlayer.isPlaying()) {
                    ukuleleMediaPlayer.pause();

                    // Other Buttons should become VISIBLE
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);

                    // Change text to "Play Ukulele Song"
                    ukuleleButton.setText(getString(R.string.ukulele_button_play_text));
                }

                // DONE: Else, start the media player, set the text to Pause Ukulele Song and make the other buttons INVISIBLE
                else {
                    ukuleleMediaPlayer.start();

                    // Other Buttons should become INVISIBLE
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);

                    // Change text to "Pause Ukulele Song"
                    ukuleleButton.setText(getString(R.string.ukulele_button_pause_text));
                }
                break;

            // DONE: Case R.id.ipuButton: check to see if the media player is playing:
            case R.id.ipuButton:
                // DONE: If true, pause the music, set the text to Play Ipu Song and make the other buttons VISIBLE
                if (ipuMediaPlayer.isPlaying()) {
                    ipuMediaPlayer.pause();

                    // Other Buttons should become VISIBLE
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);

                    // Change text to "Play Ipu Song"
                    ipuButton.setText(getString(R.string.ipu_button_play_text));
                }

                // DONE: Else, start the media player, set the text to Pause Ipu Song and make the other buttons INVISIBLE
                else {
                    ipuMediaPlayer.start();

                    // Other Buttons should become INVISIBLE
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);

                    // Change text to "Pause Ipu Song"
                    ipuButton.setText(getString(R.string.ipu_button_pause_text));
                }
                break;

            // DONE: Case R.id.hulaButton: check to see if the VideoView is playing:
            case R.id.hulaButton:
                // DONE: If true, pause the VideoView, set the text to Watch Hula Video and make the other buttons VISIBLE
                if (hulaVideoView.isPlaying()) {
                    hulaVideoView.pause();

                    // Other Buttons should become VISIBLE
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);

                    // Change text to "Watch Hula Song"
                    hulaButton.setText(getString(R.string.hula_button_watch_text));
                }

                // DONE: Else, start the VideoView and make the other buttons INVISIBLE
                else {
                    hulaVideoView.start();

                    // Other Buttons should become INVISIBLE
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);

                    // Change text to "Pause Hula Video"
                    hulaButton.setText(getString(R.string.hula_button_pause_text));
                }
                break;
        }
    }
}
