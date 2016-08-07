package edu.csumb.garc4464.colore.colore.BoardGameMenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.csumb.garc4464.colore.R;

/**
 * Created by anitagarcia on 7/23/16.
 */
public class BoardGameMenuLayout extends FrameLayout {

    @BindView(R.id.new_game) Button mNewGameButton;
    private Listener mListener;

    public BoardGameMenuLayout(Context context, BoardGameMenuLayout.Listener listener) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.options_menu_dialog, this);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.new_game)
    public void onNewGameClick() {
        Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
        mListener.onNewGameClicked();
    }

    interface Listener {
        void onNewGameClicked();
    }
}
