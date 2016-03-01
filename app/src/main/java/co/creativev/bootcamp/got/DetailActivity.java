package co.creativev.bootcamp.got;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import co.creativev.bootcamp.got.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHARACTER = "character";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_detail);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
//        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }



        GoTCharacter goTCharacter = getIntent().getParcelableExtra(EXTRA_CHARACTER);
        GoTCharacterViewModel goTCharacterViewModel = new GoTCharacterViewModel(goTCharacter);
//        goTCharacterViewModel.getFullName();
//        setTitle(goTCharacterViewModel.getFullName(goTCharacter));


        Picasso.with(this)
                .load(Uri.parse(goTCharacter.getFullUrl()))
                .placeholder(R.drawable.profile_placeholder_full)
                .error(R.drawable.profile_placeholder_error_full)
                .into((ImageView) findViewById(R.id.image_character));

//        ((ImageView) findViewById(R.id.image_house)).setImageResource(goTCharacter.getHouseResId());
//        ((TextView) findViewById(R.id.text_house_name)).setText(goTCharacter.getHouse());
//        TextView characterDetails = (TextView) findViewById(R.id.text_character_story);
//        characterDetails.setText(goTCharacter.getDescription());
//
//        int color = goTCharacterViewModel.getColor();
////        int color = goTCharacter.isAlive() ? Color.GREEN : Color.RED;
//
//        characterDetails.setTextColor(color);

        binding.setVariable(co.creativev.bootcamp.got.BR.goTCharacter, goTCharacterViewModel);
//        binding.setGotCharacter(goTCharacterViewModel);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
