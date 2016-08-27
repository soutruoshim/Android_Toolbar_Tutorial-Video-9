package android_in_5_minutes.com.mytoolbarapplication_video9;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.search_results_toolbar);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent searchIntent = getIntent();
        if(Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {
            query = searchIntent.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle(query);
            Toast.makeText(SearchResultsActivity.this, query, Toast.LENGTH_SHORT).show();

            SearchRecentSuggestions searchRecentSuggestions = new SearchRecentSuggestions(this, SearchableProvider.AUTHORITY, SearchableProvider.MODE);
            searchRecentSuggestions.saveRecentQuery(query, null);
        }

        String[] countries = getResources().getStringArray(R.array.countries);
        ArrayList<String> searchResults = new ArrayList<String>();
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].toLowerCase().contains(query.toLowerCase()))
                searchResults.add(countries[i]);
        }

        ListView listView_search_results = (ListView) findViewById(R.id.listView_searchResults);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, searchResults);
        listView_search_results.setAdapter(adapter);
    }
}
