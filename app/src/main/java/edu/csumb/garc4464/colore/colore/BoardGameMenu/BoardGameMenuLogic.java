package edu.csumb.garc4464.colore.colore.BoardGameMenu;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by anitagarcia on 7/23/16.
 */
public class BoardGameMenuLogic extends Application {

    @Inject BoardGameMenuLayout mBoardGameMenuLayout;

    public BoardGameMenuLogic(@NonNull AppCompatActivity appCompatActivity) {
        new BoardGameMenuLogic(appCompatActivity, null);
    }

    public BoardGameMenuLogic(@NonNull AppCompatActivity appCompatActivity, @Nullable BoardGameMenuComponent component) {
        if (component == null) {
            component = Dagger_VehicleComponent.builder().vehicleModule(
                    new BoardGameMenuModule(appCompatActivity)).build();
        }
        component.inject(this);
    }

    @Singleton
    @Component(modules = {BoardGameMenuLayout.class})
    @Module
    interface BoardGameMenuComponent {
        void inject(BoardGameMenuLogic boardGameMenuLogic);
    }

    @SuppressWarnings("unused")
    @Module
    static class BoardGameMenuModule {
        @NonNull AppCompatActivity mAppCompatActivity;
        @NonNull BoardGameMenuLayout mBoardGameMenuLayout;

        public BoardGameMenuModule(@NonNull AppCompatActivity appCompatActivity) {
            mAppCompatActivity = appCompatActivity;
        }

        @NonNull
        @Provides
        BoardGameMenuLayout providesBoardGameMenuLayout() {return new BoardGameMenuLayout();}
    }
}
