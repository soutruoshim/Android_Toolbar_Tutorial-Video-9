package android_in_5_minutes.com.mytoolbarapplication_video9;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by renato on 20/08/2016.
 */
public class SearchableProvider extends SearchRecentSuggestionsProvider {

    public static final String AUTHORITY = "android_in_5_minutes.com.mytoolbarapplication_video9.SearchableProvider";
    public static final int MODE = DATABASE_MODE_QUERIES;

    public SearchableProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }


}
