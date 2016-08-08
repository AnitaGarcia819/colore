package edu.csumb.garc4464.colore.colore.BoardGameMenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import edu.csumb.garc4464.colore.R;

public class BoardGameMenuActivity extends Activity {

//    @Inject BoardGameMenuLayout mBoardGameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_game);

        OptionsMenuDialog dialog = OptionsMenuDialog.create(this);
        dialog.show();
    }


    // TODO: This will be refactored
 //   BoardGameMenuComponent component = DaggerBoardGameMenuActivity_BoardGameMenuComponent.builder()
//                .boardGameMenuModule(new BoardGameMenuModule(this)).build();
//        component.inject(this);

//    @Component(modules = {BoardGameMenuModule.class})
//    interface BoardGameMenuComponent {
//        void inject(BoardGameMenuActivity boardGameMenuActivity);
//    }

//    @SuppressWarnings("unused")
//    @Module
//    static class BoardGameMenuModule {
//
//        private Context mContext;
////        private BoardGameMenuLayout.Listener mBoardGameLayoutListener;
//
//        public BoardGameMenuModule(Context context) {
//            mContext = context;
////            mBoardGameLayoutListener = listener;
//        }
////
////        @NonNull
////        @Provides
////        BoardGameMenuLayout providesBoardGameMenuLayout() {return new BoardGameMenuLayout(mContext, mBoardGameLayoutListener);}
//    }
}
