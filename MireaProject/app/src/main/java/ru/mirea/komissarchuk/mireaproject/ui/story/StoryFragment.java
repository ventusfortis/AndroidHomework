package ru.mirea.komissarchuk.mireaproject.ui.story;

import android.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import ru.mirea.komissarchuk.mireaproject.databinding.FragmentStoryBinding;
import ru.mirea.komissarchuk.mireaproject.ui.story.db.App;
import ru.mirea.komissarchuk.mireaproject.ui.story.db.Story;
import ru.mirea.komissarchuk.mireaproject.ui.story.db.StoryDB;
import ru.mirea.komissarchuk.mireaproject.ui.story.db.StoryDao;


public class StoryFragment extends Fragment {
    StoryDB db;
    StoryDao storyDao;
    Story story;
    private FragmentStoryBinding binding;

    public StoryFragment() {}
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentStoryBinding.inflate(inflater, container, false);

        db = App.getInstance().getDatabase();
        storyDao = db.storyDao();

        StoryAdapter adapter = new StoryAdapter(getActivity(), db);
        binding.recycler.setAdapter(adapter);

        binding.addStoryButton.setOnClickListener(this::onClickAddStory);


        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void onClickAddStory(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final EditText storyTitle = new EditText(getContext());
        storyTitle.setSingleLine(true);
        alert.setTitle("Create a story");
        alert.setMessage("Story name");

        alert.setView(storyTitle);

        alert.setPositiveButton("Next", (dialogInterface, i) -> {
            String titleValue = storyTitle.getText().toString();
            acceptStoryContent(titleValue);
        });

        alert.setNegativeButton("Cancel", (dialogInterface, i) -> {});

        alert.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void acceptStoryContent(String storyTitle){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final EditText storyContent = new EditText(getContext());
        alert.setTitle("Create a story");
        alert.setMessage("Enter the story:");
        alert.setView(storyContent);

        alert.setPositiveButton("Create", (dialogInterface, i) -> {
            String storyValue = storyContent.getText().toString();
            createStory(storyTitle, storyValue);
        });

        alert.setNegativeButton("Cancel", (dialogInterface, i) -> {});
        alert.show();
    }

    private void createStory(String title, String content){
        story = new Story(title, content);
        storyDao.insert(story);
    }
}