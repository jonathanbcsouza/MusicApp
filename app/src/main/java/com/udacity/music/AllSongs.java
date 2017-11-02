package com.udacity.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllSongs extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Artist1
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(getString(R.string.artist1) + "\n" + getString(R.string.artist1music1), R.drawable.ic_play_arrow_white_24dp, R.raw.johnhindemith_lightanddarkness));
        words.add(new Word(getString(R.string.artist2) + "\n" + getString(R.string.artist1music2), R.drawable.ic_play_arrow_white_24dp, R.raw.johnhindemith_enlightening));
        //Artist2
        words.add(new Word(getString(R.string.artist2) + "\n" + getString(R.string.artist2music1), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_dead_man_wag));
        words.add(new Word(getString(R.string.artist2) + "\n" + getString(R.string.artist2music2), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_white_horse));
        words.add(new Word(getString(R.string.artist2) + "\n" + getString(R.string.artist2music3), R.drawable.ic_play_arrow_white_24dp, R.raw.felguk_hands_up_for_detroit));
        //Artist3
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music1), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave1_cochise));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music2), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave2_show_me_how_to_live));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music3), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave3_gasoline));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music4), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave4_what_you_are));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music5), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave5_like_a_stone));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music6), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave6_set_it_off));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music7), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave7_shadow_on_the_sun));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music8), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave8_i_am_the_highway));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music9), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave9_exploder));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music10), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave10_hypnotize));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music11), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave11_bring_back));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music12), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave12_light_my_way));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music13), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave13_getaway_car));
        words.add(new Word(getString(R.string.artist3) + "\n" + getString(R.string.artist3music14), R.drawable.ic_play_arrow_white_24dp, R.raw.audioslave14_the_last_remaining_light));

        final WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {

                //Found the position that was clicked
                final Word word = words.get(position);

                //Config player to correct position choosed
                mMediaPlayer = MediaPlayer.create(AllSongs.this, word.getAudioResourceId());

                //Start the song
                mMediaPlayer.start();

                //Callback for action when the audio stopped
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {

                        Word songPosition = words.get(position);

                        // Change the color when the audio selected has finish ??? ERROR HERE, function will be finish for next update.
                        // selectPosition = MediaPlayer.create(AllSongs.this, songPosition.getAudioResourceId());
                        //selectPosition.setTextColor ????????

                        // Show a toast messagem when the audio selected has finish
                        String figureOutMusicName = songPosition.getMusicName().toUpperCase();
                        Toast.makeText(AllSongs.this, "The song " + figureOutMusicName + " is finished", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}