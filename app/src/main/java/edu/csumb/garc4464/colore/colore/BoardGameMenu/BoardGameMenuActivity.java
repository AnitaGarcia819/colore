package edu.csumb.garc4464.colore.colore.BoardGameMenu;

import android.app.Activity;
import android.os.Bundle;

import edu.csumb.garc4464.colore.R;
import edu.csumb.garc4464.colore.colore.OptionsMenu.OptionsMenuDialog;

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
