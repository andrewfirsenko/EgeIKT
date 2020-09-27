package ru.cutepool.egeikt.app;

import android.app.Application;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class App extends Application {

    private static App instance;
    private Cicerone<Router> cicerone;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        cicerone = Cicerone.create();
    }

    public static App getInstance() {
        return instance;
    }

    public Router router() {
        return cicerone.getRouter();
    }

    public NavigatorHolder navigatorHolder() {
        return cicerone.getNavigatorHolder();
    }
}
