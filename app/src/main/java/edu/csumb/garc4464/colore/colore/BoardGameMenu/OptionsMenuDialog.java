package edu.csumb.garc4464.colore.colore.BoardGameMenu;

import android.app.AlertDialog;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.csumb.garc4464.colore.R;

/**
 * Created by ben on 8/7/16.
 */
public class OptionsMenuDialog extends AlertDialog {

    public OptionsMenuDialog(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.options_menu_dialog, null);
        setView(view);
        ButterKnife.bind(this, view);
    }

    static OptionsMenuDialog create(Context context) {
        OptionsMenuDialog optionsMenuDialog = new OptionsMenuDialog(context);
        optionsMenuDialog.setCanceledOnTouchOutside(false);
        return optionsMenuDialog;
    }

    @OnClick(R.id.new_game)
    public void onNewGame() {
        Toast.makeText(getContext(), "TEST", Toast.LENGTH_SHORT).show();
    }
}
